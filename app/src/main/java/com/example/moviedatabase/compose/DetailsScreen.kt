package com.example.moviedatabase.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

@Composable
fun DetailsScreen(
    programId: String? = "",
    programType: String? = ""
) {
    val id = remember(programId) { programId ?: "Unknown ID" }
    val type = remember(programType) { programType ?: "Unknown Type" }
}