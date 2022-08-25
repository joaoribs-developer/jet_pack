package com.example.app_tela

import android.content.Context
import android.os.Bundle
import android.widget.HorizontalScrollView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.app_tela.ui.theme.App_telaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App_telaTheme {

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ScrolerHorizontal(carros)
                }
            }
        }
    }
}

@Composable
fun ScrolerHorizontal(carros: List<Carro>){
    Card(
        Modifier
            .fillMaxSize()
            .padding(20.dp),
    backgroundColor = Color.Gray) {
        Column {
            Spacer(modifier = Modifier.height(200.dp))
            Row(Modifier.horizontalScroll(rememberScrollState())
            ) {
                repeat(10) {
                    carros.forEach { carro ->
                        Card(
                            backgroundColor = Color.White,
                            modifier = Modifier
                                .height(300.dp)
                                .height(200.dp)
                                .padding(12.dp)) {
                            Column(
                                modifier = Modifier.padding(12.dp)
                            ) {

                                    Image(painter = painterResource(id = carro.foto), contentDescription ="", Modifier.size(180.dp))


                                Text(
                                    //centralizar o texto abaixo da imagem
                                    text = carro.nome,
                                    textAlign = TextAlign.Center,
                                    style = MaterialTheme.typography.body1,
                                    modifier = Modifier.width(200.dp)


                                )
                                Text(
                                    //centralizar o texto abaixo da imagem
                                    textAlign = TextAlign.Center,
                                    text = carro.tipo,
                                    style = MaterialTheme.typography.body1,
                                    modifier = Modifier.width(200.dp),
                                    fontStyle = FontStyle.Italic
                                )
                            }
                        }
                    }
                }
            }
                        }



        
    }

//val gradient = Brush.horizontalGradient(0f to Color.Gray, 1000f to Color.White)
// Box(
//     modifier = Modifier
//         .background(Color.LightGray)
//         .horizontalScroll(rememberScrollState())
//         .padding(32.dp)
//    ) {
//        Row {
//            repeat(6) {
//             Box(
//                modifier = Modifier
//                    .height(128.dp)
//                    .horizontalScroll(rememberScrollState())
//            ) {
//                Text(
//                    "Scroll here",
//                    modifier = Modifier
//                        .border(12.dp, Color.DarkGray)
//                        .background(brush = gradient)
//                        .padding(24.dp)
//                        .height(150.dp)
//                ,
//                style = TextStyle(
//                    color = Color.Black
//                )
//                )
//            }
//        }
//    }
//}
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    App_telaTheme {
        ScrolerHorizontal(carros)

    }


}

class Carro(
    val nome: String,
    val tipo: String,
    val foto: Int
){

}
val carros = listOf<Carro>(
    Carro("carro", "passagem", R.drawable.img),
    Carro("carro", "passagem", R.drawable.img_1),
    Carro("carro", "passagem", R.drawable.img_2),
    Carro("carro", "passagem", R.drawable.img_3),
    Carro("carro", "passagem", R.drawable.img_4),
)