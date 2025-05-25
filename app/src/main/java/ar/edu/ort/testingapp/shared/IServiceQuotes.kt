package ar.edu.ort.testingapp.shared
import ar.edu.ort.testingapp.model.Quote


interface IServiceQuotes {
    suspend fun getQuotes(): List<Quote>?
}