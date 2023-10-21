package com.assesment.programmingheroquizetask.model

data class QuestionX(
    val answers: Answers,
    val correctAnswer: String,
    val question: String,
    val questionImageUrl: String,
    val score: Int
)