package com.uvg.rickandmorty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.uvg.rickandmorty.presentation.navigation.AppNavigation
import com.uvg.rickandmorty.presentation.ui.theme.RickAndMortyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickAndMortyTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { /* Aquí podrías agregar una TopAppBar si es necesario más tarde */ },
                    bottomBar = { /* Aquí podrías agregar una BottomNavigation personalizada si es necesario */ }
                ) { innerPadding ->
                    AppNavigation(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    )
                }
            }
        }
    }
}