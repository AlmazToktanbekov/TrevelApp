package com.example.trevel_application.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.trevel_application.Place
import com.example.trevel_application.R
import com.google.gson.Gson

@Composable
fun PlaceItem(place: Place, navController: NavController) {
    val placeJson = Gson().toJson(place)
    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        modifier = Modifier
            .size(250.dp, 350.dp)
            .padding(horizontal = 10.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clickable { navController.navigate("details_screen/$placeJson") }) {


            Image(
                painter = painterResource(id = place.imageLink),
                contentDescription = "Фон",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            var isFavorite by remember { mutableStateOf(place.isFavorite) }

            FavoriteIconButton(isFavorite = isFavorite) {
                isFavorite = !isFavorite
            }

            val robotoFont = FontFamily(Font(R.font.roboto, FontWeight.Normal))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .align(Alignment.BottomCenter)
                    .padding(16.dp)
                    .background(
                        Color.Black.copy(alpha = 0.5f),
                        shape = RoundedCornerShape(16.dp)
                    )
            ) {
                Column(modifier = Modifier.padding(10.dp)) {
                    Text(
                        text = "${place.place}, ${place.city}",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontFamily = robotoFont
                    )
                    Spacer(
                        modifier = Modifier
                            .height(15.dp)
                            .fillMaxWidth()
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.LocationOn,
                            contentDescription = "Местоположение",
                            tint = colorResource(R.color.pale_grey)
                        )
                        Text(
                            text = "${place.city}, ${place.country}",
                            color = colorResource(R.color.pale_grey),
                            fontSize = 12.sp,
                            fontFamily = robotoFont,
                            modifier = Modifier.padding(end = 15.dp)
                        )
                        Icon(
                            imageVector = Icons.Rounded.Star,
                            contentDescription = "Избранное",
                            tint = colorResource(R.color.pale_grey)
                        )
                        Text(
                            text = place.rating.toString(),
                            color = colorResource(R.color.pale_grey),
                            fontSize = 12.sp,
                            fontFamily = robotoFont
                        )
                    }
                }
            }
        }
    }
}