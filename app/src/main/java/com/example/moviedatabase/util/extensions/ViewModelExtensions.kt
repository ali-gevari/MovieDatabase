package com.example.moviedatabase.util.extensions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviedatabase.globalEvents.EventDispatcher
import kotlinx.coroutines.launch

fun ViewModel.sendEvent(event: Any){
    viewModelScope.launch {
        EventDispatcher.sendEvent(event)
    }
}