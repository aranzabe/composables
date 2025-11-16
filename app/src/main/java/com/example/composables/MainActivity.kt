package com.example.composables

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composables.ui.theme.ComposablesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposablesTheme {
                //UsarBox()
                //UsoCols()
//                UsoRows()
                // Estados()
                LayoutCompleto()
            }
        }
    }
}


@Preview
@Composable
fun LayoutCompleto() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color.Red),
            contentAlignment = Alignment.Center
        ) {
            Text("Box 1", color = Color.White)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Green)
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text("Item 1")
            Text("Item 2")
            Text("Item 3")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Blue)
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Item A", color = Color.White)
            Text("Item B", color = Color.White)
        }
    }
}


@Composable
fun UsarBox(){

    Box(modifier = Modifier.background(color = Color.Red).width(300.dp).height(300.dp).padding(top = 2.dp).statusBarsPadding(),
        contentAlignment = Alignment.Center) {
        Text(text = "Jaaar")
    }
    Box(modifier = Modifier.background(color = Color.Blue).width(200.dp).height(200.dp).padding(2.dp),
        contentAlignment = Alignment.CenterEnd) {
        Text(text = "Hola")
    }
}



@Composable
fun UsoCols() {
    Column(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.padding(top = 20.dp)
        ) {

        }
        Column(
            modifier = Modifier.fillMaxWidth()
                .background(Color.Red),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Hola")
            Text("Hola")
            Text("Hola")
            Button(onClick = {}) {
                Text("Púlsame")
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Blue)
        ) {
            Text("Adios")
            Text("Adios")
            Text("Adios")
        }

    }

}

@Composable
fun UsoRows(){
    Column(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.padding(top = 20.dp)
        ) {

        }
        Row(modifier = Modifier.fillMaxWidth().background(Color.Green),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically) {
            Text("Hola")
            Text("Hola")
            Text("Hola")
            Button(onClick = {}) {
                Text("Púlsame")
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Blue)
        ) {
            Text("Adios")
            Text("Adios")
            Text("Adios")
        }
    }
}