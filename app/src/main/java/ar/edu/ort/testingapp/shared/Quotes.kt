package ar.edu.ort.testingapp.shared
import ar.edu.ort.testingapp.model.QuoteApi
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface QuotesApi {
    @GET("v1/quotes")
    suspend fun getQuotes(): Response<List<QuoteApi>>
}