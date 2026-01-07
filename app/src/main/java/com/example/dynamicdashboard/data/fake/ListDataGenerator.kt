package com.example.dynamicdashboard.data.fake

import com.example.dynamicdashboard.data.model.ListWidgetConfig
import kotlinx.coroutines.delay

object ListDataGenerator {

    suspend fun getListData(instanceId: String): List<ListWidgetConfig> {
        delay(1500)

        if (instanceId == "shows") {
            throw Exception("Failed to load shows")
        }

        return when (instanceId) {

            "movies" -> listOf(
                ListWidgetConfig("Arjun", "Mehta"),
                ListWidgetConfig("Rahul", "Verma"),
                ListWidgetConfig("Neha", "Sharma")
            )

            "shows" -> {
                throw Exception("Unable to fetch shows right now")
            }

            else -> listOf(
                ListWidgetConfig("Guest", "User")
            )
        }

    }
}
