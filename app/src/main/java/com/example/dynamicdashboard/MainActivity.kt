package com.example.dynamicdashboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.dynamicdashboard.data.model.WidgetMeta
import com.example.dynamicdashboard.data.model.WidgetType
import com.example.dynamicdashboard.ui.dashboard.DashboardScreen
import com.example.dynamicdashboard.ui.theme.DashboardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DashboardScreen(
                widgets = dashboardWidgets
            )
        }
    }
}

val dashboardWidgets = listOf(
    WidgetMeta(WidgetType.BANNER, "pokemon"),
    WidgetMeta(WidgetType.BANNER, "cars"),
    WidgetMeta(WidgetType.BANNER, "bikes"),
    WidgetMeta(WidgetType.LIST, "movies"),
    WidgetMeta(WidgetType.LIST, "shows")
)

