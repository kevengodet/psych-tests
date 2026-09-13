package com.psychtests.ui.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.psychtests.R
import com.psychtests.BuildConfig
import com.psychtests.data.model.Test
import com.psychtests.data.model.TestCategory
import com.psychtests.viewmodel.HomeViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.collectLatest

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    onTestSelected: (testId: String, language: String) -> Unit,
    onHistoryClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val selectedLanguage by viewModel.selectedLanguage.collectAsState()
    val tests by viewModel.tests.collectAsState()
    var searchQuery by remember { mutableStateOf("") }
    var disclaimerExpanded by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    // Initialize language
    LaunchedEffect(Unit) {
        viewModel.setLanguage("en")
    }

    Column(modifier = modifier.fillMaxSize()) {
        // Header with language selector and history button
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = stringResource(R.string.home_welcome),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = stringResource(R.string.app_version, BuildConfig.VERSION_NAME),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f)
                )
            }
            IconButton(onClick = onHistoryClick) {
                Icon(
                    imageVector = Icons.Default.History,
                    contentDescription = stringResource(R.string.nav_history)
                )
            }
        }

        // Disclaimer card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.secondaryContainer
            )
        ) {
            Column(modifier = Modifier.padding(12.dp)) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        imageVector = Icons.Default.Warning,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onSecondaryContainer,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = stringResource(R.string.disclaimer_title),
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(1f)
                    )
                    TextButton(onClick = { disclaimerExpanded = !disclaimerExpanded }) {
                        Text(if (disclaimerExpanded) "▲" else "▼")
                    }
                }
                if (!disclaimerExpanded) {
                    Text(
                        text = stringResource(R.string.crisis_hotline_us),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                } else {
                    Text(
                        text = stringResource(R.string.disclaimer_text),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = stringResource(R.string.crisis_disclaimer),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = stringResource(R.string.crisis_hotline_us),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                    Text(
                        text = stringResource(R.string.crisis_hotline_uk),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                    Text(
                        text = stringResource(R.string.crisis_hotline_fr),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                    Text(
                        text = stringResource(R.string.crisis_hotline_es),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                }
            }
        }

        // Language selector (UI element - localizable)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            listOf("en" to "English", "fr" to "Français", "es" to "Español").forEach { (code, label) ->
                FilterChip(
                    selected = selectedLanguage == code,
                    onClick = { viewModel.setLanguage(code) },
                    label = { Text(label) },
                    modifier = Modifier.weight(1f)
                )
            }
        }

        // Search field
        OutlinedTextField(
            value = searchQuery,
            onValueChange = {
                searchQuery = it
                viewModel.search(it)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            placeholder = { Text(stringResource(R.string.home_search_hint)) },
            singleLine = true
        )

        // Test list
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = 80.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            val grouped = tests.groupBy { it.category }
            grouped.toSortedMap(compareBy { it.displayOrder }).forEach { (category, categoryTests) ->
                item(key = "header_${category.name}") {
                    val title = when (category) {
                        TestCategory.DEPRESSION -> getDepressionTitle(selectedLanguage)
                        TestCategory.ANXIETY -> getAnxietyTitle(selectedLanguage)
                        TestCategory.STRESS -> getStressTitle(selectedLanguage)
                        TestCategory.TRAUMA -> getTraumaTitle(selectedLanguage)
                        TestCategory.WELLBEING -> getWellbeingTitle(selectedLanguage)
                        TestCategory.SUBSTANCE -> getSubstanceTitle(selectedLanguage)
                        TestCategory.EATING -> getEatingTitle(selectedLanguage)
                        else -> category.name
                    }
                    Text(
                        text = title,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                    )
                }
                items(categoryTests, key = { it.id }) { test ->
                    TestCard(
                        test = test,
                        language = selectedLanguage,
                        onClick = { onTestSelected(test.id, selectedLanguage) }
                    )
                }
            }
        }
    }
}

@Composable
private fun TestCard(
    test: Test,
    language: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = test.title[language] ?: test.title["en"] ?: test.id,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = test.description[language] ?: test.description["en"] ?: "",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 2
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "${test.questions.size} questions · ~${test.estimatedDurationMinutes} min",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                TextButton(onClick = onClick) {
                    Text(stringResource(R.string.test_take))
                }
            }
        }
    }
}

@Composable
fun getDepressionTitle(language: String): String = when (language) {
    "fr" -> "Dépression"
    "es" -> "Depresión"
    else -> "Depression"
}

@Composable
fun getAnxietyTitle(language: String): String = when (language) {
    "fr" -> "Anxiété"
    "es" -> "Ansiedad"
    else -> "Anxiety"
}

@Composable
fun getStressTitle(language: String): String = when (language) {
    "fr" -> "Stress"
    "es" -> "Estrés"
    else -> "Stress"
}

@Composable
fun getTraumaTitle(language: String): String = when (language) {
    "fr" -> "Traumatisme"
    "es" -> "Trauma"
    else -> "Trauma"
}

@Composable
fun getWellbeingTitle(language: String): String = when (language) {
    "fr" -> "Bien-être"
    "es" -> "Bienestar"
    else -> "Well-being"
}

@Composable
fun getSubstanceTitle(language: String): String = when (language) {
    "fr" -> "Consommation"
    "es" -> "Consumo"
    else -> "Substance use"
}

@Composable
fun getEatingTitle(language: String): String = when (language) {
    "fr" -> "Alimentation"
    "es" -> "Alimentación"
    else -> "Eating"
}