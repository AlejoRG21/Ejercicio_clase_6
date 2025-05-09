package com.cesar.appmvvm.domain

import com.cesar.appmvvm.data.model.QuoteModel
import com.cesar.appmvvm.data.repository.QuoteRepository

class GetQuotesUseCase {
    private val repository = QuoteRepository()

    suspend operator fun invoke ():List<QuoteModel>? = repository.getAllQuotes()

}