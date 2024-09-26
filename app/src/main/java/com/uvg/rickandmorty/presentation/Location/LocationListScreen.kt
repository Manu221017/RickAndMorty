package com.uvg.rickandmorty.presentation.Location



import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// Un ejemplo de cómo podría verse el modelo de datos de Location
data class Location(
    val id: String,
    val name: String,
    val type: String
)

// Lista de ejemplo
val sampleLocations = listOf(
    Location("1", "Earth (C-137)", "Planet"),
    Location("2", "Abadango", "Cluster"),
    Location("3", "Citadel of Ricks", "Space station")
)

@Composable
fun LocationItem(
    location: Location,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() }
    ) {
        Text(
            text = location.name,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = "Type: ${location.type}",
            modifier = Modifier.padding(16.dp)
        )
    }
}
