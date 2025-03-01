package com.example.trevel_application.screens


import Header
import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.trevel_application.DataSource
import com.example.trevel_application.Place
import com.example.trevel_application.R
import com.example.trevel_application.component.BottomDrawer
import com.example.trevel_application.component.HorizontalScrollView
import com.example.trevel_application.component.PlaceItem
import com.example.trevel_application.component.SearchBar
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.google.gson.Gson



@Composable
fun MainScreen(navController: NavController) {
    val context = LocalContext.current

    BackHandler {
        (context as? Activity)?.finishAffinity()
    }

    val systemUiController = rememberSystemUiController()

    val poppinsFamily = FontFamily(Font(R.font.poppins))

    SideEffect {
        systemUiController.setSystemBarsColor(
            color = Color.White,
            darkIcons = true
        )
    }

    Box(
        Modifier
            .background(Color.White)
            .fillMaxSize()
            .padding(top = 22.dp, start = 15.dp, end = 15.dp)
    ) {
        Column {
            Header()
            SearchBar()
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Популярные места",
                fontFamily = poppinsFamily,
                fontSize = 20.sp,
                color = colorResource(R.color.dark_grey)
            )
            Spacer(modifier = Modifier.height(10.dp))
            HorizontalScrollView()
            Spacer(modifier = Modifier.height(20.dp))
            Places(navController)
            BottomDrawer()
        }
    }
    // Внутри MainScreen после текста "Популярные места"
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Популярные места",
            fontFamily = poppinsFamily,
            fontSize = 20.sp,
            color = colorResource(R.color.dark_grey)
        )

        TextButton(
            onClick = { navController.navigate("list_screen") }
        ) {
            Text(
                text = "Смотреть все",
                color = Color.Black,
                fontFamily = poppinsFamily
            )
        }
    }
}





// screens/MainScreen.kt
@Composable
fun Places(navController: NavController) {
    val places = remember { DataSource.places }

    val scrollState = rememberScrollState()
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(scrollState),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        places.forEach { place ->
            PlaceItem(place = place, navController = navController)
        }
    }
}



