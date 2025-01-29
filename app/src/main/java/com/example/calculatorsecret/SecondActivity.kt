package com.example.calculatorsecret

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.div

class SecondActivity : AppCompatActivity(),View.OnClickListener {
    private lateinit var firstOperandET: EditText
    private lateinit var secondOperandET: EditText

    private lateinit var bottonSumBTN: Button
    private lateinit var bottonDifBTN: Button
    private lateinit var bottonMultBTN: Button
    private lateinit var bottonDivBTN: Button

    private lateinit var bottonTransferResult: Button

    private lateinit var buttonResetBTN: Button
    private lateinit var buttonExsitBTN: Button

    private lateinit var resultTV: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        firstOperandET = findViewById(R.id.firstOperandET)
        secondOperandET = findViewById(R.id.secondOperandET)

        bottonSumBTN = findViewById(R.id.bottonSumBTN)
        bottonDifBTN = findViewById(R.id.bottonDifBTN)
        bottonMultBTN = findViewById(R.id.bottonMultBTN)
        bottonDivBTN = findViewById(R.id.bottonDivBTN)

        bottonTransferResult = findViewById(R.id.bottonTransferResult)
        buttonResetBTN = findViewById(R.id.buttonResetBTN)
        buttonExsitBTN = findViewById(R.id.buttonExitBTN)

        bottonSumBTN.setOnClickListener(this)
        bottonDifBTN.setOnClickListener(this)
        bottonMultBTN.setOnClickListener(this)
        bottonDivBTN.setOnClickListener(this)

        buttonResetBTN.setOnClickListener(this)
        buttonExsitBTN.setOnClickListener(this)

        bottonTransferResult.setOnClickListener {
            if (resultTV.text.isEmpty()) return@setOnClickListener
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("key", resultTV.text.toString())
            startActivity(intent)
            Toast.makeText(this, "А ВОТ И СЕКРЕТ", Toast.LENGTH_LONG).show()
        }
        buttonResetBTN.setOnClickListener{
            firstOperandET.text.clear()
            secondOperandET.text.clear()
            resultTV.text = ""
        }
        resultTV = findViewById(R.id.resultTV)
    }
    override fun onClick(v: View?) {
        var check = true
        if (firstOperandET.text.isEmpty()||secondOperandET.text.isEmpty()){
            return }
        var first =  firstOperandET.text.toString().toDouble()
        var second = secondOperandET.text.toString().toDouble()
        var result = when(v?.id) {
            R.id.bottonSumBTN -> Operation(first, second).sum()
            R.id.bottonDifBTN -> Operation(first, second).dif()
            R.id.bottonMultBTN -> Operation(first, second).mult()
            R.id.bottonDivBTN -> Operation(first, second).div()
            R.id.buttonResetBTN -> {
                firstOperandET.text.clear()
                secondOperandET.text.clear()
                check = false }
            R.id.buttonExitBTN -> finish()
            else -> 0.0 }
        resultTV.text = result.toString().uppercase()
       }
}
