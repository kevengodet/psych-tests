package com.psychtests.ui.screens.taking

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.psychtests.R
import com.psychtests.data.model.Question
import com.psychtests.viewmodel.TestTakingViewModel
import com.psychtests.util.ScoringEngine

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TestTakingScreen(
    testId: String,
    language: String,
    onBack: () -> Unit,
    onTestCompleted: () -> Unit,
    viewModel: TestTakingViewModel = hiltViewModel()
) {
    val test by viewModel.test.collectAsState()
    val answers by viewModel.answers.collectAsState()
    val currentQuestion by viewModel.currentQuestion.collectAsState()
    val isCompleted by viewModel.isCompleted.collectAsState()
    val scoreResult by viewModel.scoreResult.collectAsState()

    val currentTest = test
    if (currentTest == null) {
        Scaffold(
            topBar = { TopAppBar(title = { Text("") }, navigationIcon = { BackButton(onBack) }) }
        ) { padding ->
            Box(Modifier.padding(padding).fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(stringResource(R.string.home_title))
            }
        }
        return
    }

    if (isCompleted) {
        ResultScreen(
            testTitle = currentTest.title[language] ?: "",
            scoreResult = scoreResult,
            language = language,
            onBack = onBack,
            onRetake = {
                viewModel.reset()
            }
        )
        return
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(currentTest.title[language] ?: "", maxLines = 1) },
                navigationIcon = { BackButton(onBack) }
            )
        },
        bottomBar = {
            NavigationBar {
                val questionCount = currentTest.questions.size
                Text(
                    text = stringResource(R.string.question_of, currentQuestion + 1, questionCount),
                    style = MaterialTheme.typography.labelMedium,
                    modifier = Modifier.weight(1f).align(Alignment.CenterVertically),
                    textAlign = TextAlign.Center
                )
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            // Progress indicator
            LinearProgressIndicator(
                progress = { (currentQuestion + 1).toFloat() / currentTest.questions.size },
                modifier = Modifier.fillMaxWidth().testTag("LinearProgressIndicator")
            )
            Spacer(Modifier.height(16.dp))

            val question = currentTest.questions[currentQuestion]
            QuestionView(
                question = question,
                language = language,
                selectedAnswer = answers[question.id],
                onAnswerSelected = { value ->
                    viewModel.answer(question.id, value)
                }
            )

            Spacer(Modifier.height(24.dp))

            // Navigation buttons
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                if (currentQuestion > 0) {
                    OutlinedButton(onClick = { viewModel.goToPrevious() }) {
                        Text(stringResource(R.string.previous))
                    }
                } else {
                    Spacer(Modifier.weight(1f))
                }

                if (currentQuestion < currentTest.questions.size - 1) {
                    Button(
                        onClick = { viewModel.goToNext() },
                        enabled = answers.containsKey(question.id)
                    ) {
                        Text(stringResource(R.string.next))
                    }
                } else {
                    Button(
                        onClick = { viewModel.submit() },
                        enabled = viewModel.canSubmit()
                    ) {
                        Text(stringResource(R.string.submit))
                    }
                }
            }
        }
    }
}

@Composable
private fun QuestionView(
    question: Question,
    language: String,
    selectedAnswer: Int?,
    onAnswerSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = question.text[language] ?: question.text["en"] ?: "",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Medium
        )
        Spacer(Modifier.height(16.dp))

        question.options.forEach { option ->
            val isSelected = selectedAnswer == option.value
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
                    .clickable { onAnswerSelected(option.value) },
                colors = CardDefaults.cardColors(
                    containerColor = if (isSelected) {
                        MaterialTheme.colorScheme.primaryContainer
                    } else {
                        MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f)
                    }
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = isSelected,
                        onClick = { onAnswerSelected(option.value) }
                    )
                    Spacer(Modifier.width(8.dp))
                    Text(
                        text = option.label[language] ?: option.label["en"] ?: "",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ResultScreen(
    testTitle: String,
    scoreResult: ScoringEngine.ScoreResult?,
    language: String,
    onBack: () -> Unit,
    onRetake: () -> Unit
) {
    Scaffold(
        topBar = { CenterAlignedTopAppBar(title = { Text(stringResource(R.string.results_title)) }) }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            val result = scoreResult
            if (result == null) {
                Text(stringResource(R.string.results_title))
                return@Column
            }

            // Score circle
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp),
                contentAlignment = Alignment.Center
            ) {
                Card(
                    modifier = Modifier.size(160.dp),
                    shape = MaterialTheme.shapes.extraLarge,
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = "${result.totalScore.toInt()} / ${result.maxScore.toInt()}",
                                style = MaterialTheme.typography.headlineMedium,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(Modifier.height(4.dp))
                            Text(
                                text = stringResource(R.string.your_score).lowercase(),
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
            }

            // Severity label
            Text(
                text = result.severityLabel,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.height(16.dp))

            // Interpretation
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = result.interpretation,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(16.dp)
                )
            }

            Spacer(Modifier.height(16.dp))

            // Subscale results if available
            if (result.subscaleResults.isNotEmpty()) {
                Text(
                    text = stringResource(R.string.severity),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Spacer(Modifier.height(8.dp))
                result.subscaleResults.forEach { (name, subResult) ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    ) {
                        Column(modifier = Modifier.padding(12.dp)) {
                            Text(
                                text = name,
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Medium
                            )
                            Spacer(Modifier.height(4.dp))
                            Text(
                                text = "${subResult.score.toInt()} / ${subResult.maxScore.toInt()} — ${subResult.severityLabel ?: ""}",
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                }
            }

            Spacer(Modifier.height(24.dp))

            // Important disclaimer
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer
                )
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = stringResource(R.string.disclaimer_title),
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(
                        text = stringResource(R.string.disclaimer_text),
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }

            Spacer(Modifier.height(24.dp))

            // Actions
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                OutlinedButton(
                    onClick = onRetake,
                    modifier = Modifier.weight(1f)
                ) {
                    Text(stringResource(R.string.retake))
                }
                Button(
                    onClick = onBack,
                    modifier = Modifier.weight(1f)
                ) {
                    Text(stringResource(R.string.back))
                }
            }
        }
    }
}

@Composable
private fun BackButton(onClick: () -> Unit) {
    IconButton(onClick = onClick) {
        Text("←", style = MaterialTheme.typography.titleLarge)
    }
}