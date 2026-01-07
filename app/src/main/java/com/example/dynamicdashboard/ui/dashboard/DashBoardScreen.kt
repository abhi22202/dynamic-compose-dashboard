package com.example.dynamicdashboard.ui.dashboard

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.dynamicdashboard.data.fake.BannerDataGenerator
import com.example.dynamicdashboard.data.model.WidgetMeta
import com.example.dynamicdashboard.data.model.WidgetType
import com.example.dynamicdashboard.ui.widgets.BannerWidget
import com.example.dynamicdashboard.ui.widgets.ListWidget

@Composable
fun DashboardScreen(
    widgets: List<WidgetMeta>
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(vertical = 8.dp)
    ) {
        items(widgets) { widget ->
            when (widget.type) {

                WidgetType.BANNER -> {
                    val banners =
                        BannerDataGenerator.getBanner(widget.instanceId)
                    BannerWidget(banners)
                }

                WidgetType.LIST -> {
                    ListWidget(widget.instanceId)
                }
            }
        }
    }
}

