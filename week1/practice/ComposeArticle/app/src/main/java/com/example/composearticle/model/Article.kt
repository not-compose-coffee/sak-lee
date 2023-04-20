package com.example.composearticle.model

import androidx.compose.ui.graphics.painter.Painter

data class Article(
    val imagePainter: Painter,
    val title: String,
    val shortDescription: String,
    val longDescription: String
)
