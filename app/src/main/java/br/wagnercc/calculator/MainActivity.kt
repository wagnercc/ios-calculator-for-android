package br.wagnercc.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var inputVal: String = ""
    private var secondVal: String = ""
    private var typeOperation: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtInput = findViewById<TextView>(R.id.txtInput)
        val btnPlus = findViewById<Button>(R.id.btnPlus)
        val btnSubtract = findViewById<Button>(R.id.btnSubtract)
        val btnMultiply = findViewById<Button>(R.id.btnMultiply)
        val btnDivide = findViewById<Button>(R.id.btnDivide)
        val btnPercent = findViewById<Button>(R.id.btnPercent)
        val btnComma = findViewById<Button>(R.id.btnComma)
        val btnEqual = findViewById<Button>(R.id.btnEqual)
        val btnClean = findViewById<Button>(R.id.btnClean)
        val btn0 = findViewById<Button>(R.id.btn0)
        val btn1 = findViewById<Button>(R.id.btn1)
        val btn2 = findViewById<Button>(R.id.btn2)
        val btn3 = findViewById<Button>(R.id.btn3)
        val btn4 = findViewById<Button>(R.id.btn4)
        val btn5 = findViewById<Button>(R.id.btn5)
        val btn6 = findViewById<Button>(R.id.btn6)
        val btn7 = findViewById<Button>(R.id.btn7)
        val btn8 = findViewById<Button>(R.id.btn8)
        val btn9 = findViewById<Button>(R.id.btn9)

        btnPlus.setOnClickListener {
            typeOperation = "+"
            inputVal = txtInput.text.toString()
            txtInput.text = "0"
        }
        btnSubtract.setOnClickListener {
            typeOperation = "-"
            inputVal = txtInput.text.toString()
            txtInput.text = "0"
        }
        btnMultiply.setOnClickListener {
            typeOperation = "*"
            inputVal = txtInput.text.toString()
            txtInput.text = "0"
        }
        btnDivide.setOnClickListener {
            typeOperation = "/"
            inputVal = txtInput.text.toString()
            txtInput.text = "0"
        }
        btnPercent.setOnClickListener {
            val convertToPercent = txtInput.text.toString().toDouble() / 100
            txtInput.text = convertToPercent.toString()
        }
        btnComma.setOnClickListener {
            txtInput.text = txtInput.text.toString() + ".0"
        }
        btnClean.setOnClickListener {
            inputVal = "0"
            secondVal = "0"
            txtInput.text = "0"
            typeOperation = ""
        }
        btnEqual.setOnClickListener {
            if (inputVal == "0") {
                inputVal = txtInput.text.toString()
                txtInput.text = "0"
            } else {
                secondVal = txtInput.text.toString()
                if ((inputVal == "0" || secondVal == "0") && typeOperation == "/") {
                    txtInput.text = "Not a Number"
                } else {
                    txtInput.text = "0"
                    inputVal = doMath(inputVal, secondVal, typeOperation).toString()
                    txtInput.text = inputVal.toString()
                }
                inputVal = "0"
                secondVal = "0"
            }
        }
        btn0.setOnClickListener {
            updateTxtInput(btn0.text.toString(), txtInput)
        }
        btn1.setOnClickListener {
            updateTxtInput(btn1.text.toString(), txtInput)
        }
        btn2.setOnClickListener {
            updateTxtInput(btn2.text.toString(), txtInput)
        }
        btn3.setOnClickListener {
            updateTxtInput(btn3.text.toString(), txtInput)
        }
        btn4.setOnClickListener {
            updateTxtInput(btn4.text.toString(), txtInput)
        }
        btn5.setOnClickListener {
            updateTxtInput(btn5.text.toString(), txtInput)
        }
        btn6.setOnClickListener {
            updateTxtInput(btn6.text.toString(), txtInput)
        }
        btn7.setOnClickListener {
            updateTxtInput(btn7.text.toString(), txtInput)
        }
        btn8.setOnClickListener {
            updateTxtInput(btn8.text.toString(), txtInput)
        }
        btn9.setOnClickListener {
            updateTxtInput(btn9.text.toString(), txtInput)
        }

    }

    private fun updateTxtInput(input: String, txtInp: TextView) {
        if (txtInp.text.toString() == "0") {
            txtInp.text = input
        } else {
            var sum = "";
            if (txtInp.text.contains(".0")) {
                sum = txtInp.text.toString().replace(".0", "." + input)
            } else {
                sum = txtInp.text.toString() + input
            }
            txtInp.text = sum
        }
    }

    private fun doMath(firstNumber: String, secondNumber: String, function: String): Int {
        var equation: Int = 0
        if (function === "+") {
            equation = (firstNumber.toDouble() + secondNumber.toDouble()).toInt()
        } else if (function === "-") {
            equation = (firstNumber.toDouble() - secondNumber.toDouble()).toInt()
        }  else if (function === "/") {
                equation = (firstNumber.toDouble() / secondNumber.toDouble()).toInt()
        }  else if (function === "*") {
            equation = (firstNumber.toDouble() * secondNumber.toDouble()).toInt()
        }

        return equation;
    }
}