package com.example.bookinglayoutbyfigma.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bookinglayoutbyfigma.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TourInfoScreen(
    onBack: () -> Unit = {}
){
    Scaffold { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ){
            Column(modifier = Modifier.fillMaxSize()) {
                ImageTopCard(onBack = onBack)
                DataSlider(modifier = Modifier.weight(1f))
            }
        }
    }
}

class ArcTopShape(private val arcHeight: Float = 30f) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val path = Path().apply {
            moveTo(0f, size.height)
            lineTo(0f, arcHeight)
            quadraticBezierTo(
                size.width / 2,
                -arcHeight,
                size.width,
                arcHeight
            )
            lineTo(size.width, size.height)
            close()
        }
        return Outline.Generic(path)
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
    Button(
        modifier = Modifier.fillMaxWidth(),
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
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
        }
    }
}

@Composable
fun DataSlider(modifier: Modifier = Modifier){
    Box(
        modifier = modifier
            .offset(y = (-60).dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxSize()
                .shadow(10.dp, RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .clip(ArcTopShape(arcHeight = 20f))
                .background(Color.White)
                .verticalScroll(rememberScrollState())
        ){
            Column(
                modifier = Modifier
                    .background(color = Color.White)
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 15.dp),
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
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
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
                                .padding(end = 5.dp)
                        )
                        Text(
                            text = "Tekergat",
                            fontSize = 18.sp,
                            color = Color(0xFF7C838C)
                        )
                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically
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
                        verticalAlignment = Alignment.CenterVertically
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

                Spacer(modifier = Modifier.height(20.dp))

                BookingButton()

                Spacer(modifier = Modifier.height(30.dp))
            }
        }
    }
}

@Composable
fun ImageTopCard(
    onBack: () -> Unit
){
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(320.dp)){
        Image(
            painter = painterResource(id = R.drawable.backphoto),
            contentDescription = "photo",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop
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

        IconButton(onClick = onBack,
            modifier = Modifier
                .clip(CircleShape)
                .height(45.dp)
                .width(45.dp)
                .background(Color.Black.copy(alpha = 0.1f))
        ) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = "back",
                tint = Color.White
            )
        }

        Text(
            text = "Details",
            fontSize = 20.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )

        IconButton(onClick = {},
            modifier = Modifier
                .clip(CircleShape)
                .height(45.dp)
                .width(45.dp)
                .background(Color.Black.copy(alpha = 0.1f))
        ) {
            Icon(
                imageVector = Icons.Default.FavoriteBorder,
                contentDescription = "Favorite",
                tint = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TourInfoScreenPreview() {
    TourInfoScreen()
}