package com.assesment.programmingheroquizetask.network

import com.assesment.programmingheroquizetask.model.Question
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface QuestionService {
    @GET("quiz.jason")
    suspend fun getAllQuestions() : Question

}