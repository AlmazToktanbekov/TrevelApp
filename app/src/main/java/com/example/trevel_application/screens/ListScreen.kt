// ListScreen.kt
package com.example.trevel_application.screens

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.trevel_application.R

@Composable
fun ListScreen(navController: NavController) {
    val context = LocalContext.current
    val images = listOf(
        R.drawable.mountine,
        R.drawable.mountine2,
        R.drawable.travel,
        R.drawable.cloud
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // App Bar
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Назад",
                    tint = Color.Black
                )
            }
            Text(
                text = "Галерея изображений",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier
                    .padding(start = 8.dp)
            )

        }

        Spacer(modifier = Modifier.height(16.dp))

        // Список изображений
        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(images) { image ->
                ImageCard(imageRes = image)
            }
        }

        // Кнопка поделиться
        val shareIntent = remember {
            Intent().apply {
                action = Intent.ACTION_SEND
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, "Посмотрите эти красивые места!")
            }
        }

        Button(
            onClick = { context.startActivity(Intent.createChooser(shareIntent, "Поделиться")) },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF2196F3))
        ) {
            Icon(Icons.Default.Share, contentDescription = "Поделиться")
            Spacer(modifier = Modifier.width(8.dp))
            Text("Поделиться", style = MaterialTheme.typography.labelLarge)
        }
    }
}

@Composable
fun ImageCard(imageRes: Int) {
    var rating by remember { mutableStateOf(0) }

    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = "Изображение",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )

            // Рейтинг
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                (1..5).forEach { index ->
                    IconButton(
                        onClick = { rating = index },
                        modifier = Modifier.size(32.dp))
                    {
                        Icon(
                            painter = painterResource(id = R.drawable.star),
                            contentDescription = "Звезда",
                            tint = if (index <= rating) Color.Yellow else Color.Gray
                        )
                    }
                }
            }
        }
    }
}