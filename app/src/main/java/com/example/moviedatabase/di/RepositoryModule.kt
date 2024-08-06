package com.example.moviedatabase.di

import com.example.moviedatabase.allMovies.data.AllMoviesRepositoryImpl
import com.example.moviedatabase.allMovies.domain.AllMoviesRepository
import com.example.moviedatabase.allShows.data.AllShowsRepositoryImpl
import com.example.moviedatabase.allShows.domain.AllShowsRepository
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

    @Binds
    @Singleton
    abstract fun bindAllShowsRepository(implements: AllShowsRepositoryImpl): AllShowsRepository

}