package com.example.moviedatabase.search.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviedatabase.util.extensions.toNetworkError
import com.example.moviedatabase.globalEvents.Event
import com.example.moviedatabase.globalStates.ProgramsViewState
import com.example.moviedatabase.search.domain.SearchProgramsInteractor
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
class SearchProgramsViewModel @Inject constructor(
    private val searchProgramsInteractor: SearchProgramsInteractor
) : ViewModel() {

    private val _state = MutableStateFlow(ProgramsViewState())
    val state = _state.asStateFlow()

    private val _query = MutableStateFlow("")
    val query = _query.asStateFlow()

    fun updateQuery(query: String) {
        _query.value = query
    }

    fun searchProgram(query: String) {
        viewModelScope.launch {
            searchProgramsInteractor(query)
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