package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    // setup variables
    private var firstNumber: Double = 0.0
    private var secondNumber: Double = 0.0
    private var isMath = false
    private var dotExist = false
    private var operation = 0
    private var fixedTo6 = 0.0
    private var str: String = ""
    private var isResult = false

    // select items
    private lateinit var textView: TextView
    private lateinit var btnOne: Button
    private lateinit var btnTwo: Button
    private lateinit var btnThree: Button
    private lateinit var btnFour: Button
    private lateinit var btnFive: Button
    private lateinit var btnSix: Button
    private lateinit var btnSeven: Button
    private lateinit var btnEight: Button
    private lateinit var btnNine: Button
    private lateinit var btnZero: Button
    private lateinit var btnPlus: Button
    private lateinit var btnMinus: Button
    private lateinit var btnDivide: Button
    private lateinit var btnMultiply: Button
    private lateinit var btnDot: Button
    private lateinit var btnEqual: Button
    private lateinit var btnRemoveLast: Button
    private lateinit var btnSqrt: Button
    private lateinit var btnSquare: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        textView = findViewById(R.id.displayLabel)
        textView.text = ""
        // buttons
        btnOne = findViewById(R.id.button13)
        btnTwo = findViewById(R.id.button14)
        btnThree = findViewById(R.id.button15)
        btnFour = findViewById(R.id.button18)
        btnFive = findViewById(R.id.button19)
        btnSix = findViewById(R.id.button20)
        btnSeven = findViewById(R.id.button22)
        btnEight = findViewById(R.id.button23)
        btnNine = findViewById(R.id.button25)
        btnZero = findViewById(R.id.button28)
        btnMinus = findViewById(R.id.button21)
        btnPlus = findViewById(R.id.button26)
        btnMultiply = findViewById(R.id.button16)
        btnDivide = findViewById(R.id.button36)
        btnDot = findViewById(R.id.button27)
        btnSqrt = findViewById(R.id.button35)
        btnRemoveLast = findViewById(R.id.button29)
        btnSquare = findViewById(R.id.button31)
        btnEqual = findViewById(R.id.button24)
        btnDot.isClickable = false
    }

    fun checkForInt(number: Double) {
        if (number % 1 == 0.0) {
            str = number.toInt().toString()
            textView.text = str
        } else {
            str = number.toString()
            textView.text = str
        }
    }

    fun clickTrue() {
        btnOne.isClickable = true
        btnTwo.isClickable = true
        btnThree.isClickable = true
        btnFour.isClickable = true
        btnFive.isClickable = true
        btnSix.isClickable = true
        btnSeven.isClickable = true
        btnEight.isClickable = true
        btnNine.isClickable = true
        btnZero.isClickable = true
        btnMinus.isClickable = true
        btnMultiply.isClickable = true
        btnDivide.isClickable = true
        btnPlus.isClickable = true
        btnDot.isClickable = true
        btnSqrt.isClickable = true
        btnRemoveLast.isClickable = true
        btnSquare.isClickable = true
        btnEqual.isClickable = true
    }

    fun clickFalse() {
        btnOne.isClickable = false
        btnTwo.isClickable = false
        btnThree.isClickable = false
        btnFour.isClickable = false
        btnFive.isClickable = false
        btnSix.isClickable = false
        btnSeven.isClickable = false
        btnEight.isClickable = false
        btnNine.isClickable = false
        btnZero.isClickable = false
        btnMinus.isClickable = false
        btnMultiply.isClickable = false
        btnDivide.isClickable = false
        btnPlus.isClickable = false
        btnDot.isClickable = false
        btnSqrt.isClickable = false
        btnRemoveLast.isClickable = false
        btnSquare.isClickable = false
        btnEqual.isClickable = false
    }

    fun miniClickTrue() {
        btnDot.isClickable = true
        btnEqual.isClickable = true
        btnSqrt.isClickable = true
        btnSquare.isClickable = true
        btnRemoveLast.isClickable = true
    }

    fun miniClickFalse() {
        btnDot.isClickable = false
        btnEqual.isClickable = false
        btnSqrt.isClickable = false
        btnSquare.isClickable = false
        btnRemoveLast.isClickable = false
    }

    fun getTag(view: View) {
        // if screen is empty and we press 0 or dot
        if (textView.text.toString().isEmpty() && view.tag == "0") {
            btnZero.isClickable = false
        }
        // if we press any button besides dot
        if (view.tag != "19") {
            // the first digit of second number
            if (isMath == true || isResult == true) {
                str = view.tag.toString()
                textView.text = str
                isMath = false
                btnZero.isClickable = true
                isResult = false
                dotExist = false
            }
            else if (isMath == false){

                if (textView.text.toString() == "0") {
                    str = view.tag.toString()
                    textView.text = str
                    btnZero.isClickable = true
                }

                else if (textView.text.toString() != "0") {
                    str += view.tag.toString()
                    textView.text = str
                }
            }
            miniClickTrue()
        }
        // if we press dot
        else {
            if (dotExist == false && isResult == false) {
                str += "."
                textView.text = str
                dotExist = true
                btnZero.isClickable = true
            }
        }

        var screen = textView.text.toString()
        if (screen != "+" && screen != "-" && screen != "x" && screen != "+") {
            secondNumber = textView.text.toString().toDouble()
            btnEqual.isClickable = true
        }
    }

    fun mathOps(view: View) {
        var screen = textView.text.toString()
        if (textView.text != "" && view.tag != "10" && view.tag != "17") {
            if (screen != "+" && screen != "-" && screen != "x" && screen != "+") {
                firstNumber = textView.text.toString().toDouble()
            }
            when(view.tag) {
                "11" -> {
                    fixedTo6 = ("%.6f".format(firstNumber * firstNumber)).toDouble()
                    checkForInt(fixedTo6)
                }
                "12" -> {
                    if (firstNumber >= 0) {
                        fixedTo6 = ("%.6f".format(sqrt(firstNumber))).toDouble()
                        checkForInt(fixedTo6)
                    } else {
                        str = "Forbidden!"
                        textView.text = str
                        clickFalse()
                    }
                }
                "13" -> {
                    str = "/"
                    textView.text = str
                    miniClickFalse()
                }
                "14" -> {
                    str = "x"
                    textView.text = str
                    miniClickFalse()
                }
                "15" -> {
                    str = "-"
                    textView.text = str
                    miniClickFalse()
                }
                "16" -> {
                    str = "+"
                    textView.text = str
                    miniClickFalse()
                }
            }

            operation = view.tag.toString().toInt()
            isMath = true
            dotExist = false
            btnZero.isClickable = true
        }

        else if (view.tag == "17") {
            when(operation) {
                13 -> {
                    if (secondNumber != 0.0) {
                        fixedTo6 = ("%.6f".format(firstNumber / secondNumber)).toDouble()
                        checkForInt(fixedTo6)
                    } else {
                        str = "Forbidden!"
                        textView.text = str
                        clickFalse()
                    }
                }
                14 -> {
                    fixedTo6 = ("%.6f".format(firstNumber * secondNumber)).toDouble()
                    checkForInt(fixedTo6)
                }
                15 -> {
                    fixedTo6 = ("%.6f".format(firstNumber - secondNumber)).toDouble()
                    checkForInt(fixedTo6)
                }
                16 -> {
                    fixedTo6 = ("%.6f".format(firstNumber + secondNumber)).toDouble()
                    checkForInt(fixedTo6)
                }
            }
            isResult = true
        }


        else if (view.tag == "10") {
            str = ""
            textView.text = str
            firstNumber = 0.0
            secondNumber = 0.0
            operation = 0
            dotExist = false
            clickTrue()
            isResult = false
            btnDot.isClickable = false
        }
    }

    fun removeLastItem(view: View) {
        var screen = textView.text.toString()
        if (screen[screen.length - 1].toString() == ".") {
            dotExist = false
        }
        if (!textView.text.toString().isEmpty()) {
            str = screen.substring(0, screen.length - 1)
            textView.text = str
        }
    }
}