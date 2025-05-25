package ar.edu.ort.testingapp.viewmodels
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import ar.edu.ort.testingapp.shared.GetServiceQuotes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject



@HiltViewModel
class QuotesViewModel @Inject constructor(
    private val getQuotesUseCase: GetServiceQuotes
): ViewModel() {

    var Quote = mutableStateOf("Cargando....")
    var Author = mutableStateOf("")
    var Category = mutableStateOf("")

    fun loadQuotes() {
        viewModelScope.launch {
            val quote = getQuotesUseCase.invoke()
            if(!quote.isNullOrEmpty() && quote.size > 0) {
                Quote.value = quote!!.get(0)!!.quote
                Author.value = quote!!.get(0)!!.author
                Category.value = quote!!.get(0)!!.category
            }
        }
    }
    }
