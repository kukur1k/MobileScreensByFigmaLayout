package com.example.bookinglayoutbyfigma.navigation


import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.bookinglayoutbyfigma.screens.HomeScreen
import com.example.bookinglayoutbyfigma.screens.SplashScreen
import com.example.bookinglayoutbyfigma.screens.TourInfoScreen


@Composable
fun AppNavigation(navController: NavHostController){

    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route,
        exitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Left,
                tween(400)
            )
        },
        enterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Right,
                tween(400)
            )
        }
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                onHotelClick = {
                    navController.navigate(Screen.TourInfo.route)
                }
            )
        }

        composable(Screen.TourInfo.route) {
            TourInfoScreen(
                onBack = { navController.navigateUp() }
            )
        }

        composable(Screen.Calendar.route) {
            TourInfoScreen()
        }

        composable(Screen.Search.route) {
            TourInfoScreen()
        }

        composable(Screen.Messages.route) {
            TourInfoScreen()
        }

        composable(Screen.Profile.route) {
            TourInfoScreen()
        }



        composable(Screen.Splash.route) {
            SplashScreen(
                {
                    navController.navigate(Screen.Home.route){
                        popUpTo(Screen.Home.route){
                            inclusive = true
                        }
                    }
                }
            )
        }
    }
}



