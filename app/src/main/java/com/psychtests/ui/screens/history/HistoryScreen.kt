package com.psychtests.ui.screens.history

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.psychtests.R
import com.psychtests.data.model.SeverityLevel
import com.psychtests.data.model.TestResult
import com.psychtests.viewmodel.HistoryViewModel
import java.text.SimpleDateFormat
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoryScreen(
    viewModel: HistoryViewModel = hiltViewModel(),
    onBack: () -> Unit,
    onResultClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    val results by viewModel.results.collectAsState()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(stringResource(R.string.history_title)) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = stringResource(R.string.back))
                    }
                }
            )
        }
    ) { padding ->
        if (results.isEmpty()) {
            Box(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(R.string.history_empty),
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                    modifier = Modifier.padding(24.dp)
                )
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(results, key = { it.id }) { result ->
                    HistoryResultCard(
                        result = result,
                        onClick = { onResultClick(result.id) },
                        onDelete = { viewModel.deleteResult(result.id) }
                    )
                }
            }
        }
    }
}

@Composable
private fun HistoryResultCard(
    result: TestResult,
    onClick: () -> Unit,
    onDelete: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        onClick = onClick
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = result.testTitle,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    text = "${result.score.toInt()} / ${result.maxScore.toInt()}",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = result.severityLabel,
                    style = MaterialTheme.typography.bodyMedium,
                    color = severityColor(result.severity)
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    text = formatDate(result.completedAt.toString()),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            IconButton(onClick = onDelete) {
                Text("🗑", style = MaterialTheme.typography.titleMedium)
            }
        }
    }
}

private fun severityColor(severity: SeverityLevel): androidx.compose.ui.graphics.Color =
    when (severity) {
        SeverityLevel.NONE -> androidx.compose.ui.graphics.Color(0xFF4CAF50)
        SeverityLevel.MINIMAL -> androidx.compose.ui.graphics.Color(0xFF8BC34A)
        SeverityLevel.MILD -> androidx.compose.ui.graphics.Color(0xFF9E9D24)
        SeverityLevel.MODERATE -> androidx.compose.ui.graphics.Color(0xFFFF9800)
        SeverityLevel.MODERATELY_SEVERE -> androidx.compose.ui.graphics.Color(0xFFFF5722)
        SeverityLevel.SEVERE -> androidx.compose.ui.graphics.Color(0xFFF44336)
        SeverityLevel.EXTREME -> androidx.compose.ui.graphics.Color(0xFFB71C1C)
    }

private fun formatDate(dateString: String): String {
    return try {
        val raw = dateString.split("T").firstOrNull() ?: dateString
        raw
    } catch (e: Exception) {
        dateString
    }
}