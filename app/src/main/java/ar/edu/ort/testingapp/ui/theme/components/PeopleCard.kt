package ar.edu.ort.testingapp.ui.theme.components
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ar.edu.ort.testingapp.data.People


@Composable
fun PeopleCard(person: People) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "${person.name} ${person.lastName}",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "Age: ${person.age}",
                style = MaterialTheme.typography.bodyMedium
            )

        }
    }
}