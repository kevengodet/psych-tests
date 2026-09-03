package com.psychtests

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.psychtests.ui.navigation.Destinations
import com.psychtests.ui.screens.history.HistoryScreen
import com.psychtests.ui.screens.home.HomeScreen
import com.psychtests.ui.screens.result.ResultDetailScreen
import com.psychtests.ui.screens.taking.TestTakingScreen
import com.psychtests.ui.theme.PsychTestsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PsychTestsTheme {
                val navController = rememberNavController()
                val backStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = backStackEntry?.destination

                Scaffold(
                    bottomBar = {
                        val route = currentDestination?.route
                        if (route == Destinations.Home.route || route == Destinations.History.route) {
                            NavigationBar {
                                NavigationBarItem(
                                    selected = route == Destinations.Home.route,
                                    onClick = {
                                        navController.navigate(Destinations.Home.route) {
                                            popUpTo(Destinations.Home.route) { inclusive = true }
                                            launchSingleTop = true
                                        }
                                    },
                                    icon = { Icon(Icons.Default.Home, contentDescription = null) },
                                    label = { Text(stringResource(R.string.nav_home)) }
                                )
                                NavigationBarItem(
                                    selected = route == Destinations.History.route,
                                    onClick = {
                                        navController.navigate(Destinations.History.route) {
                                            popUpTo(Destinations.Home.route)
                                            launchSingleTop = true
                                        }
                                    },
                                    icon = { Icon(Icons.Default.History, contentDescription = null) },
                                    label = { Text(stringResource(R.string.nav_history)) }
                                )
                            }
                        }
                    }
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = Destinations.Home.route,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable(Destinations.Home.route) {
                            HomeScreen(
                                onTestSelected = { testId, language ->
                                    navController.navigate(Destinations.TestTaking.createRoute(testId, language))
                                },
                                onHistoryClick = {
                                    navController.navigate(Destinations.History.route)
                                }
                            )
                        }
                        composable(Destinations.History.route) {
                            HistoryScreen(
                                onBack = { navController.popBackStack() },
                                onResultClick = { resultId ->
                                    navController.navigate("result/$resultId")
                                }
                            )
                        }
                        composable(Destinations.TestTaking.route) { backStackEntry ->
                            val testId = backStackEntry.arguments?.getString("testId") ?: ""
                            val lang = backStackEntry.arguments?.getString("language") ?: "en"
                            TestTakingScreen(
                                testId = testId,
                                language = lang,
                                onBack = { navController.popBackStack() },
                                onTestCompleted = { navController.popBackStack() }
                            )
                        }
                        composable(Destinations.ResultDetail.route) { backStackEntry ->
                            val resultId = backStackEntry.arguments?.getString("resultId")?.toLongOrNull() ?: 0L
                            ResultDetailScreen(
                                resultId = resultId,
                                onBack = { navController.popBackStack() }
                            )
                        }
                    }
                }
            }
        }
    }
}