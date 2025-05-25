package ar.edu.ort.testingapp.screens
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ar.edu.ort.testingapp.viewmodels.QuotesViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.runtime.LaunchedEffect
import ar.edu.ort.testingapp.ui.theme.quoteTitleStyle


@Composable
fun QuoteScreen(modifier: Modifier = Modifier, viewModel: QuotesViewModel = hiltViewModel()) {
    val quote = viewModel.Quote.value
    val author = viewModel.Author.value
    val category = viewModel.Category.value

    LaunchedEffect(Unit) {
        viewModel.loadQuotes()
    }

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .fillMaxHeight(0.5f)
                .background(Color.LightGray)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Quote del día",
                    style = quoteTitleStyle,
                    modifier = Modifier
                        .background(Color.White)
                        .padding(8.dp)
                )

                Text(
                    text = quote,
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier
                        .background(Color.Green)
                        .padding(8.dp)
                )

                Text(
                    text = author,
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier
                        .background(Color.Green)
                        .padding(8.dp)
                )

                Button(
                    onClick = { viewModel.loadQuotes() }
                ) {
                    Text(text = "Otra frase")
                }
            }
        }
    }
}



