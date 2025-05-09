package com.cesar.appmvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cesar.appmvvm.data.model.QuoteModel
import com.cesar.appmvvm.data.model.QuoteProvider

class QuoteViewModel : ViewModel() {
    val _quoteModel = MutableLiveData<QuoteModel>()

    fun randomQuote() {
        val currentQuote = QuoteProvider.random()
        _quoteModel.postValue(currentQuote)
    }
}