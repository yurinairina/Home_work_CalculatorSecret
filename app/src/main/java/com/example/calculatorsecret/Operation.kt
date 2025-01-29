package com.example.calculatorsecret


class Operation(private val first: Double, private val second: Double) {
    fun sum() = first + second
    fun dif() = first - second
    fun mult() = first * second
    fun div() = first / second
}

