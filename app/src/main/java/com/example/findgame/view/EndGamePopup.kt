package com.example.findgame.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.findgame.GameSceneVM
import com.example.findgame.R

@Composable
fun EndGamePopup(navController: NavController, viewModel: GameSceneVM = viewModel()
) {
    Column(modifier = Modifier.fillMaxSize().padding(70.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Box {
            Image(
                painter = painterResource(id = R.drawable.icons8_prize),
                contentDescription = null,
                modifier = Modifier.size(100.dp)
            )
        }
        Text(text = "CONGRATULATION", fontSize = 20.sp)
        Text(text = "Great! You Won!", fontSize = 20.sp)
        Text(text = viewModel.money.value.toString(), fontSize = 20.sp)

        Row {
            Button(onClick = { navController.navigate("route_screen") }) {
                Text(text = "Double Reward", fontSize = 15.sp, color = Color.White)
            }
            Button(onClick = { navController.navigate("route_screen") }, colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)) {
                Image(
                    painter = painterResource(id = R.drawable.icons8_home),
                    contentDescription = null,
                    modifier = Modifier.size(30.dp)
                )
            }
            }
        }
    }


