package com.example.dynamicdashboard.data.fake

import com.example.dynamicdashboard.data.model.BannerConfig

object BannerDataGenerator {

    fun getBanner(instanceId: String): List<BannerConfig> {
        return when (instanceId) {

            "cars" -> listOf(
                BannerConfig("Electric Cars", "Future of mobility"),
                BannerConfig("SUV Segment", "Comfort meets power")
            )

            "pokemon" -> listOf(
                BannerConfig("Starter Pokémon", "Choose your first partner"),
                BannerConfig("Legendary Pokémon", "Rare and powerful")
            )


            "bikes" -> listOf(
                BannerConfig("Ducati", "Superbike")
            )

            else -> emptyList()
        }
    }
}
