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

    private fun checkResult(buttonTextList: SnapshotStateList<String>, player: String) : Boolean{
        val checkDiagonal1 = buttonTextList[0] == player
        val checkDiagonal2 = buttonTextList[4] == player
        val checkDiagonal3 = buttonTextList[8] == player
        val checkDiagonal = checkDiagonal1 && checkDiagonal2 && checkDiagonal3
        if (checkDiagonal)
        {
            return true
        }

        val checkDiagonal4 = buttonTextList[2] == player
        val checkDiagonal5 = buttonTextList[4] == player
        val checkDiagonal6 = buttonTextList[6] == player
        val checkDiagonal7 = checkDiagonal4 && checkDiagonal5 && checkDiagonal6
        if (checkDiagonal7)
        {
            return true
        }

        var offsetX = 0
        val offsetY = 3
        repeat(3) {
            val checkColumn1 = buttonTextList[offsetX] == player
            val checkColumn2 = buttonTextList[offsetX + offsetY] == player
            val checkColumn3 = buttonTextList[offsetX + 2 * offsetY] == player
            val checkColumn = checkColumn1 && checkColumn2 && checkColumn3
            if (checkColumn)
            {
                return true
            }

            val checkRow1 = buttonTextList[offsetX * offsetY] == player
            val checkRow2 = buttonTextList[offsetX * offsetY + 1] == player
            val checkRow3 = buttonTextList[offsetX * offsetY + 2] == player
            val checkRow = checkRow1 && checkRow2 && checkRow3
            if (checkRow)
            {
                return true
            }
            offsetX++
        }
        return false
    }

    enum class Player(val player: String) {
        Player1("X"),
        Player2("O"),
    }
}



