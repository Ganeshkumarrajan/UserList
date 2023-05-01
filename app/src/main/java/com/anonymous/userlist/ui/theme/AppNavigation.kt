package com.anonymous.userlist.ui.theme

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.anonymous.userlist.presentation.property_details.PropertyDetailsScreen
import com.anonymous.userlist.presentation.property_list.screen.PropertyListScreen

@Composable
fun NavigationApp(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = ScreenNames.PropertyList.route
    ) {
        composable(route = ScreenNames.PropertyList.route) {
            PropertyListScreen(navController)
        }
        composable(route = "${ScreenNames.PropertyDetails.route}/{propertyID}") { backStackEntry ->
            val propertyID = backStackEntry.arguments?.getString("propertyID") ?: ""
            PropertyDetailsScreen(propertyID)
        }
    }
}

sealed class ScreenNames(val route: String) {
    object PropertyList : ScreenNames("propertyList")
    object PropertyDetails : ScreenNames("propertyDetails")
}