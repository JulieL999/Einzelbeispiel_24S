package com.example.einzelbeispiel_24s

import java.lang.StringBuilder
import kotlin.collections.ArrayList

class Mathematic {
    fun isPrimeNumber(num: Int) : Boolean {
        var isPrime = true
        for (i in 2..num/2) {
            if (num % i == 0) {
                isPrime = false
                break
            }
        }
        return isPrime
    }

    fun modifyMatrNumber(num: String) : String {
        val listOfInts = ArrayList<Int>()
        for (i in num.indices) {
            val numericValue = Character.getNumericValue(num[i])
            if (!this.isPrimeNumber(numericValue)) {
                listOfInts.add(numericValue)
            }

        }

        return buildString(listOfInts.sorted())
    }

    private fun buildString(listOfInts: List<Int>) : String {
        val builder = StringBuilder()
        for (i in listOfInts.indices) {
            builder.append(listOfInts[i])
        }
        return builder.toString()
    }


}