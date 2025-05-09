package com.cesar.appmvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cesar.appmvvm.data.model.QuoteModel
import com.cesar.appmvvm.data.model.QuoteProvider
import com.cesar.appmvvm.domain.GetQuotesUseCase
import kotlinx.coroutines.launch

class QuoteViewModel : ViewModel() {

    var getQuotesUseCase = GetQuotesUseCase()
    val quoteModel = MutableLiveData<QuoteModel>()

    fun randomQuote() {
        /*val currentQuote = QuoteProvider.random()
        _quoteModel.postValue(currentQuote)*/
    }

    fun onCreate() {
        viewModelScope.launch {
            val result = getQuotesUseCase()
            if (!result.isNullOrEmpty()){
                _quoteModel.postValue(result[0])
            }
        }
    }
    val _quoteModel = MutableLiveData<QuoteModel>()
}