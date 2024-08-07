package com.example.moviedatabase.allShows.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviedatabase.util.extensions.toNetworkError
import com.example.moviedatabase.allShows.domain.AllShowsInteractor
import com.example.moviedatabase.globalEvents.Event
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
class AllShowsViewModel @Inject constructor(
    private val allShowsInteractor: AllShowsInteractor
) : ViewModel() {
    private val _state = MutableStateFlow(AllShowsViewState())
    val state = _state.asStateFlow()

    init {
        getAllShows()
    }

    private fun getAllShows() {
        viewModelScope.launch {
            allShowsInteractor()
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
                .collect { allShows ->
                    _state.update {
                        it.copy(allShows = allShows)
                    }
                }
        }
    }
}