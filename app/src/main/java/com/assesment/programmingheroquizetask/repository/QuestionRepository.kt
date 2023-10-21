package com.assesment.programmingheroquizetask.repository

import android.util.Log
import com.assesment.programmingheroquizetask.data.DataOrException
import com.assesment.programmingheroquizetask.model.Question
import com.assesment.programmingheroquizetask.network.QuestionService
import java.io.IOException
import javax.inject.Inject

class QuestionRepository @Inject constructor(private val api: QuestionService) {
     suspend fun getAllQuestions(): DataOrException<Question, Boolean, Exception> {
          val listOfQuestions = DataOrException<Question, Boolean, Exception>()

          try {
               listOfQuestions.loading = true
               val response = api.getAllQuestions()

               listOfQuestions.data = response
               listOfQuestions.loading = false
          } catch (exception: IOException) {
               listOfQuestions.e = exception
               Log.e("Exc", "getAllQuestions: ${exception.localizedMessage}")
          } catch (exception: Exception) {
               listOfQuestions.e = exception
               Log.e("Exc", "getAllQuestions: ${exception.localizedMessage}")
          }

          return listOfQuestions
     }
}
