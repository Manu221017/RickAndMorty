package com.uvg.rickandmorty.presentation.character.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle


@Composable
fun ProfileScreen(
    onLogoutClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Reemplazamos la imagen de perfil con un icono
        Icon(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = "Default Profile Icon",
            modifier = Modifier.fillMaxWidth(0.4f), // Tamaño del icono (40% del ancho disponible)
        )
        Text(text = "Juan Carlos Durini")
        Text(text = "#1201613")
        Button(onClick = onLogoutClick) {
            Text(text = "Cerrar sesión")
        }
    }
}
