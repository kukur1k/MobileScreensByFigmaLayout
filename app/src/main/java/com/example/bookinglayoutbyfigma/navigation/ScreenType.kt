package com.example.bookinglayoutbyfigma.navigation

import android.icu.text.CaseMap

sealed class ScreenType{
    object WithoutBottomNav: ScreenType()
    object WithBottomNav: ScreenType()

}

sealed class Screen(val route: String, val ScreenType: ScreenType){

    object Home: Screen(route = "home", ScreenType.WithBottomNav)
    object Calendar: Screen(route = "calendar", ScreenType.WithBottomNav)
    object Messages: Screen(route = "messages", ScreenType.WithBottomNav)
    object Profile: Screen(route = "profile", ScreenType.WithBottomNav)

    object Search: Screen(route = "search", ScreenType.WithBottomNav)

    object Splash: Screen("splash", ScreenType.WithoutBottomNav)

    object TourInfo: Screen(route = "tour_info", ScreenType.WithoutBottomNav)


}

sealed class NavItem(val title: String, val route: String){
    object Home: NavItem("Home", Screen.Home.route)
    object Calendar: NavItem("calendar", Screen.Calendar.route)
    object Messages: NavItem("Messages", Screen.Messages.route)
    object Profile: NavItem("Profile", Screen.Profile.route)
    object Search: NavItem("Search", Screen.Search.route)
}