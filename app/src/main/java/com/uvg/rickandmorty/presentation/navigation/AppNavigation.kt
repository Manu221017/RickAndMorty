package com.uvg.rickandmorty.presentation.navigation

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.getValue
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.uvg.rickandmorty.presentation.character.characterGraph
import com.uvg.rickandmorty.presentation.location.locationGraph
import com.uvg.rickandmorty.presentation.character.profile.ProfileScreen
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination?.route

    // Estructura del NavHost para manejar las pantallas principales
    NavHost(
        navController = navController,
        startDestination = "characters", // Define el destino inicial
        modifier = modifier
    ) {
        // Gráficos anidados para las secciones
        characterGraph(navController)
        locationGraph(navController)

        composable("profile") {
            ProfileScreen(onLogoutClick = {
                // Redirige al login y vacía el backstack
                navController.navigate("login") {
                    popUpTo(navController.graph.startDestinationId) {
                        inclusive = true
                    }
                }
            })
        }
    }

    // Llamada a BottomNavigationBar para la navegación inferior
    BottomNavigationBar(
        currentDestination = currentDestination,
        onTabSelected = { route ->
            navController.navigate(route) {
                popUpTo(navController.graph.startDestinationId) {
                    saveState = true
                }
                restoreState = true
                launchSingleTop = true
            }
        }
    )
}

@Composable
fun BottomNavigationBar(
    currentDestination: String?,
    onTabSelected: (String) -> Unit
) {
    NavigationBar(
        containerColor = Color.Blue,
        contentColor = Color.White
    ) {
        // Lista de tabs para el BottomNavigation
        val tabs = listOf(
            BottomNavItem("Characters", "characters", Icons.Default.Person),
            BottomNavItem("Locations", "locations", Icons.Default.Place),
            BottomNavItem("Profile", "profile", Icons.Default.AccountCircle)
        )

        // Agregar items de navegación en la barra inferior
        tabs.forEach { tab ->
            NavigationBarItem(
                icon = { Icon(tab.icon, contentDescription = null) },
                label = { Text(tab.title) },
                selected = currentDestination == tab.route,
                onClick = { onTabSelected(tab.route) }
            )
        }
    }
}

data class BottomNavItem(val title: String, val route: String, val icon: ImageVector)
