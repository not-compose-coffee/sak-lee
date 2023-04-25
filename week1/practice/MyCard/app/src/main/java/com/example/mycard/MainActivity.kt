package com.example.mycard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycard.ui.theme.MyCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyCardTheme {
                // A surface container using the 'background' color from the theme
                MyCard()
            }
        }
    }
}
//Box?
@Composable
private fun MyCard() {
    Column(
        Modifier
            .fillMaxWidth()
            .background(Color.DarkGray)
    ) {
        Row(Modifier.weight(3f)) {
            MyCardTitle(
                painterResource(id = R.drawable.ic_launcher_background),
                stringResource(R.string.name),
                stringResource(R.string.title_description)
            )

        }
        Column(Modifier.weight(1f)) {
            Divider(color = Color.White)
            MyCardUserInfo(
                image = painterResource(id = R.drawable.baseline_call_24),
                description = stringResource(R.string.phone_num),
            )
            Divider(color = Color.White)
            MyCardUserInfo(

                image = painterResource(id = R.drawable.baseline_share_24),
                description = stringResource(R.string.github_id),
            )
            Divider(color = Color.White)
            MyCardUserInfo(
                image = painterResource(id = R.drawable.baseline_email_24),
                description = stringResource(R.string.email),

                )
        }
    }
}


@Composable
private fun MyCardTitle(
    image: Painter,
    Title: String,
    description: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = image,
            contentDescription = stringResource(R.string.title_iv)
        )
        Text(
            text = Title,
            fontWeight = FontWeight.Bold,
            fontSize = 48.sp,
            color = Color.White,
            modifier = Modifier
                .padding(top = 12.dp, bottom = 6.dp)
        )
        Text(
            text = description,
            color = Color.Green,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
    }
}

@Composable
private fun MyCardUserInfo(image: Painter, description: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .padding(horizontal = 32.dp, vertical = 2.dp)
    ) {

        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.padding(end = 16.dp)
        )
        Text(text = description, fontSize = 16.sp, color = Color.White)
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyCardTheme {
        MyCard()
    }
}