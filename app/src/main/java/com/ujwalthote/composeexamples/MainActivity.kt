package com.ujwalthote.composeexamples

import android.content.Intent
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

    data class Data(val title: String, var classType : Class<*>? = null)

    val list by lazy {
        mutableListOf(
            Data("Canvas sample", AnimationSample::class.java),
            Data("Animation"),
        )
    }

    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                Modifier
                    .fillMaxSize()
                    .background(Color.Black)
                    .padding(0.dp, 20.dp)
            ) {
                MainView(Modifier.weight(7f))
                Box(
                    modifier = Modifier
                        .background(Color.Green)
                        .fillMaxSize()
                        .weight(3f),
                    contentAlignment = Alignment.Center
                    ) {
                    Button(
                        modifier = Modifier
                            .wrapContentSize(),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White) ,
                        onClick = {
                            Toast.makeText(
                                applicationContext,
                                "You clicked me",
                                Toast.LENGTH_SHORT
                            ).show()
                        }) {
                        Text(text = "Button")
                    }
                }
            }
        }
    }


    @ExperimentalMaterialApi
    @Composable
    fun MainView(modifier: Modifier = Modifier) {
        LazyColumn(
            modifier.background(Color.Red)
        ) {
            items(list.size) { index ->
                ListItem(dataObject = list[index])
            }
        }
    }


    @ExperimentalMaterialApi
    @Composable
    fun ListItem(dataObject: Data) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp, 4.dp),
            onClick = {
                dataObject.classType?.let {
                    startActivity(Intent(this, it))
                }

                Log.d("tag", dataObject.title)
            }
        ) {
            Text(
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(16.dp, 8.dp),
                text = dataObject.title,
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
        ListItem(Data("Some text"))
    }
}

