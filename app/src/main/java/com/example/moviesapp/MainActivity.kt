package com.example.moviesapp

import android.os.Bundle
import android.widget.ImageView.ScaleType
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moviesapp.ui.theme.MoviesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviesAppTheme {
                MoviesApp()
            }
        }
    }
}

@Composable
fun MoviesApp() {
    Column (Modifier.background(color = Color(18,14,20))) {
        HighLightMovie(
            "Homem-Aranha: Através do Aranhaverso",
            "Depois de se reunir com Gwen Stacy, Homem-Aranha é jogado no multiverso. Lá, o super-herói aracnídeo encontra uma numerosa equipe encarregada de proteger sua própria existência.",
            genres = listOf("Ação", "Aventura")
        )
    }
}

@Composable
fun Genre(name: String) {
    Text(name, fontSize = 12.sp, color = Color.Red, fontWeight = FontWeight.Medium, modifier = Modifier
        .border(width = 1.dp, color = Color.Red, shape = RoundedCornerShape(100))
        .padding(horizontal = 12.dp, vertical = 6.dp))
}

@Composable
fun HightLightMoviePicture () {
    Box {
        Image(painter = painterResource(id = R.drawable.spider), contentDescription = "Spider",
            Modifier
                .height(300.dp)
                .align(Alignment.TopStart), contentScale = ContentScale.Crop, alignment = Alignment.TopStart)
        Box(modifier = Modifier
            .height(64.dp)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.Transparent,
                        Color(18, 14, 20)
                    )
                )
            )
            .fillMaxWidth()
            .align(Alignment.BottomCenter))
    }
}

@Composable
fun HighLightMovieContent(title: String, description: String, genres: List<String>) {
    Column (verticalArrangement = Arrangement.spacedBy(4.dp), modifier = Modifier
        .offset(y = (-28).dp)
        .padding(horizontal = 24.dp)) {
        Text(title, fontWeight = FontWeight.SemiBold, fontSize = 24.sp, color = Color.White)
        Text(description, fontSize = 12.sp, color = Color.White, lineHeight = 16.sp)
        Row (horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.padding(top=12.dp)) {
            genres.forEach {
                Genre(it)
            }
        }
    }
}

@Composable
fun HighLightMovie(title: String, description: String, genres: List<String>) {
    Column {
        HightLightMoviePicture()
        HighLightMovieContent(title, description, genres)
    }
}

@Preview
@Composable
fun MoviesAppPreview() {
    MoviesAppTheme {
        MoviesApp()
    }
}