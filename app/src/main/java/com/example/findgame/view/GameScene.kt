package com.example.findgame.view

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.findgame.CardMem
import com.example.findgame.GameSceneVM
import com.example.findgame.R
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController


@Composable
fun GameScene(navController: NavController, viewModel: GameSceneVM = viewModel()
) {
    val timeLoaded = remember {
        viewModel.ticks
    }
    val moneyGame = remember {
        viewModel.money
    }
    val counterFind = remember {
        viewModel.counterFind
    }
    MemoryGameGrid()
    if (counterFind.value == 10){
        navController.navigate("end")
    }
    Column {
        Text(text = viewModel.formatTime(timeLoaded.value))
        Text(text = moneyGame.value.toString())
        Text(text = counterFind.value.toString())
    }
}
@Composable
fun MemoryGameGrid(viewModel: GameSceneVM = viewModel()) {
    //val listLoaded = remember { mutableStateListOf<CardMem>()}
    val fav = remember { viewModel.state }


    LazyVerticalGrid(GridCells.Fixed(4)) {
        items(fav.size) { index ->
            Log.d("post",index.toString())
            var cardState = fav[index]
            MemoryCard(card = cardState, index)
        }
    }
}
@Composable
fun MemoryCard(card: CardMem, index: Int, viewModel: GameSceneVM = viewModel()) {
    //var listItem = remember { mutableStateOf(viewModel.cards[index])}
//    val listLoaded = remember { viewModel._cards }
    ///var checked = remember {item.isFlipped}
    Card(
        modifier = Modifier
            .padding(4.dp),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clickable {
                    Log.d("cardCheck", card.toString())
                    if (!card.isFound) {
//                        Log.d("cardCheckAfterOrig", listLoaded[index].toString())
                        viewModel.onCardClicked(card)
                        card.isFlipped = !card.isFlipped
                        Log.d("cardCheckAfter", card.toString())
                    }
                }

        ) {
            if (!card.isFlipped) {
                Image(
                    painter = painterResource(id = card.imageResId),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                )
                Log.d("cardTrue", card.toString())
            } else {
                Image(
                    painter = painterResource(id = R.drawable.icons8_poison),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                )
                Log.d("cardFalse", card.toString())
            }
        }
    }
}