package com.example.moviedatabase.allMovies.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviedatabase.allMovies.domain.repository.AllMoviesRepository
import com.example.moviedatabase.util.Event
import com.example.moviedatabase.util.EventDispatcher.sendEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AllMoviesViewModel @Inject constructor(
    private val allMoviesRepository: AllMoviesRepository
) : ViewModel() {
    private val _state = MutableStateFlow(AllMoviesViewState())
    val state = _state.asStateFlow()

    init {
        getAllMovies()
    }

    private fun getAllMovies() {
        viewModelScope.launch {
            _state.update {
                it.copy(isLoading = true)
            }
            allMoviesRepository.getAllMovies()
                .onRight { allMovies ->
                    _state.update {
                        it.copy(allMovies = allMovies)
                    }
                }
                .onLeft { error ->
                    _state.update {
                        it.copy(error = error.networkCallError.message)
                    }
                    sendEvent(Event.Toast(error.networkCallError.message))
                }
            _state.update {
                it.copy(isLoading = false)
            }
        }
    }
}