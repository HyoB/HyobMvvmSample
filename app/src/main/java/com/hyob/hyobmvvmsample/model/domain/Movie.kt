package com.hyob.hyobmvvmsample.model.domain

data class Movie(
    val title: String,
    val cover: String,
    val rating: Float,
    val year: String,
    val director: String?,
    val starring: String?,
    val link: String
)