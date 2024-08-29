package com.example.cvapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cvapplication.ui.theme.CvApplicationTheme
import com.example.cvapplication.ui.theme.lalehzarFontFamily


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
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = lalehzarFontFamily,
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
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                HeaderPart()
                Spacer(modifier = Modifier.height(10.dp))
                MediaSection()
                Spacer(modifier = Modifier.height(20.dp))
                SkillIconPart()
                Spacer(modifier = Modifier.height(20.dp))
                DataSection()
                Spacer(modifier = Modifier.height(20.dp))

            }
        }
    }
}

@Composable
fun HeaderPart() {
    Column(modifier = Modifier.padding(20.dp), horizontalAlignment = Alignment.CenterHorizontally) {

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
                textAlign = TextAlign.Center,
                fontFamily = lalehzarFontFamily,
            )

        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            "عاشق برنامه نویسی موبایل هستم و همیشه تلاش میکنم تا خودم رو با همچی آپدیت نگه دارم و مداوم یاد بگیرم",
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Thin,
                color = Color.Black,
                textAlign = TextAlign.Center,
                fontFamily = lalehzarFontFamily,
            )

        )
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MediaSection() {
    FlowRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp), horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(modifier = Modifier.size(52.dp), onClick = {}) {
            Image(

                painter = painterResource(id = R.drawable.instagram_icon),
                contentDescription = "Instagram"
            )
        }
        IconButton(modifier = Modifier.size(52.dp), onClick = {}) {
            Image(

                painter = painterResource(id = R.drawable.telegram_icon),
                contentDescription = "Telegram"
            )
        }
        IconButton(modifier = Modifier.size(52.dp), onClick = {}) {
            Image(

                painter = painterResource(id = R.drawable.github_icon),
                contentDescription = "GitHub"
            )
        }
        IconButton(modifier = Modifier.size(52.dp), onClick = {}) {
            Image(

                painter = painterResource(id = R.drawable.linkedin_icon),
                contentDescription = "Linkedin"
            )
        }
    }
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
                    .height(110.dp)
                    .padding(10.dp),
                elevation = CardDefaults.cardElevation(4.dp),
                colors = CardDefaults.cardColors()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .align(Alignment.CenterHorizontally)
                        .padding(6.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
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
                        fontWeight = FontWeight.Medium,
                        fontFamily = lalehzarFontFamily,
                    )
                }
            }
        }
    }
}

@Composable
fun DataSection() {
    val skillList: List<String> = listOf(
        "سابقه ی یک سال کار با فریمورک فلاتر",
        "مسلط به زبان دارت و کاتلین و پایتون",
        "آشنا با Clean Architecture و معماری SOLID",
        "مسلط به پروتکل هایی مثل HTTP و MQTT",
        "" +
                "مسلط به state management هایی از جمله Bloc, Provider",
        "مسلط به کار با دیتابیس هایی از جمله Hive و Isar",
    )
    Column(
        modifier = Modifier
            .background(color = Color(0xffEEEEEE))
            .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            "مهارت های من",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            textAlign = TextAlign.Center,
            fontFamily = lalehzarFontFamily,
        )

        Column(modifier = Modifier.padding(10.dp), horizontalAlignment = Alignment.End) {
            skillList.forEach { item ->
                Text(
                    item,
                    style = TextStyle(
                        fontSize = 16.sp,
                        textAlign = TextAlign.End,
                        textDirection = TextDirection.Rtl,
                        fontFamily = lalehzarFontFamily,
                    )
                )
            }
        }
    }
}






























