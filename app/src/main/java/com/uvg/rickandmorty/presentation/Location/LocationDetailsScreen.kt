package com.uvg.rickandmorty.presentation.Location

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LocationDetailsScreen(locationId: String?) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Location Details") },
                modifier = Modifier.padding(PaddingValues(16.dp)) // Añadir padding
            )
        }
    ) { paddingValues ->
        // Agregar padding del Scaffold si es necesario
        Text(
            text = "Location ID: $locationId",
            modifier = Modifier.padding(paddingValues) // Usar paddingValues
        )
        // Aquí puedes agregar más detalles de la locación (Nombre, Tipo, Dimensión)
    }
}
