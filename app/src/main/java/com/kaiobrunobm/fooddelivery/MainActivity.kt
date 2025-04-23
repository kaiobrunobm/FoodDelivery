package com.kaiobrunobm.fooddelivery

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.kaiobrunobm.fooddelivery.activities.BurgerActivity
import com.kaiobrunobm.fooddelivery.ui.screen.DashBoardScreen
import com.kaiobrunobm.fooddelivery.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                DashBoardScreen(
                    onProductClick = {
                        Intent(applicationContext, BurgerActivity::class.java).also {
                            startActivity(it)
                        }
                    }
                )
            }
        }
    }
}