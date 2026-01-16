package com.example.uts_mp_230104040058

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.uts_mp_230104040058.navigation.AppNavHost
import com.example.uts_mp_230104040058.data.PrefsManager

class MainActivity : ComponentActivity() {

    // deklarasi prefs
    private lateinit var prefs: PrefsManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // inisialisasi PrefsManager menggunakan applicationContext
        prefs = PrefsManager(applicationContext)

        setContent {
            MaterialTheme {
                Surface {
                    AppNavHost(prefs = prefs)
                }
            }
        }
    }
}
