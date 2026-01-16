package com.example.uts_mp_230104040058.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.uts_mp_230104040058.data.PrefsManager

@Composable
fun LoginScreen(
    prefs: PrefsManager,
    onLoginSuccess: (String) -> Unit,
    onBackToSplash: () -> Unit
) {
    val context = LocalContext.current

    var username by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var remember by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Text("Form Login", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = remember, onCheckedChange = { remember = it })
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Ingat saya")
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = {
                if (username == "Sabila" && password == "ahss0231_") {
                    if (remember) prefs.saveUsername(username)
                    onLoginSuccess(username)
                } else {
                    Toast.makeText(context, "Username/Password salah", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Login")
        }

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedButton(
            onClick = { onBackToSplash() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Kembali")
        }
    }
}
