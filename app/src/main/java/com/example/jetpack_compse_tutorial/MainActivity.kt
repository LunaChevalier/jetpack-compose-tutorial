package com.example.jetpack_compse_tutorial

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpack_compse_tutorial.ui.theme.JetpackcompsetutorialTheme
import com.example.jetpack_compse_tutorial.usecase.model.ToDo
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackcompsetutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    ToDoList(
                        mutableListOf(
                            ToDo(LocalDate.now(), "sample1"),
                            ToDo(LocalDate.now(), "sample2")
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(names: List<String>) {
    Column {
        for (name in names) {
            Text(text = "Hello as $name")
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ToDoList(todos: List<ToDo>) {
    Column {
        for (todo in todos) {
            Row(
                Modifier.padding(10.dp)
            ) {
               Text(text = todo.day.format(DateTimeFormatter.BASIC_ISO_DATE))
               Text(text = todo.title)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackcompsetutorialTheme {
        Greeting(mutableListOf("realtime", "sample code"))
    }
}