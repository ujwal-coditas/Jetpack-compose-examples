package com.ujwalthote.composeexamples

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import com.ujwalthote.composeexamples.ui.theme.ComposeExamplesTheme

class AnimationSample : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeExamplesTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val canvasWidth = size.width
        val canvasHeight = size.height
        drawLine(
            color = Color.Black,
            start = Offset(x = size.width, y = 0f),
            end = Offset(x = 0f, y = size.height),
            strokeWidth = 3F
        )

        drawLine(
            color = Color.Black,
            start = Offset(x = 0f, y = 0f),
            end = Offset(x = size.width, y = size.height),
            strokeWidth = 3F
        )

        drawRoundRect(
            color = Color.Blue,
            size = Size(canvasWidth / 2, canvasHeight / 5),
            style = Stroke(4f),
            topLeft = Offset(x=canvasWidth/2-((canvasWidth/2)/2), y = canvasHeight/2-((canvasHeight/5)/2))
        )

        drawCircle(
            color = Color.LightGray,
            center = Offset(x = size.width / 2, y = size.height / 2),
            radius = size.minDimension / 10
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeExamplesTheme {
        Greeting()
    }
}