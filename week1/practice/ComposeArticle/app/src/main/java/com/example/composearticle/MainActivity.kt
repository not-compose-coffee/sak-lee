package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.model.Article

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { ComposeArticleApp() }
    }
}


//  여러 @Composable을 그리기 위해 존재 하는 듯?
@Composable
fun ComposeArticleApp() {
    val result = rememberArticle(
        Article(
            imagePainter = painterResource(id = R.drawable.bg_compose_background),
            title = stringResource(id = R.string.title_jetpack_compose_tutorial),
            shortDescription = stringResource(id = R.string.compose_short_desc),
            longDescription = stringResource(id = R.string.compose_long_desc)
        )
    )

    ArticleCard(result.value)
}

/**
 * Compose는 선언형임으로 업데이트 하는 방법은 동일한 컴포저블을 호출해야함
 * 이를 remember Api를 사용하여 메모리에 객체 저장
 * 변경 가능하거나 변경불가한 객체 모두 저장하여 사용 가능
 *
 * */
@Composable
fun rememberArticle(
    article: Article
): MutableState<Article> {
    return remember {
        mutableStateOf(
            Article(
                imagePainter = article.imagePainter,
                title = article.title,
                shortDescription = article.shortDescription,
                longDescription = article.longDescription
            )
        )
    }
}

/**
 * textAlign 텍스트를 어떻게 정렳하지 결정하는 enum
 * Justify 양쪽정렬
 * Center가운데 ,Start,end ....
 * */
@Composable
private fun ArticleCard(
    article: Article,
    modifier: Modifier = Modifier
) {
    Column() {
        Image(
            painter = article.imagePainter,
            contentDescription = "1",
            modifier = modifier.fillMaxWidth()
        )
        Text(
            text = article.title,
            fontSize = 24.sp,
            modifier = modifier.padding(16.dp)
        )
        Text(
            text = article.shortDescription,
            fontSize = 16.sp,
            textAlign = TextAlign.Justify,
            modifier = modifier.padding(horizontal = 16.dp)
        )
        Text(
            text = article.longDescription,
            fontSize = 16.sp,
            textAlign = TextAlign.Justify,
            modifier = modifier.padding(16.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArticleCard(
        Article(
            imagePainter = painterResource(id = R.drawable.bg_compose_background),
            title = stringResource(id = R.string.title_jetpack_compose_tutorial),
            shortDescription = stringResource(id = R.string.compose_short_desc),
            longDescription = stringResource(id = R.string.compose_long_desc)
        )
    )
}