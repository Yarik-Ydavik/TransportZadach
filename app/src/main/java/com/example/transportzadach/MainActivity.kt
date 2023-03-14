package com.example.transportzadach

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.transportzadach.ui.theme.TransportZadachTheme
import kotlin.math.min
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TransportZadachTheme {
                Greeting()
            }
        }
    }
}

@Composable
fun Greeting() {
    var postavki: Array<Int> = arrayOf(100,150,50)
    var sklad: Array<Int> = arrayOf(75,80,60,85)

    var table = Array(sklad.size) { Array(postavki.size) { Random.nextInt(1, 15) } }

    var index1:Int = 0
    var index2:Int = 0

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Row() {
            Column() {
                Text(text = "  ")
                for (i in postavki){
                    Text(text = " ", fontSize = 8.sp)
                    Text(text = " "+i.toString()+" ")
                }
            }
            Column() {
                Row() {
                    for (j in sklad){
                        Text(text = " "+j.toString()+" ")
                    }
                }
                Row() {
                    // Реализация решения методом северо- западного угла
                    for (column in 0..sklad.size-1){
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            for (row in 0..postavki.size-1){
                                Text(text = " "+ table[column][row].toString()+"  ", fontSize = 8.sp)
                                val value = min(sklad[column], postavki[row])
                                Text(text = " "+value.toString()+" ")
                                sklad[column] -= value
                                postavki[row] -=value
                                if (sklad[column] ==0) continue
                                if (postavki[row]==0) continue
                            }
                        }
                    }
                }
            }
        }
    }
}

