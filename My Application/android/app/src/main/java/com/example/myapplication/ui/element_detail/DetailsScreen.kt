package com.example.myapplication.ui.element_detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.example.myapplication.domain.model.ElemDetails
import org.koin.androidx.compose.koinViewModel

@Composable
fun DetailsScreen(
    onUpClick: () -> Unit,
    viewModel: DetailsViewModel = koinViewModel()
    ) {
    val details by viewModel.details.collectAsStateWithLifecycle()

    DetailsScreen(
        details = details,
        onUpClick = onUpClick
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DetailsScreen(
    details: ElemDetails,
    onUpClick: () -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),//sa fie pe tot ecranul
        topBar = {
            CenterAlignedTopAppBar(
                navigationIcon = {
                    IconButton(onClick = onUpClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                            contentDescription = "Back",
                        )
                    }
                },
                title = { Text(text = details.objectID.toString()) },
                modifier = Modifier.fillMaxWidth(),
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            if (details.primaryImage.isNotBlank()) {
                AsyncImage(
                    model = details.primaryImage,
                    contentDescription = "Artwork Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp),
                    contentScale = ContentScale.Fit
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
            Column(
                modifier = Modifier.verticalScroll(rememberScrollState())
            ) {
                Text(text = "Object Name: ${details.objectName}", fontSize = 22.sp)
                Text(text = "Title: ${details.title}", fontSize = 22.sp)
                Text(text = "Period: ${details.period}", fontSize = 22.sp)
                Text(text = "Culture: ${details.culture}", fontSize = 22.sp)
                Text(text = "Accession Year: ${details.accessionYear}", fontSize = 22.sp)
                Text(text = "Department: ${details.department}", fontSize = 22.sp)
                Text(text = "Accession Number: ${details.accessionNumber}", fontSize = 22.sp)
                Text(text = "Is Public Domain: ${details.isPublicDomain}", fontSize = 22.sp)
                Text(text = "Is Highlight: ${details.isHighlight}", fontSize = 22.sp)

            }
        }
    }
}
