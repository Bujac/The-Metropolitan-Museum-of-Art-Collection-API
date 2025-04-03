package com.example.myapplication.ui.element_list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.koinViewModel

@Composable
fun SearchViewScreen(
    onResultClick: (Int) -> Unit,
    viewModel: SearchViewModel = koinViewModel(),
){
    val searchResults by viewModel.searchResults.collectAsStateWithLifecycle()
    val searchText by viewModel.searchText.collectAsStateWithLifecycle()

    SearchViewScreenPrivate(
        searchResults = searchResults,
        onResultClick = onResultClick,
        searchText = searchText,
        onSearchTextChange = viewModel::onSearchTextChange,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SearchViewScreenPrivate(
    searchResults: Array<Int>,
    onResultClick: (Int) -> Unit,
    searchText: String,
    onSearchTextChange: (String) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = if (searchResults.isEmpty() && searchText.isEmpty()) Arrangement.Center else Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    )

    {
        Spacer(modifier = Modifier.height(50.dp))

        Text(
            text = "The Metropolitan Museum of Art",
            fontSize = 30.sp,
            lineHeight = 40.sp,
            color = Color(0xFF374F72),
            textAlign = TextAlign.Center,
            modifier = Modifier            .fillMaxWidth()
                .padding(bottom = 16.dp)    )

        TextField(
            value = searchText,
            onValueChange = onSearchTextChange,
            modifier = Modifier.fillMaxWidth(),
            placeholder = { (Text(text = "Introdu ID")) }
        )
        Spacer(modifier = Modifier.height(16.dp))
        
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            items(searchResults.toList()) { id ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "$id",
                        fontSize = 20.sp,
                        modifier = Modifier
                            .weight(1f)
                            .clickable { onResultClick(id) },
                    )
                }
            }
        }
    }
}