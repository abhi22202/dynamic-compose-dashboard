package com.example.dynamicdashboard.ui.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dynamicdashboard.data.model.BannerConfig

@Composable
fun BannerWidget(banners: List<BannerConfig>) {

    LazyRow(
        modifier = Modifier.padding(vertical = 8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(banners) { banner ->
            Card(
                modifier = Modifier
                    .padding(end = 12.dp)
                    .width(180.dp),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(6.dp)
            ) {
                Column(
                    modifier = Modifier
                        .background(Color(0xFFF2F2F2))
                        .padding(16.dp)
                ) {
                    Text(
                        text = banner.title,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = banner.subtitle,
                        fontSize = 14.sp,
                        color = Color.DarkGray
                    )
                }
            }
        }
    }
}

