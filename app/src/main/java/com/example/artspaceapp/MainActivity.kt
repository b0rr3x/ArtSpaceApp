package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.data.ArtInfo
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {

    val artimages = listOf(
        R.drawable.android1,
        R.drawable.android2,
        R.drawable.android3,
        R.drawable.android4
    )

    val artInfo = listOf(
        ArtInfo("Android at Phone","Dall-E", 2017),
        ArtInfo("Android Coding", "Dall-E", 2018),
        ArtInfo("Android Drawing", "Dall-E", 2019),
        ArtInfo("Android with Music", "Dall-E", 2020)
    )

    var actualIndex by remember { mutableStateOf(0) }
    val imageResource = artimages[actualIndex]
    val actualArtInfo = artInfo[actualIndex]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {

            Box(
                modifier = Modifier
                    .shadow(elevation = 4.dp, shape = RoundedCornerShape(4.dp))
                    .padding(16.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {

                Image(
                    painter = painterResource(id = imageResource),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                )

            }
        }

    Surface(
        modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
        color = Color(0xFFEDE7F6),
        shape = RoundedCornerShape(8.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {

                Text(
                    text = actualArtInfo.title,
                    style = TextStyle(
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Light,
                        textAlign = TextAlign.Start
                    )
                )
                Row(
                    modifier = Modifier.align(Alignment.Start)
                ) {
                    Text(
                        text = "${actualArtInfo.artist} ",
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Start
                        )
                    )

                    Text(
                        text = " (${actualArtInfo.year})",
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Light,
                            textAlign = TextAlign.Start
                        )
                    )
                }

            }
    }


    Spacer(modifier = Modifier.height(8.dp))

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(onClick = { actualIndex = (actualIndex - 1 + artimages.size) % artimages.size },
            modifier = Modifier.weight(1f).padding(end = 4.dp))
        {
            Text("Back")
        }

        Spacer(modifier = Modifier.width(16.dp))

        Button(onClick = { actualIndex = (actualIndex + 1) % artimages.size },
            modifier = Modifier.weight(1f).padding(start = 8.dp))
        {
            Text("Next")
        }
    }
    Spacer(modifier = Modifier.height(16.dp))


    }
}


@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceAppTheme {
        ArtSpaceApp()
    }
}