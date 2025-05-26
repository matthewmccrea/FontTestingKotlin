package ar.edu.ort.testingapp.screens


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ar.edu.ort.testingapp.data.Book
import ar.edu.ort.testingapp.viewmodels.BookViewModel
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun BookScreen(modifier: Modifier = Modifier) {
    val viewModel: BookViewModel = hiltViewModel()
    val books by viewModel.books.collectAsState()

    var title by remember { mutableStateOf("") }
    var author by remember { mutableStateOf("") }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        Text("Agregar libro", style = MaterialTheme.typography.titleLarge)

        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Título") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = author,
            onValueChange = { author = it },
            label = { Text("Autor") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        )

        Button(
            onClick = {
                if (title.isNotBlank() && author.isNotBlank()) {
                    viewModel.addBook(title, author)
                    title = ""
                    author = ""
                }
            },
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth()
        ) {
            Text("Guardar libro")
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text("Libros guardados:", style = MaterialTheme.typography.titleMedium)

        Spacer(modifier = Modifier.height(8.dp))

        books.forEach { book ->
            Text(
                text = "📖 ${book.name} - ${book.author}",
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { viewModel.deleteBook(book) }
                    .padding(vertical = 4.dp)
            )
        }
    }
}
