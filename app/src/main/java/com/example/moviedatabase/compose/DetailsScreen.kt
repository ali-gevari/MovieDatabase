package com.example.moviedatabase.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

@Composable
fun DetailsScreen(
    details: String? = ""
) {
    val programId = remember(details) { details ?: "detail" }
}