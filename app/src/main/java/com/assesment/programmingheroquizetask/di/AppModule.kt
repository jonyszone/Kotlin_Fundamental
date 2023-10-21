package com.assesment.programmingheroquizetask.di

import com.assesment.programmingheroquizetask.network.QuestionService
import com.assesment.programmingheroquizetask.repository.QuestionRepository
import com.assesment.programmingheroquizetask.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideQuestionRepository(api: QuestionService) = QuestionRepository(api)

    @Singleton
    @Provides
    fun provideQuestionApi(): QuestionService {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(QuestionService::class.java)

    }
}