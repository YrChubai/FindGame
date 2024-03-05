package com.example.findgame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.findgame.ui.theme.FindGameTheme
import com.example.findgame.view.EndGamePopup
import com.example.findgame.view.GameScene
import com.example.findgame.view.MenuView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = "route_screen")  {
                composable("route_screen") {
                    MenuView(navController)
                }
                composable("game") {
                    GameScene(navController)
                }
                composable("end") {
                    EndGamePopup(navController)
                }
            }
        }
    }
}

