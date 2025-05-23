package com.example.myapplication.ui.element_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.repository.ElementsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

class SearchViewModel(
    private val elementsRepository : ElementsRepository,
) : ViewModel() {

    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _searchResults = MutableStateFlow<Array<Int>>(emptyArray())
    val searchResults = _searchResults.asStateFlow()


    fun onSearchTextChange(text: String){
        _searchText.value = text
    }

    init{
        loadData()
    }

    private fun loadData() {

        viewModelScope.launch {
            _searchText
                .debounce(300)
                .distinctUntilChanged()
                .collectLatest { query ->
                    _searchResults.value = elementsRepository.getElements(query).objectIDs
                }
        }
    }
}