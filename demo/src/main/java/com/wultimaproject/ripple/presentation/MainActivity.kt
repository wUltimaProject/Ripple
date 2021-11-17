package com.wultimaproject.ripple.presentation

/**
 * Created by Antonio Coppola on 06/11/2021.
 */

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wultimaproject.ripple.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
