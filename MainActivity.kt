package com.example.tugas3pamobile_danielgk

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var nim: TextView
    private lateinit var nama: TextView
    private lateinit var tvDisplay: TextView
    private var currentInput: String = ""
    private var operator: String = ""
    private var firstNumber: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nim = findViewById(R.id.nim)
        nama = findViewById(R.id.nama)
        tvDisplay = findViewById(R.id.tvDisplay)

        findViewById<Button>(R.id.btn0).setOnClickListener { appendNumber("0") }
        findViewById<Button>(R.id.btn1).setOnClickListener { appendNumber("1") }
        findViewById<Button>(R.id.btn2).setOnClickListener { appendNumber("2") }
        findViewById<Button>(R.id.btn3).setOnClickListener { appendNumber("3") }
        findViewById<Button>(R.id.btn4).setOnClickListener { appendNumber("4") }
        findViewById<Button>(R.id.btn5).setOnClickListener { appendNumber("5") }
        findViewById<Button>(R.id.btn6).setOnClickListener { appendNumber("6") }
        findViewById<Button>(R.id.btn7).setOnClickListener { appendNumber("7") }
        findViewById<Button>(R.id.btn8).setOnClickListener { appendNumber("8") }
        findViewById<Button>(R.id.btn9).setOnClickListener { appendNumber("9") }

        findViewById<Button>(R.id.btnAdd).setOnClickListener { setOperator("+") }
        findViewById<Button>(R.id.btnSubtract).setOnClickListener { setOperator("-") }
        findViewById<Button>(R.id.btnMultiply).setOnClickListener { setOperator("*") }
        findViewById<Button>(R.id.btnDivide).setOnClickListener { setOperator("/") }

        findViewById<Button>(R.id.btnEquals).setOnClickListener { calculate() }

        findViewById<Button>(R.id.btnClear).setOnClickListener { clearDisplay() }
    }

    private fun appendNumber(number: String) {
        currentInput += number
        tvDisplay.text = currentInput
    }

    private fun setOperator(op: String) {
        if (currentInput.isNotEmpty()) {
            firstNumber = currentInput.toDouble()
            currentInput = ""
            operator = op
        }
    }

    private fun calculate() {
        if (currentInput.isNotEmpty()) {
            val secondNumber = currentInput.toDouble()
            val result = when (operator) {
                "+" -> firstNumber + secondNumber
                "-" -> firstNumber - secondNumber
                "*" -> firstNumber * secondNumber
                "/" -> firstNumber / secondNumber
                else -> 0.0
            }
            tvDisplay.text = result.toString()
            currentInput = result.toString()
        }
    }

    private fun clearDisplay() {
        currentInput = ""
        operator = ""
        firstNumber = 0.0
        tvDisplay.text = ""
    }
}