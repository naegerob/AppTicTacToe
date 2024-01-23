package com.example.tictactoe

import android.R
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
                        var counter = 0
                        val buttonModifier = Modifier
                            .size(width = 100.dp, height = 100.dp)
                            .padding(5.dp)
                        var buttonColor = Color.Cyan
                        val symbolSize = 36.sp

                        val buttonTextList =
                            remember {
                                mutableStateListOf(
                                    "",
                                    "",
                                    "",
                                    "",
                                    "",
                                    "",
                                    "",
                                    "",
                                    ""
                                )
                            }

                        Row()
                        {

                            Button(modifier = buttonModifier, colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor),
                                    onClick = {
                                        counter = updateButton(0, buttonTextList, counter)
                                        if("X" == checkResult(buttonTextList))
                                        {
                                            buttonColor = Color.Red
                                        }
                                        else if("O" == checkResult(buttonTextList))
                                        {
                                            buttonColor = Color.Green
                                        }
                                    }) {
                                Text(buttonTextList[0], fontSize = symbolSize)
                                Log.d(TAG, buttonTextList[0])
                            }
                            Button(modifier = buttonModifier, colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor),
                                    onClick = {
                                        counter = updateButton(1,  buttonTextList, counter)
                                        if("X" == checkResult(buttonTextList))
                                        {
                                            buttonColor = Color.Red
                                        }
                                        else if("O" == checkResult(buttonTextList))
                                        {
                                            buttonColor = Color.Green
                                        }
                                    }) {
                                Text(buttonTextList[1], fontSize = symbolSize)
                                Log.d(TAG, buttonTextList[1])
                            }
                            Button(modifier = buttonModifier, colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor),
                                    onClick = {
                                        counter = updateButton(2, buttonTextList, counter)
                                        if("X" == checkResult(buttonTextList))
                                        {
                                            buttonColor = Color.Red
                                        }
                                        else if("O" == checkResult(buttonTextList))
                                        {
                                            buttonColor = Color.Green
                                        }
                                    }) {
                                Text(buttonTextList[2], fontSize = symbolSize)
                                Log.d(TAG, buttonTextList[2])
                            }
                        }
                        Row()
                        {
                            Button(modifier = buttonModifier, colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor),
                                    onClick = {
                                        counter = updateButton(3, buttonTextList, counter)
                                        if("X" == checkResult(buttonTextList))
                                        {
                                            buttonColor = Color.Red
                                        }
                                        else if("O" == checkResult(buttonTextList))
                                        {
                                            buttonColor = Color.Green
                                        }
                                    }) {
                                Text(buttonTextList[3], fontSize = symbolSize)
                                Log.d(TAG, buttonTextList[3])
                            }
                            Button(modifier = buttonModifier, colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor),
                                    onClick = {
                                        counter = updateButton(4, buttonTextList, counter)
                                        if("X" == checkResult(buttonTextList))
                                        {
                                            buttonColor = Color.Red
                                        }
                                        else if("O" == checkResult(buttonTextList))
                                        {
                                            buttonColor = Color.Green
                                        }
                                    }) {
                                Text(buttonTextList[4], fontSize = symbolSize)
                                Log.d(TAG, buttonTextList[4])
                            }
                            Button(modifier = buttonModifier, colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor),
                                    onClick = {
                                        counter = updateButton(5, buttonTextList, counter)
                                        if("X" == checkResult(buttonTextList))
                                        {
                                            buttonColor = Color.Red
                                        }
                                        else if("O" == checkResult(buttonTextList))
                                        {
                                            buttonColor = Color.Green
                                        }
                                    }) {
                                Text(buttonTextList[5], fontSize = symbolSize)
                                Log.d(TAG, buttonTextList[5])
                            }
                        }
                        Row()
                        {
                            Button(modifier = buttonModifier, colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor),
                                    onClick = {
                                        counter = updateButton(6, buttonTextList, counter)
                                        if("X" == checkResult(buttonTextList))
                                        {
                                            buttonColor = Color.Red
                                        }
                                        else if("O" == checkResult(buttonTextList))
                                        {
                                            buttonColor = Color.Green
                                        }
                                    }) {
                                Text(buttonTextList[6], fontSize = symbolSize)
                                Log.d(TAG, buttonTextList[6])
                            }
                            Button(modifier = buttonModifier, colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor),
                                    onClick = {
                                        counter = updateButton(7, buttonTextList, counter)
                                        if("X" == checkResult(buttonTextList))
                                        {
                                            buttonColor = Color.Red
                                        }
                                        else if("O" == checkResult(buttonTextList))
                                        {
                                            buttonColor = Color.Green
                                        }
                                    }) {
                                Text(buttonTextList[7], fontSize = symbolSize)
                                Log.d(TAG, buttonTextList[7])
                            }
                            Button(modifier = buttonModifier, colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor),
                                    onClick = {
                                        counter = updateButton(8, buttonTextList, counter)
                                        if("X" == checkResult(buttonTextList))
                                        {
                                            buttonColor = Color.Red
                                        }
                                        else if("O" == checkResult(buttonTextList))
                                        {
                                            buttonColor = Color.Green
                                        }
                                    }) {
                                ButtonDefaults.buttonColors(backgroundColor = buttonColor)
                                Text(buttonTextList[8], fontSize = symbolSize)
                                Log.d(TAG, buttonTextList[8])
                            }
                        }





                    }
                }
            }
        }
    }

    private fun updateButton(button: Int, buttonTextList : SnapshotStateList<String>, counter: Int) : Int {
        var counterPost = counter
        if(button in 0..8)
        {
            if(buttonTextList[button].isEmpty())
            {
                counterPost++
                if(whichPlayerClicked(counter = counterPost))
                {
                    buttonTextList[button] = "X"
                }
                else {
                    buttonTextList[button] = "O"
                }
            }
        }
        return counterPost
    }

    private fun whichPlayerClicked(counter: Int): Boolean {
        return (counter % 2 == 0)
    }

    private fun checkResult(buttonTextList: SnapshotStateList<String>) : String{
        val checkDiagonal1 = buttonTextList[0] == buttonTextList[4]
        val checkDiagonal2 = buttonTextList[4] == buttonTextList[8]
        val checkDiagonal = checkDiagonal1 && checkDiagonal2
        if (checkDiagonal)
        {
            return buttonTextList[0]
        }

        val checkDiagonal3 = buttonTextList[2] == buttonTextList[4]
        val checkDiagonal4 = buttonTextList[4] == buttonTextList[6]
        val checkDiagonalr = checkDiagonal3 && checkDiagonal4
        if (checkDiagonalr)
        {
            return buttonTextList[4]
        }

        var offsetX = 0
        val offsetY = 3
        repeat(3) {
            val checkColumn1 = buttonTextList[offsetX] == buttonTextList[offsetX + offsetY]
            val checkColumn2 = buttonTextList[offsetX + offsetY] == buttonTextList[offsetX + 2 * offsetY]
            val checkColumn = checkColumn1 || checkColumn2
            if (checkColumn)
            {
                return buttonTextList[offsetX]
            }

            val checkRow1 = buttonTextList[offsetX * offsetY] == buttonTextList[offsetX * offsetY + 1]
            val checkRow2 = buttonTextList[offsetX * offsetY + 1] == buttonTextList[offsetX * offsetY + 2]
            val checkRow = checkRow1 || checkRow2
            if (checkRow)
            {
                return buttonTextList[offsetX * offsetY]
            }
            offsetX++
        }
        return ""
    }


}



