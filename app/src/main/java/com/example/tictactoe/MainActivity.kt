package com.example.tictactoe

import android.os.Bundle
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
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.websocket.*
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
        val client = HttpClient(CIO)

        setContent {
            TicTacToeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(text = "TicTacToe",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.wrapContentSize(Alignment.TopCenter)
                                            .padding(16.dp))

                    Column(
                        //verticalArrangement = Arrangement.spacedBy(12.dp),
                        modifier = Modifier
                            .wrapContentSize(Alignment.Center)
                            .padding(5.dp)
                    ) {
                        var counter = 0
                        var isGameWon by remember { mutableStateOf(false) }
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
                                isGameWon = false
                                buttonColor = Purple700
                                buttonTextList.clear()
                                buttonTextList.addAll(List(9) { "" })
                        }) {
                            Text(text = "Reset Game")
                        }
                        Spacer(modifier = Modifier.height(36.dp))
                        for (i in 0..2) {
                            Row()
                            {
                                for (j in 0..2) {
                                    val buttonId = j + i * 3
                                    Button(modifier = buttonModifier, colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor),
                                        onClick = {
                                            if (isGameWon || buttonTextList[buttonId].isNotEmpty())
                                                return@Button
                                            counter = updateButton(buttonId, buttonTextList, counter)
                                            if(whichPlayerClicked(counter) == Player.Player2) {
                                                GlobalScope.launch {  // TODO: refactor here: might be shitty
                                                    getNPCMove(client)
                                                }
                                            }
                                            if(checkResult(buttonTextList, Player.Player1.symbol))
                                            {
                                                buttonColor = Color.Red
                                                isGameWon = true
                                            }
                                            else if(checkResult(buttonTextList, Player.Player2.symbol))
                                            {
                                                buttonColor = Color.Green
                                                isGameWon = true
                                            }
                                        }) {
                                        Text(buttonTextList[buttonId], fontSize = symbolSize)
                                    }
                                }
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
            buttonTextList[button] = if (whichPlayerClicked(counterPost) == Player.Player2) Player.Player2.symbol else Player.Player1.symbol
        }
        return counterPost
    }

    private fun whichPlayerClicked(counter: Int): Player {
        return if(counter % 2 == 0) Player.Player2 else Player.Player1
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

    enum class Player(val symbol: String) {
        Player1("O"),
        Player2("X"),
    }

    suspend fun getNPCMove(client: HttpClient): GameField? {
        var gamefieldSerReturn: GameField? = null
        client.webSocket(
            host = "localhost",
            port = 8080,
            path = "/tictactoe"
        ) {

            mutableListOf("X", "O", "O", "X", "", "O", "X", "", "")
            val gameField = mutableListOf("X", "O", "O", "", "", "O", "X", "", "")
            val gameFieldSer = GameField(gameField)

            sendSerialized(gameFieldSer)
            gamefieldSerReturn = receiveDeserialized<GameField>()
        }
        return gamefieldSerReturn
    }

    @Serializable
    data class GameField(val gameField : MutableList<String>)
}




