package com.example.calculatorsecret

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var enterBTN: Button
    private lateinit var resultTV: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        enterBTN = findViewById(R.id.enterBTN)
        resultTV = findViewById(R.id.resultTV)

        val result = intent.getStringExtra("key")
        resultTV.text = result

        enterBTN.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
            // launchCalculator.launch(intent)
            // Toast.makeText(this, "ПЕРЕХОД", Toast.LENGTH_LONG).show()
            Toast.makeText(this, "Это интересно", Toast.LENGTH_LONG).show()
        }

    }
}

//    private val launchCalculator =
//        registerForActivityResult(ActivityResultContracts.StartActivityForResult())
//        { result ->
//            result.resultCode == RESULT_OK
//            val data = result.data!!.getStringExtra("result")
//            resultTV.text = data
//            //startActivity(intent)
//            //Toast.makeText(this, "переход", Toast.LENGTH_LONG).show()
//        }
//}