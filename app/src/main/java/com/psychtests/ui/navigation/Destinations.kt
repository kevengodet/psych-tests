package com.psychtests.ui.navigation

sealed class Destinations(val route: String) {
    data object Home : Destinations("home")
    data object History : Destinations("history")
    data object TestTaking : Destinations("test/{testId}/{language}") {
        fun createRoute(testId: String, language: String) = "test/$testId/$language"
    }
    data object ResultDetail : Destinations("result/{resultId}")
}