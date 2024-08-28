package com.example.cvapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cvapplication.ui.theme.CvApplicationTheme


@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun MainScreen() {
    CvApplicationTheme {
        Scaffold(modifier = Modifier.fillMaxSize(),
            {
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            "محمد نیک مرد",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }, colors = TopAppBarDefaults.topAppBarColors(
                        titleContentColor = Color.White,
                        containerColor = Color.Black,
                    )
                )
            }) { contentPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(contentPadding)
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                HeaderPart()
                Spacer(modifier = Modifier.height(20.dp))
                SkillIconPart()

            }
        }
    }
}

@Composable
fun HeaderPart() {
    Spacer(modifier = Modifier.height(20.dp))
    Image(
        painter = painterResource(id = R.drawable.my_image),
        contentDescription = "MyImage",
        contentScale = ContentScale.Crop,
        alignment = Alignment.Center,
        modifier = Modifier
            .size(128.dp)
            .clip(
                CircleShape
            ),
    )
    Spacer(modifier = Modifier.height(20.dp))
    Text(
        "محمد ام برنامه نویس فلاتر و کاتلین",
        style = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            textAlign = TextAlign.Center
        )

    )
    Spacer(modifier = Modifier.height(10.dp))
    Text(
        "عاشق برنامه نویسی موبایل هستم و همیشه تلاش میکنم تا خودم رو با همچی آپدیت نگه دارم و مداوم یاد بگیرم",
        style = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Black,
            textAlign = TextAlign.Center
        )

    )
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SkillIconPart() {
    val skillToDrawableMap = mapOf(
        "Flutter" to R.drawable.flutter,
        "Dart" to R.drawable.dart,
        "Kotlin" to R.drawable.kotlin,
        "Compose" to R.drawable.compose,
        "English Language" to R.drawable.english_language,
        "GitHub" to R.drawable.github
    )

    val skillList: List<String> = skillToDrawableMap.keys.toList()

    FlowRow(horizontalArrangement = Arrangement.Center) {
        skillList.forEach { item ->
            Card(
                modifier = Modifier
                    .height(100.dp)
                    .padding(10.dp),
                elevation = CardDefaults.cardElevation(4.dp),
                colors = CardDefaults.cardColors()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(6.dp), horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Image(
                        painter = painterResource(
                            id = skillToDrawableMap[item] ?: R.drawable.my_image
                        ), contentDescription = "", modifier = Modifier.size(48.dp)
                    )
                    Text(
                        item,
                        fontSize = 16.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }
}