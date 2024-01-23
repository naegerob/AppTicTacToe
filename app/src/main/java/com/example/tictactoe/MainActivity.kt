package com.example.tictactoe

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tictactoe.ui.theme.TicTacToeTheme

class MainActivity : ComponentActivity() {


    val TAG = "Main"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TicTacToeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Text(text = "TicTacToe", fontSize = 30.sp, fontWeight = FontWeight.Bold,
                        modifier = Modifier.wrapContentSize(Alignment.TopCenter))
                    Column(
                        //verticalArrangement = Arrangement.spacedBy(12.dp),
                        modifier = Modifier
                            .wrapContentSize(Alignment.Center)
                            .padding(5.dp)
                    ) {
                        val buttonModifier = Modifier
                            .size(width = 100.dp, height = 100.dp)
                            .padding(5.dp)
                        val buttonTextList = mutableListOf("")

                        repeat(8) {
                            val text by remember { mutableStateOf("") }
                            buttonTextList.add(text)
                        }
                        
                        Row()
                        {
                            
                            Button(modifier = buttonModifier,
                                    onClick = {
                                        buttonTextList[0] = "X"
                                    }) {
                                Text(buttonTextList[0])
                                Log.d(TAG, buttonTextList[0])
                            }
                            Button(modifier = buttonModifier,
                                    onClick = { buttonTextList[1] = "O" }) {
                                Text(buttonTextList[1])
                                Log.d(TAG, buttonTextList[1])
                            }
                            Button(modifier = buttonModifier,
                                    onClick = { buttonTextList[2] = "X" }) {
                                Text(buttonTextList[2])
                                Log.d(TAG, buttonTextList[2])
                            }
                        }
                        Row()
                        {
                            Button(modifier = buttonModifier,
                                    onClick = { buttonTextList[3] = "A" }) {
                                Text(buttonTextList[3])
                                Log.d(TAG, buttonTextList[3])
                            }
                            Button(modifier = buttonModifier,
                                    onClick = { buttonTextList[4] = "B" }) {
                                Text(buttonTextList[4])
                                Log.d(TAG, buttonTextList[4])
                            }
                            Button(modifier = buttonModifier,
                                    onClick = { buttonTextList[5] = "C" }) {
                                Text(buttonTextList[5])
                                Log.d(TAG, buttonTextList[5])
                            }
                        }
                        Row()
                        {
                            Button(modifier = buttonModifier,
                                    onClick = { buttonTextList[6] = "D" }) {
                                Text(buttonTextList[6])
                                Log.d(TAG, buttonTextList[6])
                            }
                            Button(modifier = buttonModifier,
                                    onClick = { buttonTextList[7] = "E" }) {
                                Text(buttonTextList[7])
                                Log.d(TAG, buttonTextList[7])
                            }
                            Button(modifier = buttonModifier,
                                    onClick = { buttonTextList[8] = "F" }) {
                                Text(buttonTextList[8])
                                Log.d(TAG, buttonTextList[8])
                            }
                        }
                    }
                }
            }
        }
    }
    @Composable
    fun Greeting(name: String) {
        Text(modifier = Modifier.wrapContentSize(Alignment.Center),
            text = "Hello $name!")
    }
}



