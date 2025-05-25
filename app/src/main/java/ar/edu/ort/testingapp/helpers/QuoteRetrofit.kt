package ar.edu.ort.testingapp.helpers
import ar.edu.ort.testingapp.model.Quote
import ar.edu.ort.testingapp.shared.QuotesApi
import javax.inject.Inject
import ar.edu.ort.testingapp.shared.IServiceQuotes



class QuoteRetrofit
@Inject
constructor(private val service:QuotesApi) : IServiceQuotes {

    override suspend fun getQuotes(): List<Quote>? {

        val response = service.getQuotes()

        return if (response.isSuccessful) {
            val result = response.body()?.map {
                Quote(
                    quote = it.quote,
                    author = it.author,
                    category = it.category
                )
            }
            result
        } else {
            emptyList()
        }
    }


}