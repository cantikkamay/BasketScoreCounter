package com.cantikka.basketscorecounter

import androidx.lifecycle.ViewModel

class ScoreViewModel : ViewModel() {
    var scoreA: Int = 0
        private set
    var scoreB: Int = 0
        private set

    fun incrementSkorA(poin: Int = 1) {
        scoreA += poin
    }

    fun incrementSkorB(poin: Int = 1) {
        scoreB += poin
    }

    fun resetSkor() {
        scoreA = 0
        scoreB = 0
    }
}
