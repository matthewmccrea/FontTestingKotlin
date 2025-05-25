package ar.edu.ort.testingapp.screens
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ar.edu.ort.testingapp.screens.PeopleList.PeopleList
import ar.edu.ort.testingapp.ui.theme.components.PeopleCard

@Composable
fun PeopleScreen(modifier: Modifier = Modifier) {
    val viewModel: PeopleList = viewModel(factory = PeopleList.provideFactory())
    val people = viewModel.getPeople() ?: emptyList()


    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(people) { person ->
            PeopleCard(person)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}