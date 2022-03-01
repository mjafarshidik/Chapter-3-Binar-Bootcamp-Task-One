package com.mjafarshidik.firsttaskchapter3binarbootcamp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mjafarshidik.firsttaskchapter3binarbootcamp.databinding.ActivitySplashScreenBinding
import kotlinx.coroutines.*

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {
    private lateinit var splashScreenBinding: ActivitySplashScreenBinding
    private val time = 2000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashScreenBinding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(splashScreenBinding.root)
        withCoroutine(time)
    }

    private fun withCoroutine(time: Long) {
        val mScope = CoroutineScope(Dispatchers.IO)
        mScope.launch {
            delay(time)
            withContext(Dispatchers.Main) {
                launchPostSplashActivity()
                mScope.cancel(null)
            }
        }
    }

    private fun launchPostSplashActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}