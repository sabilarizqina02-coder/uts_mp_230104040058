package com.example.uts_mp_230104040058.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.uts_mp_230104040058.data.PrefsManager

@Composable
fun DashboardScreen(
    prefs: PrefsManager,
    username: String,
    onLogout: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Text(text = "Dashboard", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Selamat datang, $username",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                prefs.clearUsername()
                onLogout()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Hapus Data Login / Keluar")
        }
    }
}
