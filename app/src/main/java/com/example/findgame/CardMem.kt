package com.example.findgame

data class CardMem(
    val id: Int,
    val imageResId: Int,
    var isFlipped: Boolean = false,
    var isFound: Boolean = false
) {
    fun flipCard(){
        isFlipped = !isFlipped
    }
}


data class CardPic(
    val imageResId: Int,
)
data class MemoryGame(
    val AllCard: List<CardMem>,
    val imageCompare: Int,
    val idCardOne: Int,
    val idCardTwo: Int,
)
