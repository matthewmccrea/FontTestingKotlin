package ar.edu.ort.testingapp.model
import com.google.gson.annotations.SerializedName

data class Quote(
    val quote: String,
    val author: String,
    val category: String
)
