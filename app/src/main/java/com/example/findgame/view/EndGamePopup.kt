package com.example.findgame.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.findgame.GameSceneVM

@Composable
fun EndGamePopup(navController: NavController, viewModel: GameSceneVM = viewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(16.dp)
        ) {
            Column {
                Text(text = "CONGRATULATION", fontSize = 20.sp)
                Text(text = "Great! You Won!", fontSize = 20.sp)
                Text(text = viewModel.money.value.toString(), fontSize = 20.sp)

                Row {
                    Button(onClick = { navController.navigate("route_screen") }) {
                    }
                    Button(onClick = { navController.navigate("route_screen") }) {
                    }
                }
                }
            }

        }
    }
