package com.shepherdjerred.tipper

class TipCalculatorModel {

    var cost: Float = 0F
    var tipPercent: Float = 0F

    fun calcTip(): Float {
        return cost * (tipPercent / 100)
    }

    fun calcTotal(): Float {
        return cost + calcTip()
    }
}

