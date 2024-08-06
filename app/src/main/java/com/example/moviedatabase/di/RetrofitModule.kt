package com.example.moviedatabase.di

import com.example.moviedatabase.BuildConfig
import com.example.moviedatabase.util.Constant.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RetrofitModule {

    @Provides
    fun provideLogInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    @Provides
    fun provideHeaderInterceptor() = Interceptor { chain ->
        val request: Request = chain.request().newBuilder().apply {
            header("Content-Type", "application/json")
            header("Authorization", "Bearer ${BuildConfig.TMDB_TOKEN}")
        }.build()
        chain.proceed(request)
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        logInterceptor: HttpLoggingInterceptor,
        headerInterceptor: Interceptor
    ): Retrofit {
        val builder = OkHttpClient.Builder()
        builder.addInterceptor(logInterceptor)
        builder.addInterceptor(headerInterceptor)
        val client = builder.build()
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
        return retrofitBuilder.build()
    }
}