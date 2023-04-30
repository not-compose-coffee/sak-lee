package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
               LemonApp(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center)
                )
            }
        }
    }
}

@Composable
fun LemonApp(modifier: Modifier = Modifier) {

    val result = remember { mutableStateOf(1) }
    val lemon: Lemon = when (result.value) {
        1 -> {
            Lemon(R.drawable.lemon_tree, R.string.tab_select)
        }
        2 -> {
            Lemon(R.drawable.lemon_squeeze, R.string.keep)
        }
        3 -> {
            Lemon(R.drawable.lemon_drink, R.string.tap_drink)
        }
        else -> {
            Lemon(R.drawable.lemon_restart, R.string.tab_start)
        }
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(id = lemon.description),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Blue
        )
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(id = lemon.image),
            contentDescription = null,
            modifier = Modifier
                .border(
                    width = 2.dp,
                    color = colorResource(R.color.border),
                    shape = RoundedCornerShape(4.dp)
                )
                .clickable {
                    when (result.value) {
                        2 -> result.value = (1..4).random()
                        4 -> result.value = 1
                        else -> result.value++
                    }
                }
        )
    }
}

data class Lemon(
    val image: Int,
    val description: Int
)

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LemonadeTheme {
        LemonApp()
    }
}