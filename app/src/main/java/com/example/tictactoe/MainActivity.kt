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
import io.ktor.serialization.kotlinx.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

class MainActivity : ComponentActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		val client = HttpClient(CIO) {
			install(WebSockets) {
				contentConverter = KotlinxWebsocketSerializationConverter(Json)
				maxFrameSize = Long.MAX_VALUE
			}
		}

		setContent {
			TicTacToeTheme {
				// A surface container using the 'background' color from the theme
				Surface(
					modifier = Modifier.fillMaxSize()
				) {
					Text(
						text = "TicTacToe",
						fontSize = 30.sp,
						fontWeight = FontWeight.Bold,
						modifier = Modifier
							.wrapContentSize(Alignment.TopCenter)
							.padding(16.dp)
					)

					Column(
						modifier = Modifier
							.wrapContentSize(Alignment.Center)
							.padding(5.dp)
					) {
						var numberOfStepsPlayed = 0
						var isGameWon by remember { mutableStateOf(false) }
						val buttonModifier = Modifier
							.size(width = 100.dp, height = 100.dp)
							.padding(5.dp)
						var buttonColor by remember { mutableStateOf(Purple700) }
						val symbolSize = 36.sp

						var buttonTextList = remember {
							mutableStateListOf(
								"", "", "", "", "", "", "", "", ""
							)
						}
						Button(modifier = Modifier
							.height(36.dp)
							.align(CenterHorizontally),
							colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor),
							onClick = {
								isGameWon = false
								buttonColor = Purple700
								buttonTextList.clear()
								buttonTextList.addAll(List(9) { "" })
								numberOfStepsPlayed = 0
							}) {
							Text(text = "Reset Game")
						}
						var gameAgainstHuman by remember { mutableStateOf(false) }

						Switch(modifier = Modifier
							.height(36.dp)
							.align(CenterHorizontally),
							checked = gameAgainstHuman,
							onCheckedChange = {
								gameAgainstHuman = it
							})
						Spacer(modifier = Modifier.height(36.dp))
						for (i in 0..2) {
							Row() {
								for (j in 0..2) {
									val buttonId = j + i * 3
									Button(modifier = buttonModifier,
										colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor),
										onClick = {
											if (isGameWon || buttonTextList[buttonId].isNotEmpty()) return@Button

											numberOfStepsPlayed++
											updateButton(
												buttonId, buttonTextList, numberOfStepsPlayed
											)
											if (checkResult(
													buttonTextList,
													Player.Player1.symbol
												)) {
												buttonColor = Color.Red
												isGameWon = true
												buttonTextList.clear()
												buttonTextList.addAll(List(9) { "" })
												return@Button
											} else if (gameAgainstHuman and checkResult(
													buttonTextList, Player.Player2.symbol
												)) {
												buttonColor = Color.Green
												buttonTextList.clear()
												buttonTextList.addAll(List(9) { "" })
												isGameWon = true
												return@Button
											}

											if (!gameAgainstHuman and (whichPlayerClicked(
													numberOfStepsPlayed
												) == Player.Player1)) {
												numberOfStepsPlayed++
												runBlocking(Dispatchers.IO) { // equivalent as updateButton for human
													buttonTextList =
														getNPCMove(client, buttonTextList)
												}
												if (checkResult(
														buttonTextList, Player.Player2.symbol
													)) {
													buttonColor = Color.Green
													isGameWon = true
													buttonTextList.clear()
													buttonTextList.addAll(List(9) { "" })
													return@Button
												}
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

	private fun updateButton(button: Int, buttonTextList: MutableList<String>, counter: Int) {
		if (button in 0..8) {
			buttonTextList[button] =
				if (whichPlayerClicked(counter) == Player.Player2) Player.Player2.symbol else Player.Player1.symbol
		}
	}

	private fun whichPlayerClicked(counter: Int): Player {
		return if (counter % 2 == 0) Player.Player2 else Player.Player1
	}

	private fun checkResult(buttonTextList: MutableList<String>, player: String): Boolean {
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

		if (buttonTextList.isEmpty()) {
			throw Exception("buttonTestList is empty")
		}
		for (pattern in winPatterns) {
			if (pattern.all { buttonTextList[it] == player }) {
				return true
			}
		}
		return false
	}

	enum class Player(val symbol: String) {
		Player1("O"), Player2("X"),
	}

	suspend fun getNPCMove(
		client: HttpClient, gameField: SnapshotStateList<String>): SnapshotStateList<String> {
		val buttonTextListResponse: SnapshotStateList<String> = mutableStateListOf<String>()
		try {
			client.webSocket(
				host = "192.168.1.4", port = 8080, path = "/tictactoe"
			) {
				val gameFieldSer = GameField(gameField.toMutableList())
				sendSerialized(gameFieldSer)
				val gamefieldSerReturn = receiveDeserialized<GameField>()
				buttonTextListResponse.addAll(gamefieldSerReturn.gameField)
			}
		} catch (e: Exception) {
			e.printStackTrace()
		}
		return buttonTextListResponse
	}

	@Serializable
	data class GameField(val gameField: MutableList<String>)
}




