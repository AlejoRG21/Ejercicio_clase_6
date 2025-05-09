package com.cesar.appmvvm.ui.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.cesar.appmvvm.databinding.ActivityMainBinding
import com.cesar.appmvvm.ui.viewmodel.QuoteViewModel


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //llamado al onCreate del viewmodel
        quoteViewModel.onCreate()


        quoteViewModel._quoteModel.observe(this, Observer{
            binding.tvQuote.text = it.quote
            binding.tvAuthor.text = it.author
        })

        binding.tvContainer.setOnClickListener{
            quoteViewModel.randomQuote()
        }


    }
}
