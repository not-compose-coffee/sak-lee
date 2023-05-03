package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme {
                    ArtSpaceApp(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentSize(Alignment.Center))
            }
        }
    }
}


@Composable
fun ArtSpaceApp(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ArtSpaceImage()
        Spacer(modifier = Modifier.height(16.dp))
        ArtSpaceInfo()
        Spacer(modifier = Modifier.height(16.dp))
        ArtSpaceButton(modifier)
    }
}

@Composable
private fun ArtSpaceButton(modifier: Modifier) {
    Row(modifier = modifier) {
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Previous")
        }

        Button(onClick = { /*TODO*/ }) {
            Text(text = "Next")
        }
    }
}

@Composable
private fun ArtSpaceInfo() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Name",
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp
        )
        Text(
            text = "author",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
    }
}


@Composable
fun ArtSpaceImage(
    modifier: Modifier = Modifier,
) {
    Box(  modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
        .border(1.dp, color = Color.Black),) {
        Image(
            modifier= modifier
                .fillMaxWidth()
                .padding(16.dp),
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "test",
            contentScale = ContentScale.FillWidth
        )
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}