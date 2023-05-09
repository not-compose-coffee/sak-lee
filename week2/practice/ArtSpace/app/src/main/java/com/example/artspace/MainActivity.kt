package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.data.ArtSpaceData
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
                        .wrapContentSize(Alignment.Center)
                )
            }
        }
    }
}


@Composable
fun ArtSpaceApp(modifier: Modifier = Modifier) {

    var result by remember { mutableStateOf(1) }

    var artSpaceData: ArtSpaceData = when (result) {
        1 -> ArtSpaceData(R.drawable.first_art, R.string.first_art_title, R.string.first_art_author)

        2 -> ArtSpaceData(
            R.drawable.second_art,
            R.string.second_art_title,
            R.string.second_art_author
        )

        3 -> ArtSpaceData(R.drawable.third_art, R.string.third_art_title, R.string.third_art_author)

        4 -> ArtSpaceData(
            R.drawable.fourth_art,
            R.string.fourth_art_title,
            R.string.fourth_art_author
        )
        else -> ArtSpaceData(
            R.drawable.first_art,
            R.string.first_art_title,
            R.string.first_art_author
        )
    }


    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ArtSpaceImage(modifier, artSpaceData)
        Spacer(modifier = Modifier.height(16.dp))
        ArtSpaceInfo(artSpaceData)
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = modifier, horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            Button(onClick = {
                if (result != 1) result -= 1
            }) {
                Text(text = "Previous")
            }

            Button(onClick = { if (result in 1..3) result += 1 else result -= 3 }) {
                Text(text = "Next")
            }
        }
    }
}

@Composable
private fun ArtSpaceInfo(artSpaceData: ArtSpaceData) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = artSpaceData.description),
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp
        )
        Text(
            text = stringResource(id = artSpaceData.author),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
    }
}


@Composable
fun ArtSpaceImage(
    modifier: Modifier = Modifier,
    artSpaceData: ArtSpaceData
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .border(1.dp, color = Color.Black),
    ) {
        Image(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp),
            painter = painterResource(id = artSpaceData.image),
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