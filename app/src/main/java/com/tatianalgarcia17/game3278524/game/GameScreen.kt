package com.tatianalgarcia17.game3278524.game

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember


@Composable
fun GameScreen(){
    var gameStarted by remember { mutableStateOf(false) }
    Box(modifier = Modifier.fillMaxSize()){
        Canvas(modifier = Modifier.fillMaxSize()){
            val player = Player(
                x = size.width / 2f,
                y = size.height -100f
            )
            drawRect(
                color = Color.Black
            )
        }
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(top = 60.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "SPACE SHOOTER",
                color = Color.White,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )
            Button(onClick = {
                gameStarted = true
            }) {
                Text(text = "START")
            }
            if(gameStarted){
                Text(text = "GAME STARTED",color = Color.White)
            }
        }

    }


}