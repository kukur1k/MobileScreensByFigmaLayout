package com.example.bookinglayoutbyfigma.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bookinglayoutbyfigma.R
import androidx.compose.foundation.clickable

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    onHotelClick: () -> Unit = {},
    onFavoriteClick: (Int) -> Unit = {}
) {
    Scaffold { paddingValues ->
        Column {
            TopBar()
            TitleText()
            LazyRowHotels(
                onHotelClick = onHotelClick,
                onFavoriteClick = onFavoriteClick,
                hotelImages = listOf(
                    R.drawable.hotelimg1,
                    R.drawable.hotelimg1,
                )
            )
        }
    }
}

@Composable
fun TitleText(){
    Column(modifier = Modifier.padding(25.dp, top = 40.dp)) {
        Text(
            text = "Explore the",
            fontSize = 40.sp,
            fontWeight = FontWeight.ExtraLight
        )
        Row {
            Text(
                text = "Beautiful ",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )
            Box() {
                Text(
                    text = "world!",
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFFD6F29)
                )
                Image(
                    painter = painterResource(id = R.drawable.worldline),
                    contentDescription = "line",
                    modifier = Modifier
                        .size(100.dp)
                        .fillMaxWidth()
                )
            }
        }
    }
}

@Composable
fun LazyRowHotels(
    onHotelClick: () -> Unit,
    onFavoriteClick: (Int) -> Unit,
    hotelImages: List<Int>
){
    Column {
        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Best Destination",
                fontSize = 25.sp,
                fontWeight = FontWeight.SemiBold
            )
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {
                Text(
                    text = "View all",
                    fontSize = 15.sp,
                    color = Color(0xFFFD6F29)
                )
            }
        }
    }

    LazyRow {
        items(hotelImages.size) { index ->
            HotelCard(
                onClick = onHotelClick,
                imageRes = hotelImages[index],
                onFavoriteClick = { onFavoriteClick(index) }
            )
        }
    }
}

@Composable
fun HotelCard(
    onClick: () -> Unit,
    imageRes: Int,
    onFavoriteClick: () -> Unit
){
    Column(
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFFFFFFFF), RoundedCornerShape(8.dp))
            .width(300.dp)
            .clickable { onClick() }
    ) {
        Column(modifier = Modifier.padding(top = 20.dp)) {
            Box {
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = "photo",
                    modifier = Modifier
                        .size(300.dp)
                        .fillMaxWidth()
                )

                IconButton(
                    onClick = onFavoriteClick,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(end = 30.dp, top = 10.dp)
                        .clip(CircleShape)
                        .size(45.dp)
                        .background(Color.Black.copy(alpha = 0.3f))
                ) {
                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = "Favorite",
                        tint = Color.White
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp, horizontal = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Niladri Reservoir",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier.padding(bottom = 4.dp, end = 3.dp),
                        text = "★",
                        fontSize = 20.sp,
                        color = Color(0xFFFFD700)
                    )
                    Text(
                        text = "4.7",
                        fontSize = 20.sp
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 14.dp, end = 10.dp),
                horizontalArrangement = Arrangement.spacedBy(5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.pointicon),
                        contentDescription = "location",
                        modifier = Modifier
                            .size(25.dp)
                            .padding(end = 5.dp)
                    )
                    Text(
                        text = "Tekergat, Sunamgnj",
                        fontSize = 20.sp,
                        color = Color(0xFF7C838C)
                    )
                }

                Image(
                    painter = painterResource(id = R.drawable.facereviews),
                    contentDescription = "reviews",
                    modifier = Modifier
                        .height(50.dp)
                        .width(100.dp)
                )
            }
        }
    }
}

@Composable
fun TopBar(){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 20.dp, end = 20.dp, top = 50.dp),
        horizontalArrangement = Arrangement.SpaceBetween) {

        IconButton(
            modifier = Modifier
                .clip(CircleShape)
                .height(44.dp)
                .width(140.dp)
                .shadow(10.dp, RectangleShape)
                .background(Color(0xFFF5F5F7)),
            onClick = {}
        ) {
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Box(modifier = Modifier
                    .padding(start = 4.dp)
                    .clip(CircleShape)
                    .height(37.dp)
                    .width(37.dp)
                    .background(Color(0xFFFDDDE4))){
                    Image(
                        painter = painterResource(id = R.drawable.img),
                        contentDescription = "profileLogo",
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = Color.White)
                            .clip(CircleShape)
                    )
                }
                Box(modifier = Modifier
                    .padding(end = 10.dp, top = 7.dp)){
                    Text(
                        text = "Leonardo",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                }
            }
        }

        IconButton(onClick = {},
            modifier = Modifier
                .clip(CircleShape)
                .height(44.dp)
                .width(44.dp)
                .shadow(10.dp, RectangleShape)
                .background(Color(0xFFF5F5F7))
        ) {
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = "Notifications"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}