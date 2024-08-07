package com.example.moviedatabase.allMovies.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviedatabase.util.extensions.toNetworkError
import com.example.moviedatabase.allMovies.domain.AllMoviesInteractor
import com.example.moviedatabase.globalEvents.Event
import com.example.moviedatabase.globalStates.ProgramsViewState
import com.example.moviedatabase.util.extensions.sendEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AllMoviesViewModel @Inject constructor(
    private val allMoviesInteractor: AllMoviesInteractor
) : ViewModel() {
    private val _state = MutableStateFlow(ProgramsViewState())
    val state = _state.asStateFlow()

    init {
        getAllMovies()
    }

    private fun getAllMovies() {
        viewModelScope.launch {
            allMoviesInteractor()
                .onStart {
                    _state.update {
                        it.copy(isLoading = true)
                    }
                }
                .catch { error ->
                    val networkError = error.toNetworkError()
                    _state.update {
                        it.copy(error = networkError)
                    }
                    sendEvent(Event.Toast(networkError))
                }
                .onCompletion {
                    _state.update {
                        it.copy(isLoading = false)
                    }
                }
                .collect { allPrograms ->
                    _state.update {
                        it.copy(allPrograms = allPrograms)
                    }
                }
        }
    }
}