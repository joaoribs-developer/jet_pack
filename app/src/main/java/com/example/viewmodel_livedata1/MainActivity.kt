package com.example.viewmodel_livedata1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewModelScope
import com.example.viewmodel_livedata1.ui.theme.ViewModel.UserViewModel
import com.example.viewmodel_livedata1.ui.theme.Viewmodel_livedata1Theme

class MainActivity : ComponentActivity() {
    lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background
            ) {
                DefaultPreview()
            }
        }
    }


    @Composable
    fun LoginTextField() {
        TextField(
            value = "",
            shape = RoundedCornerShape(8.dp),
            onValueChange = {

            },
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            )
        )
    }

    @Composable
    fun Tela() {

    }

    @Composable
    fun SenhaTextField(userViewModel: UserViewModel) {
        var valorA by userViewModel.userLogin.observerAsState()
        var valorc by remember { mutableStateOf("") }

        OutlinedTextField(
            value = valorA,
            shape = RoundedCornerShape(8.dp),
            onValueChange = {
                valorA = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            )
        )
    }

    @Composable
    fun LoginButton() {
        Button(
            modifier = Modifier
                .height(64.dp)
                .fillMaxWidth(),
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(8),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF0246AB)),
        ) {
            Text(text = "Continuar", color = Color.White, fontSize = 20.sp)
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {

        Column {
            LoginTextField()
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(Color.Gray)
            )
            SenhaTextField()
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(Color.Gray)
            )
            LoginButton()

        }

    }
}
