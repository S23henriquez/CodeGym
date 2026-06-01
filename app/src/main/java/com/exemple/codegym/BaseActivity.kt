package com.exemple.codegym

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.exemple.codegym.utils.LocaleHelper

abstract class BaseActivity : AppCompatActivity() {

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(LocaleHelper.wrap(newBase))
    }
}