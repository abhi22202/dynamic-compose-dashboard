package com.example.dynamicdashboard.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dynamicdashboard.data.fake.ListDataGenerator
import com.example.dynamicdashboard.data.model.ListWidgetConfig
import kotlinx.coroutines.launch
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


sealed class ListWidgetState {
    object Loading : ListWidgetState()
    data class Success(val data: List<ListWidgetConfig>) : ListWidgetState()
    data class Error(val message: String) : ListWidgetState()
}

class ListWidgetViewModel(
    private val instanceId: String
) : ViewModel() {

    private val _state =
        mutableStateOf<ListWidgetState>(ListWidgetState.Loading)
    val state: State<ListWidgetState> = _state

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            try {
                val data = ListDataGenerator.getListData(instanceId)
                _state.value = ListWidgetState.Success(data)
            } catch (e: Exception) {
                _state.value =
                    ListWidgetState.Error(e.message ?: "Unknown error")
            }
        }
    }
}

