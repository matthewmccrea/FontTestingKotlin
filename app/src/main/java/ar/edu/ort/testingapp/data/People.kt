package ar.edu.ort.testingapp.data
import androidx.compose.runtime.Immutable
import kotlinx.serialization.Serializable

@Immutable
@Serializable
data class People(

    val id:Int,
    val name:String,
    val lastName:String,
    val age:Int,
    val image:String,

)
