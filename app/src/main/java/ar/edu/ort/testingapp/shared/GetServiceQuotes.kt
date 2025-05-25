package ar.edu.ort.testingapp.shared
import ar.edu.ort.testingapp.helpers.QuoteRetrofit
import ar.edu.ort.testingapp.model.Quote
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
class GetServiceQuotes @Inject constructor(
    private val quoteRetrofit: QuoteRetrofit
){
    suspend fun invoke(): List<Quote>? = withContext(Dispatchers.IO){
        quoteRetrofit.getQuotes()
    }
}