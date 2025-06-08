package com.example.authapp.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.LaunchedEffect
import com.example.authapp.viewmodel.AuthViewModel
import com.example.authapp.viewmodel.Result


@Composable
fun LoginScreen(viewModel: AuthViewModel, onSuccess: () -> Unit) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(value = email, onValueChange = { email = it }, label = { Text("Email") })
        TextField(value = password, onValueChange = { password = it }, label = { Text("Password") }, visualTransformation = PasswordVisualTransformation())
        Button(onClick = { viewModel.login(email, password) }) {
            Text("Login")
        }

        when (val state = viewModel.loginState) {
            is Result.Success -> {
                LaunchedEffect(Unit) { onSuccess() }
            }
            is Result.Failure -> {
                Text("Login gagal: ${state.exception.message}", color = Color.Red)
            }
            else -> {}
        }
    }
}