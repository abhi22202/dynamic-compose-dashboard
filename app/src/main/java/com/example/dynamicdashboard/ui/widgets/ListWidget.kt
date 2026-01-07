package com.example.dynamicdashboard.ui.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dynamicdashboard.viewmodel.ListWidgetState
import com.example.dynamicdashboard.viewmodel.ListWidgetViewModel

@Composable
fun ListWidget(instanceId: String) {

    val viewModel = remember {
        ListWidgetViewModel(instanceId)
    }

    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            Text(
                text = instanceId.uppercase(),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(12.dp))

            when (val state = viewModel.state.value) {

                is ListWidgetState.Loading -> {
                    CircularProgressIndicator()
                }

                is ListWidgetState.Success -> {
                    state.data.forEach { item ->
                        Text(
                            text = "${item.name} ${item.surname}",
                            fontSize = 16.sp,
                            modifier = Modifier.padding(vertical = 4.dp)
                        )
                    }
                }

                is ListWidgetState.Error -> {
                    Text(
                        text = "Error: ${state.message}",
                        color = Color.Red,
                        fontSize = 14.sp
                    )
                }
            }
        }
    }
}

