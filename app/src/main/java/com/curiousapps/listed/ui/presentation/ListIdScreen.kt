package com.curiousapps.listed.ui.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.curiousapps.listed.ui.presentation.component.ListIdRow

@Composable
fun ListIdScreen(
    viewModel: ListedViewModel = hiltViewModel()
){
    val state by viewModel.state.collectAsState(initial = ListedViewModel.ListedState())
    val listId = state.listIdList

    GradientBackground()
    if (state.isLoading){
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CircularProgressIndicator(
                modifier = Modifier.size(76.dp),
                color = Color.Red,
                strokeWidth = 6.dp,
                strokeCap = StrokeCap.Round
            )
        }
    }else{
        Column(
            modifier = Modifier
                .padding(16.dp)
                .padding(top = 32.dp)
        ) {
            LazyColumn(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize()
            ) {
                val itemCount = listId.size
                items(itemCount){ index ->
                    ListIdRow(
                        listIdItem = listId[index]
                    )
                }
            }
        }
    }

}

@Composable
fun GradientBackground() {
    val gradient = Brush.linearGradient(
        0.0f to Color.LightGray,
        300.0f to Color.Cyan,
        start = Offset.Zero,
        end = Offset.Infinite
    )
    Box(modifier = Modifier.background(gradient).fillMaxSize())
}