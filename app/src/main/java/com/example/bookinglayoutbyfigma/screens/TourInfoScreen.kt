package com.example.bookinglayoutbyfigma.screens

import android.annotation.SuppressLint
import android.media.Image
import androidx.compose.animation.core.withInfiniteAnimationFrameMillis
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.room.util.TableInfo
import com.example.bookinglayoutbyfigma.R
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults

@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "Range")
fun TourInfoScreen(
    onBack: () -> Unit = {}
){
    Scaffold { paddingValues ->
        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.White)){
            Column(modifier = Modifier.fillMaxSize()) {
                ImageTopCard(onBack = onBack)
                Box(
                    modifier = Modifier.fillMaxWidth()
                        .weight(1f)
                        .background(Color.White)
                ){
                    DataSlider()
                }
            }
        }

    }
}

@Composable
fun Description(){
    var isExpanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
    ) {
        Text(
            text = "About Destination",
            fontSize = 25.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "You will get a complete travel package on the beaches. " +
                    "Packages in the form of airline tickets, recommended Hotel rooms, " +
                    "Transportation, Have you ever been on holiday to the Greek ETC..." +
                    " is adding text ",
            fontSize = 18.sp,
            color = Color(0xFF7C838C),
            maxLines = if (isExpanded) Int.MAX_VALUE else 4,
        )

        Text(
            text = if (isExpanded) "Short" else "Read More",
            color = Color(0xFFFD6F29),
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .clickable { isExpanded = !isExpanded }
                .padding(vertical = 4.dp)
        )
    }

}


@Composable
fun PhotoViews(){
    val photos = listOf(
        R.drawable.miniphoto2,
        R.drawable.miniphoto3,
        R.drawable.miniphoto4,
        R.drawable.miniphoto5
    )

    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        photos.forEach { item ->
            Image(
                painter = painterResource(id = item),
                contentDescription = "photo",
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .height(50.dp)
                    .width(50.dp)

            )
        }
    }

}

@Composable
fun BookingButton(){
    Button(modifier = Modifier
        .fillMaxWidth(),
        onClick = {},
        shape = RoundedCornerShape(size = 15.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF24B9EB)
        )
    ){
        Box(modifier = Modifier.padding(10.dp)){
            Text(
                text = "Book Now",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

    }
}

@Composable
fun DataSlider(){
    Box(
        modifier = Modifier
            .offset(y = (-100).dp)
            .shadow(10.dp, RoundedCornerShape(60.dp))
            .clip(RoundedCornerShape(60.dp))
            .background(Color.White)
            .fillMaxHeight()
    ){
        Column(
            modifier = Modifier
                .background(color = Color.White)
                .clip(RoundedCornerShape(8.dp))
                .padding(20.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 15.dp)
                    .background(Color.White),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Column {
                    Text(
                        text = "Niladri Reservoir",
                        fontSize = 25.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Tekergat, Sunamgnj",
                        fontSize = 20.sp,
                        color = Color(0xFF7C838C)
                    )
                }

                Image(
                    painter = painterResource(id = R.drawable.avatar),
                    contentDescription = "photo",
                    modifier = Modifier
                        .height(60.dp)
                        .width(60.dp)
                        .clip(CircleShape)
                )


            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.pointicon),
                        contentDescription = "photo",
                        modifier = Modifier
                            .size(20.dp)
                            .fillMaxWidth()
                            .padding(end = 5.dp)
                    )
                    Text(
                        text = "Tekergat",
                        fontSize = 18.sp,
                        color = Color(0xFF7C838C)
                    )
                }


                Row(
                    modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        modifier = Modifier.padding(bottom = 4.dp, end = 3.dp),
                        text = "★",
                        fontSize = 18.sp,
                        color = Color(0xFFFFD700)
                    )
                    Text(
                        text = "4.7",
                        fontSize = 18.sp
                    )
                    Text(
                        text = "(2498)",
                        fontSize = 18.sp,
                        color = Color(0xFF7C838C)

                    )
                }

                Row(
                    modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {

                    Text(
                        text = "$59",
                        fontSize = 18.sp,
                        color = Color(0xFF3FC1ED)
                    )
                    Text(
                        text = "/Person",
                        fontSize = 18.sp,
                        color = Color(0xFF7C838C)

                    )
                }


            }

            PhotoViews()
            Description()
            BookingButton()
        }
    }

}


@Composable
fun ImageTopCard(
    onBack: () -> Unit
){
    Box(modifier = Modifier
        .fillMaxWidth()){
        Image(
            painter = painterResource(id = R.drawable.backphoto),
            contentDescription = "photo",
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
        )
        AppBar(onBack = onBack)
    }
}
@Composable
fun AppBar(
    onBack: () -> Unit
){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 20.dp, end = 20.dp, top = 50.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically) {
        //кнопка для вывхода
        IconButton(onClick = {onBack},
            modifier = Modifier
                .clip(CircleShape)
                .height(45.dp)
                .width(45.dp)
                .background(Color.Black.copy(alpha = 0.1f))
        ) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = "back"
            )
        }

        Text(
            text = "Details",
            fontSize = 20.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )

        //кнопка для избранного
        IconButton(onClick = {},
            modifier = Modifier
                .clip(CircleShape)
                .height(45.dp)
                .width(45.dp)
                .background(Color.Black.copy(alpha = 0.1f))
        ) {
            Icon(
                imageVector = Icons.Default.FavoriteBorder,
                contentDescription = "Favorite"
            )
        }
    }
}





@Preview(showBackground = true)
@Composable
fun TourInfoScreenPreview() {
    TourInfoScreen()
}

