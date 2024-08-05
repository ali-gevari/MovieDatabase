package com.example.moviedatabase.di

import com.example.moviedatabase.allMovies.data.repository.AllMoviesRepositoryImpl
import com.example.moviedatabase.allMovies.domain.repository.AllMoviesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindAllMoviesRepository(implements: AllMoviesRepositoryImpl): AllMoviesRepository

}