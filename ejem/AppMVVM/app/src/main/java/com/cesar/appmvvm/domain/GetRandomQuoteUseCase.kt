package com.cesar.appmvvm.domain

import com.cesar.appmvvm.data.model.QuoteModel
import com.cesar.appmvvm.data.model.QuoteProvider

class GetRandomQuoteUseCase {

    operator fun invoke(): QuoteModel?{
        val quotes = QuoteProvider.quotes
        if(!quotes.isNullOrEmpty()){
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}