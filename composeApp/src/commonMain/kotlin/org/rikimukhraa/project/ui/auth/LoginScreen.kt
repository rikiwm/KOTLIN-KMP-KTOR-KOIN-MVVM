package org.rikimukhraa.project.ui.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(authManager: FirebaseAuthManager) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isLogin by remember { mutableStateOf(true) }
    var message by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()

    val isUserLoggedIn = remember { mutableStateOf(authManager.getCurrentUser() != null) }

    if (isUserLoggedIn.value) {
  println("t")
    } else {
        println("f")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {

        Text(
            modifier = Modifier.width(250.dp),
            text = "Hello,Welcome to the login ",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(
            modifier = Modifier.height(14.dp)
        )
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth().padding(4.dp),
            shape = RoundedCornerShape(8.dp),
            leadingIcon = { Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "Localized description") },

            )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth().padding(4.dp),
            shape = RoundedCornerShape(8.dp),
            leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "Localized description") },
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedButton(
            onClick = {
                scope.launch {
                    try {
                        if (isLogin) {
                            authManager.login(email, password)
                            message = "Login Successful"
                            println("success")
                        } else {
                            authManager.register(email, password)
                            message = "Registration Successful"
                        }
                    } catch (e: Exception) {
                        message = e.message ?: "Error"
                    }
                }
                      },
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp, top = 30.dp, end = 20.dp),
            enabled = isLogin,
        ) {
            Text(if (isLogin) "Login" else "Register")
        }
        Text(
            text = message,
            color = Color.Red,
            modifier = Modifier.padding(top = 8.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))
        TextButton(onClick = { isLogin = !isLogin }) {
            Text(if (isLogin) "Don't have an account? Register" else "Already have an account? Login")
        }

        Spacer(modifier = Modifier.height(8.dp))
//        when (loginState.value) {
//            is LoginState.Success -> {
//                Snackbar(
//                    modifier = Modifier,
//                    action = null,
//                ){}
//                onLoginSuccess()
//            }
//            is LoginState.Error -> {
//                Text(
//                    text = (loginState as LoginState.Error).message,
//                    color = MaterialTheme.colorScheme.error,
//                    modifier = Modifier.padding(top = 8.dp)
//                )
//            }
//            else -> {}
//        }
    }
}