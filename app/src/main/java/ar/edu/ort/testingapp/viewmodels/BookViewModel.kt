package ar.edu.ort.testingapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.ort.testingapp.data.Book
import ar.edu.ort.testingapp.data.BookDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookViewModel @Inject constructor(
    private val dao: BookDao
) : ViewModel() {

    val books = dao.getAllBooks()
        .map { it.sortedBy { book -> book.name } }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun addBook(name: String, author: String, price: Double = 0.0) {
        viewModelScope.launch {
            dao.insert(Book(name = name, price = price, author = author))
        }
    }

    fun deleteBook(book: Book) {
        viewModelScope.launch {
            dao.delete(book)
        }
    }
}
