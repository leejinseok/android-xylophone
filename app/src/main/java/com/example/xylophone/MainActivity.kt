package com.example.xylophone

import android.media.SoundPool
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val soundPool = SoundPool.Builder().setMaxStreams(8).build()
        val sounds = listOf(
            SoundData(soundPool.load(this, R.raw.do1, 1), "도", Color.Red),
            SoundData(soundPool.load(this, R.raw.re, 1), "레", Color.Black),
            SoundData(soundPool.load(this, R.raw.mi, 1), "미", Color.Black),
            SoundData(soundPool.load(this, R.raw.fa, 1), "파", Color.Black),
            SoundData(soundPool.load(this, R.raw.sol, 1), "솔", Color.Black),
            SoundData(soundPool.load(this, R.raw.la, 1), "라", Color.Black),
            SoundData(soundPool.load(this, R.raw.si, 1), "시", Color.Black),
            SoundData(soundPool.load(this, R.raw.do2, 1), "도", Color.Red),
        )

        fun playSound(index: Int) {
            soundPool.play(sounds[index].soundId, 1f, 1f, 0, 0,  1f)
        }

        setContent {

        }
    }
}

@Composable
fun XylophoneScreen() {

}
