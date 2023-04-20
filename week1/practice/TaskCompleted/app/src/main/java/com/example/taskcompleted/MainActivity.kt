package com.example.taskcompleted

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskcompleted.model.Complete

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { TaskCompleteScreenApp() }
    }
}

@Composable
fun TaskCompleteScreenApp() {
    val result = rememberComplete(
        imagePainter = painterResource(id = R.drawable.ic_task_completed),
        allComplete = stringResource(id = R.string.all_task_completed),
        niceWork = stringResource(id = R.string.nice_work)
    )
    TaskCompletedScreen(result.value)
}


@Composable
fun rememberComplete(
    imagePainter: Painter,
    allComplete: String,
    niceWork: String,
): MutableState<Complete> {
    return remember {
        mutableStateOf(
            Complete(
                imagePainter = imagePainter,
                allComplete = allComplete,
                niceWork = niceWork
            )
        )
    }
}

@Composable
private fun TaskCompletedScreen(complete: Complete, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = complete.imagePainter,
            contentDescription = "ic_completed"
        )
        Text(
            text = complete.allComplete,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(top = 24.dp, bottom = 8.dp)
        )
        Text(
            text = complete.niceWork,
            fontSize = 16.sp
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TaskCompletedScreen(
        Complete(
            imagePainter = painterResource(id = R.drawable.ic_task_completed),
            allComplete = stringResource(id = R.string.all_task_completed),
            niceWork = stringResource(id = R.string.nice_work)
        )
    )
}