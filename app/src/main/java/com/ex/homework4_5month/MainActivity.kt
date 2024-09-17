package com.ex.homework4_5month

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ex.homework4_5month.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    private val viewNodel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding
        setContentView(binding.root)

        binding.apply {
            btnP.setOnClickListener {
                viewNodel.increment()
            }

            btnM.setOnClickListener {
                viewNodel.decrement()
            }
        }
        viewNodel.counterData.observe(this){count ->
            binding.tvRes.text = count.toString()
            viewNodel.showResult(this)
        }
        viewNodel.colorData.observe(this){color ->
            binding.tvRes.setTextColor(ContextCompat.getColor(this,color))

        }


    }
}