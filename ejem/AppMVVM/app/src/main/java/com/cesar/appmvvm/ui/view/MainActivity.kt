package com.cesar.appmvvm.ui.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.cesar.appmvvm.data.model.UserProvider
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


        quoteViewModel.quoteModel.observe(this, Observer{
            binding.tvQuote.text = it?.quote
            binding.tvAuthor.text = it?.author
        })

        binding.tvContainer.setOnClickListener{
            quoteViewModel.randomQuote()
        }

        val name = intent.getStringExtra("name")
        val lastName = intent.getStringExtra("lastName")
        val jwt = intent.getStringExtra("jwt")

        binding.tvUser.text = "$name = $lastName - $jwt"

        binding.tvUser.setOnClickListener{
            UserProvider.user = null
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}
