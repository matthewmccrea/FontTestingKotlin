package ar.edu.ort.testingapp.screens.PeopleList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import ar.edu.ort.testingapp.data.People
import ar.edu.ort.testingapp.data.fakePeopleList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


sealed interface PeopleUiState {
    val isLoading: Boolean

    data class Init(
        override val isLoading: Boolean
    ) : PeopleUiState
}

private data class PeopleViewModelState(
    val isLoading: Boolean = false
) {
    fun toUiState(): PeopleUiState = PeopleUiState.Init(isLoading)
}

class PeopleList : ViewModel() {

    private var _people = MutableLiveData<List<People>>()

    private val viewModelState = MutableStateFlow(
        PeopleViewModelState(
            isLoading = true
        )
    )

    val uiState = viewModelState.map(PeopleViewModelState::toUiState)
        .stateIn(
            viewModelScope,
            SharingStarted.Eagerly,
            viewModelState.value.toUiState()
        )

    init {
        refresh()
    }

    fun getPeople(): List<People>? = _people.value

    fun setPeople(list: List<People>) {
        _people.value = list
    }

    fun refresh() {
        viewModelState.update { it.copy(isLoading = true) }

        viewModelScope.launch {
            setPeople(fakePeopleList)

            viewModelState.update {
                it.copy(isLoading = false)
            }
        }
    }

    companion object {
        fun provideFactory(): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return PeopleList() as T
            }
        }
    }
}