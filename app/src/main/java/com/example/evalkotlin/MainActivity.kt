package com.example.evalkotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.Tv
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.evalkotlin.navigation.AppNavigation
import com.example.evalkotlin.ui.theme.EvalkotlinTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {

            EvalkotlinTheme {

                MainScreen()

            }
        }
    }
}

@Composable
fun MainScreen() {

    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),

        bottomBar = {

            NavigationBar {

                NavigationBarItem(
                    selected = false,
                    onClick = {
                        navController.navigate("series")
                    },
                    icon = {
                        Icon(Icons.Default.Tv, null)
                    },
                    label = {
                        Text("Series")
                    }
                )

                NavigationBarItem(
                    selected = false,
                    onClick = {
                        navController.navigate("movies")
                    },
                    icon = {
                        Icon(Icons.Default.Movie, null)
                    },
                    label = {
                        Text("Movies")
                    }
                )

                NavigationBarItem(
                    selected = false,
                    onClick = {
                        navController.navigate("favorites")
                    },
                    icon = {
                        Icon(Icons.Default.Favorite, null)
                    },
                    label = {
                        Text("Favorites List")
                    }
                )
            }
        }

    ) { padding ->

        androidx.compose.foundation.layout.Box(
            modifier = Modifier.padding(padding)
        ) {

            AppNavigation(navController)

        }
    }
}