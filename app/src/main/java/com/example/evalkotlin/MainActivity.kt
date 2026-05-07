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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
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
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Scaffold(
        modifier = Modifier.fillMaxSize(),

        bottomBar = {

            NavigationBar {

                NavigationBarItem(
                    selected = currentDestination?.hierarchy?.any { it.route == "series" } == true,
                    onClick = {
                        navController.navigate("series") {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    icon = {
                        Icon(Icons.Default.Tv, null)
                    },
                    label = {
                        Text("Series")
                    }
                )

                NavigationBarItem(
                    selected = currentDestination?.hierarchy?.any { it.route == "movies" } == true,
                    onClick = {
                        navController.navigate("movies") {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    icon = {
                        Icon(Icons.Default.Movie, null)
                    },
                    label = {
                        Text("Movies")
                    }
                )

                NavigationBarItem(
                    selected = currentDestination?.hierarchy?.any { it.route == "favorites" } == true,
                    onClick = {
                        navController.navigate("favorites") {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    icon = {
                        Icon(Icons.Default.Favorite, null)
                    },
                    label = {
                        Text("Favorites")
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