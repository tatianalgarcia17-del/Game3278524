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
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.ui.layout.onSizeChanged


@Composable
fun GameScreen() {
    var gameStarted by remember { mutableStateOf(false) }
    var playerX by remember {mutableStateOf(0f)}
    var playerY by remember {mutableStateOf(0f)}
    val player = remember { Player(x=0f, y=0f)}
    var playerInitialized by remember {mutableStateOf(false)}
    Box(modifier = Modifier.fillMaxSize()){

        Canvas(modifier = Modifier.fillMaxSize()
            .onSizeChanged{ size ->
                if(!playerInitialized){
                    playerX = size.width / 2f
                    playerY = size.height -100f
                    playerInitialized = true
                }

            }
            .pointerInput(Unit){
                detectDragGestures(
                    onDrag = { change, dragAmount ->
                        change.consume()
                       // val dragX = dragAmount.x
                        playerX+= dragAmount.x

                    }
                )
            }

        )
            {
                /* val initialX = size.width / 2f
                val initialY = size.height -100f
            if(playerX == 0f && playerY ==0f){
                playerX = initialX
                playerY = initialY
            } */

            val shipWidth =80f
            val shipHeight =60f
            val left = playerX - shipWidth / 2f
            val top = playerY - shipHeight / 2f
            val right = playerX + shipWidth / 2f
            val bottom = playerY + shipHeight / 2f
            drawRect(
                color = Color.Black
            )
            val shipPath = Path().apply {
                moveTo(playerX,top)
                lineTo(left,bottom)
                lineTo(playerX,bottom-15f)
                lineTo(right,bottom)
                close()
            }
            drawPath(
                path = shipPath,
                color = Color.White
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
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