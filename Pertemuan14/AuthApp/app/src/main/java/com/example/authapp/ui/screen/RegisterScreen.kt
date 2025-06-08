package com.example.authapp.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.authapp.viewmodel.AuthViewModel
import com.example.authapp.viewmodel.Result

@Composable
fun RegisterScreen(viewModel: AuthViewModel, onRegistered: () -> Unit) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(value = name, onValueChange = { name = it }, label = { Text("Nama") })
        TextField(value = email, onValueChange = { email = it }, label = { Text("Email") })
        TextField(value = password, onValueChange = { password = it }, label = { Text("Password") }, visualTransformation = PasswordVisualTransformation())
        Button(onClick = { viewModel.register(name, email, password) }) {
            Text("Register")
        }

        when (val state = viewModel.registerState) {
            is Result.Success -> {
                Text("Registrasi berhasil", color = Color.Green)
                LaunchedEffect(Unit) { onRegistered() }
            }
            is Result.Failure -> {
                Text("Register gagal: ${state.exception.message}", color = Color.Red)
            }
            else -> {}
        }
    }
}