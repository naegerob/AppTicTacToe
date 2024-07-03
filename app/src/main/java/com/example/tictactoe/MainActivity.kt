package com.example.tictactoe

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tictactoe.ui.theme.Purple700
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
                        var buttonColor by remember { mutableStateOf(Purple700) }
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
                        Button(modifier = Modifier.height(36.dp)
                            .align(CenterHorizontally),
                            colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor),
                            onClick = {
                                buttonColor = Purple700
                                buttonTextList.clear()
                                buttonTextList.addAll(List(9) { "" })
                        }) {
                            Text(text = "Reset Game")
                        }
                        Spacer(modifier = Modifier.height(36.dp))
                        Row()
                        {

                            Button(modifier = buttonModifier, colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor),
                                    onClick = {
                                        counter = updateButton(0, buttonTextList, counter)
                                        if(checkResult(buttonTextList, Player.Player1.player))
                                        {
                                            buttonColor = Color.Red
                                        }
                                        else if(checkResult(buttonTextList, Player.Player2.player))
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
                                        if(checkResult(buttonTextList, Player.Player1.player))
                                        {
                                            buttonColor = Color.Red
                                        }
                                        else if(checkResult(buttonTextList, Player.Player2.player))
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
                                        if(checkResult(buttonTextList, Player.Player1.player))
                                        {
                                            buttonColor = Color.Red
                                        }
                                        else if(checkResult(buttonTextList, Player.Player2.player))
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
                                        if(checkResult(buttonTextList, Player.Player1.player))
                                        {
                                            buttonColor = Color.Red
                                        }
                                        else if(checkResult(buttonTextList, Player.Player2.player))
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
                                        if(checkResult(buttonTextList, Player.Player1.player))
                                        {
                                            buttonColor = Color.Red
                                        }
                                        else if(checkResult(buttonTextList, Player.Player2.player))
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
                                        if(checkResult(buttonTextList, Player.Player1.player))
                                        {
                                            buttonColor = Color.Red
                                        }
                                        else if(checkResult(buttonTextList, Player.Player2.player))
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
                                        if(checkResult(buttonTextList, Player.Player1.player))
                                        {
                                            buttonColor = Color.Red
                                        }
                                        else if(checkResult(buttonTextList, Player.Player2.player))
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
                                        if(checkResult(buttonTextList, Player.Player1.player))
                                        {
                                            buttonColor = Color.Red
                                        }
                                        else if(checkResult(buttonTextList, Player.Player2.player))
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
                                        if(checkResult(buttonTextList, Player.Player1.player))
                                        {
                                            buttonColor = Color.Red
                                        }
                                        else if(checkResult(buttonTextList, Player.Player2.player))
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
            counterPost++
            buttonTextList[button] = if (whichPlayerClicked(counterPost)) "X" else "O"
        }
        return counterPost
    }

    private fun whichPlayerClicked(counter: Int): Boolean {
        return (counter % 2 == 0)
    }

    private fun checkResult(buttonTextList: SnapshotStateList<String>, player: String): Boolean {
        val winPatterns = listOf(
            listOf(0, 1, 2), // First row
            listOf(3, 4, 5), // Second row
            listOf(6, 7, 8), // Third row
            listOf(0, 3, 6), // First column
            listOf(1, 4, 7), // Second column
            listOf(2, 5, 8), // Third column
            listOf(0, 4, 8), // Diagonal from top-left to bottom-right
            listOf(2, 4, 6)  // Diagonal from top-right to bottom-left
        )
        for (pattern in winPatterns) {
            if (pattern.all { buttonTextList[it] == player }) {
                return true
            }
        }
        return false
    }

    enum class Player(val player: String) {
        Player1("O"),
        Player2("X"),
    }
}



