package com.example.trevel_application




object DataSource {
    val places = listOf(
        Place(
            place = "Гора Фудзи",
            city = "Токио",
            country = "Япония",
            rating = 4.9,
            isFavorite = true,
            price = 200,
            duration = 12,
            temperature = 15,
            description = R.string.fuji_description, // Ссылка на ресурс
            imageLink = R.drawable.mountine
        ),
        Place(
            place = "Горы Анды",
            city = "",
            country = "Южная Америка",
            rating = 4.5,
            isFavorite = false,
            price = 230,
            duration = 72,
            temperature = 10,
            description = R.string.andes_description, // Ссылка на ресурс
            imageLink = R.drawable.mountine2
        )
    )
}