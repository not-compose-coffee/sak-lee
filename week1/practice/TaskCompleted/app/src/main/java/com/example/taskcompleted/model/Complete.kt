package com.example.taskcompleted.model

import androidx.compose.ui.graphics.painter.Painter

data class Complete(
    val imagePainter: Painter,
    val allComplete: String,
    val niceWork: String,
)
