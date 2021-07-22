package com.ujwalthote.composeexamples

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                MainView()
            }
        }
    }
}


@ExperimentalMaterialApi
@Composable
fun MainView() {
    LazyColumn {
        items(20) { index ->
            ListItem(textToBeShown = "Item $index")
        }
    }
}


@ExperimentalMaterialApi
@Composable
fun ListItem(textToBeShown: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp,4.dp),
        onClick = {
            Log.d("tag", textToBeShown)
        }
    ) {
        Text(
            fontSize  = 18.sp,
            modifier = Modifier
                .padding(16.dp,8.dp),
            text = textToBeShown,
            textAlign = TextAlign.Center

        )
    }
}

@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainView()
}

@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun ListDefaultPreview() {
    ListItem(textToBeShown = "Text To Be Shown")
}

