package com.cesar.appmvvm.data.repository

import com.cesar.appmvvm.data.model.QuoteModel
import com.cesar.appmvvm.data.model.QuoteProvider
import com.cesar.appmvvm.data.network.QuoteService

class QuoteRepository {
    private val quoteService = QuoteService()

    suspend fun getAllQuotes(): List<QuoteModel>{
        val response = quoteService.getQuote()
        QuoteProvider.quotes = response
        return response
    }
}