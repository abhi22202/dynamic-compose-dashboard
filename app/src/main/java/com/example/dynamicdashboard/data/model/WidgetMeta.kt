package com.example.dynamicdashboard.data.model

data class WidgetMeta(
    val type: WidgetType,
    val instanceId: String
)

enum class WidgetType {
    BANNER,
    LIST
}
