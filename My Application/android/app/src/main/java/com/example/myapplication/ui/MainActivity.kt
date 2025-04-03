package com.example.myapplication.ui

import android.os.Bundle
import android.telecom.Call.Details
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.element_detail.DetailsScreen
import com.example.myapplication.ui.element_detail.ElemDetailsRoute
import com.example.myapplication.ui.element_list.ElementsRoute
import com.example.myapplication.ui.element_list.SearchViewScreen
import com.example.myapplication.ui.theme.MyApplicationTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "ElementsRoute",
                    enterTransition = { EnterTransition.None },
                    exitTransition = { ExitTransition.None },
                    modifier = Modifier,
                ) {
                    composable("ElementsRoute") {
                        SearchViewScreen(
                            onResultClick = { id ->
                                navController.navigate(ElemDetailsRoute(id))
                            }
                        )
                    }
                    composable<ElemDetailsRoute> {
                        DetailsScreen(onUpClick = { navController.navigateUp() })
                    }
                    }
                }
            }
        }
    }

