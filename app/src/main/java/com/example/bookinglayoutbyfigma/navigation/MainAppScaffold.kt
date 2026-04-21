package com.example.bookinglayoutbyfigma.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun MainAppScaffold(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    val currentRoute = navBackStackEntry?.destination?.route


    val shouldShowBottomNav = when {
        currentRoute?.startsWith(Screen.Home.route) == true -> true
        currentRoute?.startsWith(Screen.Calendar.route) == true -> false
        currentRoute?.startsWith(Screen.Messages.route) == true -> false
        currentRoute?.startsWith(Screen.Profile.route) == true -> true
        currentRoute?.startsWith(Screen.Calendar.route) == true -> true
        else -> {
            false
        }
    }

    var selectedItem by remember { mutableStateOf<NavItem>(NavItem.Home) }

    LaunchedEffect(currentRoute) {
        selectedItem = when {
            currentRoute?.startsWith(Screen.Home.route) == true -> NavItem.Home
            currentRoute?.startsWith(Screen.Calendar.route) == true -> NavItem.Calendar
            currentRoute?.startsWith(Screen.Messages.route) == true -> NavItem.Messages
            currentRoute?.startsWith(Screen.Profile.route) == true -> NavItem.Profile
            else -> {
                selectedItem
            }
        }

    }

    Scaffold(
        bottomBar = {
            if(shouldShowBottomNav) {
                BottomNavigationPanel(
                    selectedItem = selectedItem,
                    onItemSelected = {
                        selectedItem = it
                        when (it) {
                            NavItem.Messages -> {
                                navController.navigate(Screen.Messages.route) {
                                    popUpTo(Screen.Messages.route) {
                                        inclusive = true
                                    }
                                }
                            }

                            NavItem.Calendar -> {
                                navController.navigate(Screen.Calendar.route) {
                                    popUpTo(Screen.Calendar.route) {
                                        inclusive = true
                                    }
                                }
                            }

                            NavItem.Home -> {
                                navController.navigate(Screen.Home.route) {
                                    popUpTo(Screen.Home.route) {
                                        inclusive = true
                                    }
                                }
                            }

                            NavItem.Profile -> {
                                navController.navigate(Screen.Profile.route) {
                                    popUpTo(Screen.Profile.route) {
                                        inclusive = true
                                    }
                                }
                            }

                            NavItem.Search -> {
                                navController.navigate(Screen.Search.route) {
                                    popUpTo(Screen.Search.route) {
                                        inclusive = true
                                    }
                                }
                            }
                        }
                    }

                )
            }
        }
    ) { paddingValues ->
        Box(
            Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(paddingValues)
        ) {
            AppNavigation(navController)
        }
    }
}