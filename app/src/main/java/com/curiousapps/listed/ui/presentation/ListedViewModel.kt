package com.curiousapps.listed.ui.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.curiousapps.listed.domain.ListIdItem
import com.curiousapps.listed.domain.ListIdRepository
import com.curiousapps.listed.util.IO_DISPATCHER
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListedViewModel @Inject constructor(
    private val repository: ListIdRepository
) : ViewModel() {

    private val _state = MutableStateFlow(ListedState())
    val state = _state
        .onStart { fetchListIds() }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(4000L),
            ListedState()
        )
//    val state: Flow<ListedState>
//        get() = _state

//    init {
//        fetchListIds()
//    }

    private fun fetchListIds(){
        viewModelScope.launch(IO_DISPATCHER) {
            val result = repository.fetchListIds()
            when{
                result.isSuccess -> {
                    _state.update { it.copy(
                        listIdList = result.getOrNull()!!,
                        isLoading = false
                    ) }
                }
                result.isFailure -> {
                    _state.update { it.copy(
                        listIdList = emptyList(),
                        isLoading = false
                    ) }
                }
            }
        }
    }


    data class ListedState(
        val listIdList: List<ListIdItem> = emptyList(),
        val isLoading: Boolean = true,
    )
}