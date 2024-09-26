package com.uvg.rickandmorty.presentation.location

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import com.uvg.rickandmorty.presentation.Location.LocationDetailsScreen
import kotlinx.serialization.Serializable

@Serializable
data object LocationDestination

@Composable
fun LocationListScreen(navController: NavHostController) {
    // Implementación para mostrar la lista de locaciones
    // Al seleccionar una locación, navegar a LocationDetailsScreen pasando el ID
}

fun NavGraphBuilder.locationGraph(navController: NavHostController) {
    composable("locations") {
        LocationListScreen(navController)
    }
    composable("locations/{locationId}") { backStackEntry ->
        val locationId = backStackEntry.arguments?.getString("locationId")
        LocationDetailsScreen(locationId = locationId)
    }
}
