import android.preference.PreferenceActivity.Header
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trevel_application.R

@Composable
fun Header() {
    val interFont = FontFamily(
        Font(R.font.inter, FontWeight.Normal)
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 30.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(Modifier.padding(end = 8.dp)) {
                Text(
                    text = "Hi Almaz \uD83D\uDC4B",
                    fontFamily = FontFamily(Font(R.font.montserrat_bold, FontWeight.Bold)),
                    fontSize = 28.sp,
                    color = colorResource(R.color.dark_grey)
                )
                Text(
                    text = "Исследуйте мир",
                    fontFamily = interFont,
                    fontSize = 20.sp,
                    color = colorResource(R.color.grey)
                )
            }
            Image(
                bitmap = ImageBitmap.imageResource(R.drawable.avater),
                contentDescription = "icon",
                modifier = Modifier
                    .height(50.dp)
                    .width(50.dp)
                    .clip(CircleShape)
            )
        }
    }
}