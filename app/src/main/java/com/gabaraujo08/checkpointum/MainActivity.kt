package com.gabaraujo08.checkpointum

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.gabaraujo08.checkpointum.screens.LoginScreen
import com.gabaraujo08.checkpointum.screens.MenuScreen
import com.gabaraujo08.checkpointum.screens.PedidosScreen
import com.gabaraujo08.checkpointum.screens.PerfilScreen
import com.gabaraujo08.checkpointum.ui.theme.CheckpointUmTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CheckpointUmTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "login",
                    ) {
                        composable(route = "login") {
                            LoginScreen(
                                modifier = Modifier.padding(innerPadding),
                                navController
                            )
                        }

                        composable(route = "menu") {
                            MenuScreen(
                                modifier = Modifier.padding(innerPadding),
                                navController
                            )
                        }

                        // Implementação de parâmetro opcional na tela de Pedidos.
                        // O argumento "cliente" pode ser enviado na rota, mas se não for,
                        // a tela usa "Cliente Genérico" como valor padrão.
                        composable(
                            route = "pedidos?cliente={cliente}",
                            arguments = listOf(
                                navArgument("cliente") {
                                    defaultValue = "Cliente Genérico"
                                }
                            )
                        ) {
                            PedidosScreen(
                                modifier = Modifier.padding(innerPadding),
                                navController,
                                it.arguments?.getString("cliente")
                            )
                        }

                        // Implementação de parâmetros obrigatórios na tela de Perfil.
                        // Essa rota exige dois valores: nome e idade
                        // Isso também representa a passagem de múltiplos parâmetros.
                        composable(
                            route = "perfil/{nome}/{idade}",
                            arguments = listOf(
                                navArgument("nome") { type = NavType.StringType },
                                navArgument("idade") { type = NavType.IntType }
                            )
                        ) {
                            // Recupera os dois parâmetros obrigatórios enviados pela rota.
                            val nome: String? = it.arguments?.getString("nome", "Usuário Genérico")
                            val idade: Int? = it.arguments?.getInt("idade", 0)

                            PerfilScreen(
                                modifier = Modifier.padding(innerPadding),
                                navController,
                                nome!!,
                                idade!!
                            )
                        }
                    }
                }
            }
        }
    }
}