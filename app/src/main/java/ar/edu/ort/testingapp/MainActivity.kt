package ar.edu.ort.testingapp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ar.edu.ort.testingapp.ui.theme.TestingAppTheme
import androidx.navigation.compose.rememberNavController
import ar.edu.ort.testingapp.screens.FavouritesPage
import ar.edu.ort.testingapp.screens.HomePage
import ar.edu.ort.testingapp.screens.PeopleScreen
import ar.edu.ort.testingapp.screens.QuoteScreen
import ar.edu.ort.testingapp.screens.SettingsPage
import ar.edu.ort.testingapp.screens.BookScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

           MainApp()

        }
    }
}

@Composable
fun MainApp() {
    val navController = rememberNavController()
    TestingAppTheme{
    Scaffold(
        bottomBar = { BottomBarCustom(navController) }
    ) { innerPadding ->
        AppNavGraph(navController = navController, innerPadding = innerPadding)
    }
    }
}



@Composable
fun AppNavGraph(navController: NavHostController, innerPadding: PaddingValues) {
    NavHost(
        navController = navController,
        startDestination = "home",
        modifier = Modifier.padding(innerPadding)
    ) {
        composable("home") {
            HomePage(modifier = Modifier.padding(innerPadding))
        }
        composable("favourite") {
            FavouritesPage(modifier = Modifier.padding(innerPadding))
        }
        composable("settings") {
            SettingsPage(modifier = Modifier.padding(innerPadding))
        }
        composable("people") {
            PeopleScreen(modifier = Modifier.padding(innerPadding))
        }
        composable("quote") {
            QuoteScreen(modifier = Modifier.padding(innerPadding))
        }
        composable("book") {
            BookScreen(modifier = Modifier.padding(innerPadding))
        }
    }
}

@Composable
fun BottomBarCustom(navController: NavController) {
    BottomAppBar {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            IconButton(onClick = {
                navController.navigate("home") {
                    popUpTo("home") { inclusive = false }
                    launchSingleTop = true
                }
            }) {
                Icon(
                    imageVector = Icons.Filled.Home,
                    contentDescription = "Home"
                )
            }

            IconButton(onClick = {
                navController.navigate("favourite") {
                    popUpTo("home") { inclusive = false }
                    launchSingleTop = true
                }
            }) {
                Icon(
                    imageVector = Icons.Filled.Favorite,
                    contentDescription = "Favourite"
                )
            }

            IconButton(onClick = {
                navController.navigate("settings") {
                    popUpTo("home") { inclusive = false }
                    launchSingleTop = true
                }
            }) {
                Icon(
                    imageVector = Icons.Filled.Settings,
                    contentDescription = "Settings"
                )
            }

            IconButton(onClick = {
                navController.navigate("people") {
                    popUpTo("people") { inclusive = false }
                    launchSingleTop = true
                }
            }) {
                Icon(
                    imageVector = Icons.Filled.AccountBox,
                    contentDescription = "People"
                )
            }
            IconButton(onClick = {
                navController.navigate("quote") {
                    popUpTo("quote") { inclusive = false }
                    launchSingleTop = true
                }
            }) {
                Icon(
                    imageVector = Icons.Filled.Info,
                    contentDescription = "Quote"
                )
            }
            IconButton(onClick = {
                navController.navigate("book") {
                    popUpTo("book") { inclusive = false }
                    launchSingleTop = true
                }
            }) {
                Icon(
                    imageVector = Icons.Filled.DateRange,
                    contentDescription = "Book"
                )
            }
        }
    }
}






