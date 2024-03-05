package com.example.findgame

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.findgame.view.EndGamePopup
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.Collections.addAll
import kotlin.time.Duration.Companion.seconds

class GameSceneVM(): ViewModel() {
    //var liveDataList = mutableStateOf<List<CardMem>>(mutableListOf())
//    var liveDataList = mutableListOf<CardMem>()
    val counterFind = mutableStateOf(0)
    val ticks = mutableStateOf(0)
    var openCards: MutableList<CardMem> = mutableListOf()
    val favorities = mutableStateListOf<CardMem>()
    //var liveDataList = mutableStateOf<List<CardMem>>(listOf())
    //    var cards =  mutableStateOf<List<CardMem>>(listOf())
//    val _cards = mutableStateListOf<CardMem>()
//    val cards: List<CardMem> = _cards
    val state = createDuplicatedList()
    var money = mutableStateOf(100)

    init {
        startGame()
    }

    fun startGame() {
        viewModelScope.launch {
            createDuplicatedList()
            while (true) {
                delay(1.seconds)
                ticks.value = ticks.value + 1
                if (ticks.value > 20 && money.value > 10)
                    money.value = money.value - 5

            }
        }
    }

    fun formatTime(seconds: Int): String {
        val minutes = seconds / 60
        val remainingSeconds = seconds % 60
        return "%d:%02d".format(minutes, remainingSeconds)
    }

    fun createDuplicatedList(): SnapshotStateList<CardMem> {
        try {
            val originalList = listOf(
                CardPic(imageResId = R.drawable.icons8_bomb),
                CardPic(imageResId = R.drawable.icons8_chest),
                CardPic(imageResId = R.drawable.icons8_dice),
                CardPic(imageResId = R.drawable.icons8_helmet),
                CardPic(imageResId = R.drawable.icons8_joker),
                CardPic(imageResId = R.drawable.icons8_poison),
                CardPic(imageResId = R.drawable.icons8_portal),
                CardPic(imageResId = R.drawable.icons8_scroll),
                CardPic(imageResId = R.drawable.icons8_staff),
                CardPic(imageResId = R.drawable.icons8_sword),
            )
            val duplicatedList = originalList.flatMapIndexed { index, cardMem ->
                listOf(
                    CardMem(
                        id = index,
                        imageResId = cardMem.imageResId,
                        isFlipped = false,
                        isFound = false
                    ),
                    CardMem(
                        id = index + 10,
                        imageResId = cardMem.imageResId,
                        isFlipped = false,
                        isFound = false
                    )
                )
            }.shuffled()
            val todoList = mutableStateListOf<CardMem>().apply {
                addAll(duplicatedList)
            }
            return todoList
        } catch (e: Exception) {
            Log.d("tester", e.toString())
        }
        return mutableStateListOf()
    }

//




    fun onCardClicked(card: CardMem) {
        if (card.isFlipped) {
            Log.d("Backed","back")
            return
        }
        openCards.add(card)
        if (openCards.size == 2) {
            val areMatching = openCards[0].imageResId == openCards[1].imageResId
            if (areMatching) {
                Log.d("Match","aga")
                openCards.forEach { it.isFound = true
                    Log.d("MatchCards",it.toString())}
            } else {
                Log.d("NotMatch","aga")
                openCards.forEach { it.isFlipped = false }
            }
            openCards.clear()
            counterFind.value = counterFind.value+1
            Log.d("Clear","pso")
        }
    }
}