package com.example.tictactoe

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tictactoe.ui.theme.Purple700
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.websocket.*
import io.ktor.serialization.kotlinx.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

class GameLogicModel : ViewModel() {
	private var numberOfStepsPlayed by mutableStateOf(0)
		private set

	var gameAgainstHuman by mutableStateOf(false)

	var gameFinished by mutableStateOf(false)
		private set

	val buttonModifier: Modifier = Modifier
		.size(width = 100.dp, height = 100.dp)
		.padding(5.dp)

	var buttonColor by mutableStateOf(Purple700)
		private set

	private var _gameField = mutableStateListOf("", "", "", "", "", "", "", "", "")
	val gameField: MutableList<String> get() = _gameField

	private val client = HttpClient(CIO) {
		install(WebSockets) {
			contentConverter = KotlinxWebsocketSerializationConverter(Json)
			maxFrameSize = Long.MAX_VALUE
		}
	}

	/***********************************************************************************************
	 * Methods
	 **********************************************************************************************/
	fun handleMove(buttonId: Int) {
		if (isGameWon(buttonId)) {
			return
		}

		incrementNumberStepsPlayed()
		updateGamefield(buttonId)
		if (checkResult(Player.Player1.symbol)) {
			setGameWon(Player.Player1)
			return
		} else if (gameAgainstHuman and checkResult(Player.Player2.symbol)) {
			setGameWon(Player.Player2)
			return
		}

		if (!gameAgainstHuman and (whichPlayerClicked() == Player.Player1)) {
			incrementNumberStepsPlayed()
			viewModelScope.launch(Dispatchers.IO) { // equivalent as updateButton for human
				getNPCMove()
				if (checkResult(Player.Player2.symbol)) {
					setGameWon(Player.Player2)
				}
			}
		}
	}

	fun resetGame() {
		gameFinished = false
		buttonColor = Purple700
		numberOfStepsPlayed = 0
		clearGameField()
	}

	private fun clearGameField() {
		_gameField.clear()
		_gameField.addAll(List(9) { "" })
	}

	private fun setGameWon(player: Player) {
		buttonColor = if (player == Player.Player1) Color.Red else Color.Green
		gameFinished = true
		clearGameField()
	}

	private fun incrementNumberStepsPlayed() {
		numberOfStepsPlayed++
	}


	private fun updateGamefield(button: Int) {
		if (button in 0..8) {
			_gameField[button] = if (whichPlayerClicked() == Player.Player2) Player.Player2.symbol else Player.Player1.symbol
		}
	}

	private fun isGameWon(buttonId: Int): Boolean {
		return gameFinished || gameField[buttonId].isNotEmpty()
	}

	private fun whichPlayerClicked(): Player {
		return if (numberOfStepsPlayed % 2 == 0) Player.Player2 else Player.Player1
	}

	private fun checkResult(player: String): Boolean {
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
		if (_gameField.isEmpty()) {
			throw Exception("buttonTestList is empty")
		}
		for (pattern in winPatterns) {
			if (pattern.all { gameField[it] == player }) {
				return true
			}
		}
		return false
	}

	private suspend fun getNPCMove() {
		try {
			client.webSocket(
				host = "192.168.1.4", port = 8080, path = "/tictactoe"
			) {
				val gameFieldSer = GameField(_gameField.toMutableList())
				sendSerialized(gameFieldSer)
				val gamefieldSerReturn = receiveDeserialized<GameField>()
				_gameField.clear()
				_gameField.addAll(gamefieldSerReturn.gameField)
			}
		} catch (e: Exception) {
			e.printStackTrace()
		}
	}

	@Serializable
	data class GameField(val gameField: MutableList<String>)

	enum class Player(val symbol: String) {
		Player1("O"),
		Player2("X"),
	}
}
