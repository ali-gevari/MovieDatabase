package com.example.moviedatabase.details.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviedatabase.details.domain.ProgramDetailsInteractor
import com.example.moviedatabase.util.extensions.toNetworkError
import com.example.moviedatabase.globalEvents.Event
import com.example.moviedatabase.search.domain.entity.ProgramType
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
class ProgramDetailsViewModel @Inject constructor(
    private val programDetailsInteractor: ProgramDetailsInteractor
) : ViewModel() {

    private val _state = MutableStateFlow(ProgramDetailsViewState())
    val state = _state.asStateFlow()

    fun getProgramDetails(programId: String, programType: ProgramType) {
        viewModelScope.launch {
            programDetailsInteractor(programId, programType)
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
                .collect { programDetails ->
                    _state.update {
                        it.copy(programDetails = programDetails)
                    }
                }
        }
    }
}