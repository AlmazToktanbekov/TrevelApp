package com.example.trevel_application.component

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trevel_application.R


@Composable
fun HorizontalScrollView() {

    var selectedButton by remember { mutableStateOf(0) }


    val scrollState = rememberScrollState()


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(scrollState),

        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Кнопки
        ButtonItem(
            selectedButton = selectedButton,
            buttonIndex = 0,
            onClick = { selectedButton = 0 },
            text = "Самые просматриваемые"
        )

        ButtonItem(
            selectedButton = selectedButton,
            buttonIndex = 1,
            onClick = { selectedButton = 1 },
            text = "Рядом"
        )

        ButtonItem(
            selectedButton = selectedButton,
            buttonIndex = 2,
            onClick = { selectedButton = 2 },
            text = "Последние"
        )
    }
}

@Composable
fun ButtonItem(
    selectedButton: Int,
    buttonIndex: Int,
    onClick: () -> Unit,
    text: String
) {
    val robotoFont = FontFamily(
        Font(R.font.roboto, FontWeight.Normal)
    )
    Button(
        onClick = onClick,
        modifier = Modifier.padding(4.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (selectedButton == buttonIndex) Color(0xFF2F2F2F) else Color.Transparent,
            contentColor = if (selectedButton == buttonIndex) Color.White else Color(0xFFC5C5C5)
        )
    ) {
        Text(
            text = text,
            fontFamily = robotoFont,
            fontSize = 14.sp
        )
    }
}
