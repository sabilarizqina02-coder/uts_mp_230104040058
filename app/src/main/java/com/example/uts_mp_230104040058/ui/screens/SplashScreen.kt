package com.example.uts_mp_230104040058.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import com.example.uts_mp_230104040058.data.PrefsManager

@Composable
fun SplashScreen(
    prefs: PrefsManager,
    onNavigateToLogin: () -> Unit,
    onNavigateToDashboard: (String) -> Unit
) {
    var isLoading by remember { mutableStateOf(true) }
    var savedUsername by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(Unit) {
        // Simulate small loading / check prefs
        delay(700)
        val saved = prefs.getUsername()
        savedUsername = saved
        if (!saved.isNullOrEmpty()) {
            // langsung ke dashboard kalau ada username
            onNavigateToDashboard(saved)
        } else {
            // tidak ada data -> hentikan loading dan tampilkan tombol "Masuk"
            isLoading = false
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "UTS Mobile Programming",
                style = MaterialTheme.typography.headlineSmall
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Welcome", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(16.dp))

            if (isLoading) {
                CircularProgressIndicator()
            } else {
                // tampilkan tombol "Masuk" untuk menuju Form Login
                Button(onClick = { onNavigateToLogin() }) {
                    Text(text = "Masuk")
                }
            }
        }
    }
}
