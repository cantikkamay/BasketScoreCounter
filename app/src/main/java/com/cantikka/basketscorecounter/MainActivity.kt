package com.cantikka.basketscorecounter

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var skorA: TextView
    private lateinit var skorB: TextView

    val viewModel: ScoreViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        skorA = findViewById(R.id.skorA)
        skorB = findViewById(R.id.skorB)

        val buttonPlus1A = findViewById<Button>(R.id.btntambah1A)
        val buttonPlus2A = findViewById<Button>(R.id.btntambah2A)
        val buttonPlus3A = findViewById<Button>(R.id.btntambah3A)

        val buttonPlus1B = findViewById<Button>(R.id.btntambah1B)
        val buttonPlus2B = findViewById<Button>(R.id.btntambah2B)
        val buttonPlus3B = findViewById<Button>(R.id.btntambah3B)

        val buttonReset = findViewById<Button>(R.id.btnreset)

        skorA.text = viewModel.scoreA.toString()
        skorB.text = viewModel.scoreB.toString()

        buttonPlus1A.setOnClickListener { tambahSkorA(1) }
        buttonPlus2A.setOnClickListener { tambahSkorA(2) }
        buttonPlus3A.setOnClickListener { tambahSkorA(3) }

        buttonPlus1B.setOnClickListener { tambahSkorB(1) }
        buttonPlus2B.setOnClickListener { tambahSkorB(2) }
        buttonPlus3B.setOnClickListener { tambahSkorB(3) }

        buttonReset.setOnClickListener { resetSkor() }
    }

    private fun tambahSkorA(poin: Int) {
        repeat(poin) { viewModel.incrementSkorA() }
        skorA.text = viewModel.scoreA.toString()
    }

    private fun tambahSkorB(poin: Int) {
        repeat(poin) { viewModel.incrementSkorB() }
        skorB.text = viewModel.scoreB.toString()
    }

    private fun resetSkor() {
        viewModel.resetSkor()
        skorA.text = viewModel.scoreA.toString()
        skorB.text = viewModel.scoreB.toString()
    }
}

