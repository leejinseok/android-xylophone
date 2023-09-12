package com.example.xylophone

import android.media.SoundPool
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val soundPool = SoundPool.Builder().setMaxStreams(8).build()
        val sounds = listOf(
            SoundData(soundPool.load(this, R.raw.do1, 1), "도", Color.Red),
            SoundData(soundPool.load(this, R.raw.re, 1), "레", Color(0xFFFF9800)),
            SoundData(soundPool.load(this, R.raw.mi, 1), "미", Color(0xFFFFC107)),
            SoundData(soundPool.load(this, R.raw.fa, 1), "파", Color(0xFF8BC34A)),
            SoundData(soundPool.load(this, R.raw.sol, 1), "솔", Color(0xFF2196F3)),
            SoundData(soundPool.load(this, R.raw.la, 1), "라", Color(0xFF3F51B5)),
            SoundData(soundPool.load(this, R.raw.si, 1), "시", Color(0xFF673AB7)),
            SoundData(soundPool.load(this, R.raw.do2, 1), "도", Color.Red),
        )

        setContent {
            XylophoneScreen(sounds, playSound = { index ->
                soundPool.play(sounds[index].soundId, 1f, 1f, 0, 0, 1f)
            })
        }
    }
}

@Composable
fun XylophoneScreen(sounds: List<SoundData>, playSound: (Int) -> Unit) {
    Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceEvenly) {
        sounds.forEachIndexed { index, soundData ->
            val padding = (index + 2) * 8

            val modifier = Modifier
                .width(50.dp)
                .fillMaxHeight()
                .padding(vertical = padding.dp)
                .background(soundData.color)
                .clickable { playSound(index) }

            Keyboard(modifier = modifier, sound = soundData)
        }
    }
}

@Composable
fun Keyboard(modifier: Modifier, sound: SoundData) {
    Box(
        modifier = modifier
    ) {

        Text(
            text = sound.text,
            style = TextStyle(color = Color.White, fontSize = 20.sp),
            modifier = Modifier.align(
                Alignment.Center
            )
        )
    }
}
