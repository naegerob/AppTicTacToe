package com.example.tictactoe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tictactoe.ui.theme.TicTacToeTheme

class MainActivity : ComponentActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		val gameLogicModel: GameLogicModel by viewModels()

		setContent {
			TicTacToeTheme {
				ShowTicTacToeUI(gameLogicModel)
			}
		}
	}
}

@Composable
fun ShowTicTacToeUI(gameLogicModel: GameLogicModel) {
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

			Button(modifier = Modifier
				.height(36.dp)
				.align(CenterHorizontally),
				   colors = ButtonDefaults.buttonColors(backgroundColor = gameLogicModel.buttonColor),
				   onClick = {
					   gameLogicModel.resetGame()
				   }) {
				Text(text = "Reset Game")
			}

			Switch(modifier = Modifier
				.height(36.dp)
				.align(CenterHorizontally),
				   checked = gameLogicModel.gameAgainstHuman,
				   onCheckedChange = {
					   gameLogicModel.gameAgainstHuman = it
				   })
			Spacer(modifier = Modifier.height(36.dp))
			for (i in 0..2) {
				Row() {
					for (j in 0..2) {
						val buttonId = j + i * 3
						Button(modifier = gameLogicModel.buttonModifier,
							   colors = ButtonDefaults.buttonColors(backgroundColor = gameLogicModel.buttonColor),
							   onClick = {
								   gameLogicModel.handleMove(buttonId)
							   }) {
							Text(gameLogicModel.gameField[buttonId], fontSize = 36.sp)
						}
					}
				}
			}
		}
	}
}




