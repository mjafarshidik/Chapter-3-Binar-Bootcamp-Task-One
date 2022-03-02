package com.mjafarshidik.firsttaskchapter3binarbootcamp

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import com.mjafarshidik.firsttaskchapter3binarbootcamp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        webViewSetup()
    }

    @SuppressLint("SetJavaScriptEnabled")
    fun webViewSetup() = mainBinding.run {
        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://www.binaracademy.com/")
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true
        webSettings.domStorageEnabled = true
        webSettings.allowContentAccess = true
        webSettings.allowFileAccess = true
    }

    override fun onBackPressed() {
        mainBinding.apply {
            if (webView.canGoBack()) {
                webView.goBack()
            } else {
                super.onBackPressed()
            }
        }
    }
}