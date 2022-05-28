package com.techlads.meditation.ui.theme

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.techlads.meditation.Feature
import com.techlads.meditation.R
import com.techlads.meditation.Util
import com.techlads.meditation.standardQuadFromTo


/**
 * Created by Yasir on 5/16/2022.
 */
@ExperimentalFoundationApi
@Composable
fun MeditationDetailsScreen(
    navController: NavController
) {
    Box(modifier = Modifier
        .background(DeepBlue)
        .fillMaxSize()) {
           LazyColumn(modifier = Modifier
               .padding(24.dp)) {

               item {
                   NavBar()
                   MeditationDetails(title = "", message = "")

                   Divider(modifier = Modifier
                       .fillMaxWidth()
                       .height(0.5.dp),
                       color = AquaBlue
                   )

                   //RelatedSection(features = Util.feature)
               }
           }

    }
}


@Composable
fun NavBar() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
           // .padding(15.dp)
    ) {
        Icon(painter = painterResource(id = R.drawable.ic_arrow_back),
            contentDescription = "search",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )

        Icon(painter = painterResource(id = R.drawable.ic_star),
            contentDescription = "search",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun MeditationDetails(
    title: String,
    message: String,
) {
    val feature = Feature(
        title = "Sleep meditation",
        R.drawable.ic_headphone,
        BlueViolet1,
        BlueViolet2,
        BlueViolet3
    )

    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 15.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = feature.title,
                    style = MaterialTheme.typography.h2
                )

                Text(
                    text = "We wish you have a good day",
                    style = MaterialTheme.typography.body1
                )
            }
        }
        BoxWithConstraints(
            modifier = Modifier
                .padding(vertical = 7.5.dp)
                .aspectRatio(1f)
                .clip(RoundedCornerShape(10.dp))
                .background(feature.darkColor)
        ) {
            val width = constraints.maxWidth
            val height = constraints.maxHeight

            // Medium colored path
            val mediumColoredPoint1 = Offset(0f, height * 0.3f)
            val mediumColoredPoint2 = Offset(width * 0.1f, height * 0.35f)
            val mediumColoredPoint3 = Offset(width * 0.4f, height * 0.05f)
            val mediumColoredPoint4 = Offset(width * 0.75f, height * 0.7f)
            val mediumColoredPoint5 = Offset(width * 1.4f, -height.toFloat())

            val mediumColoredPath = Path().apply {
                moveTo(mediumColoredPoint1.x, mediumColoredPoint1.y)
                standardQuadFromTo(mediumColoredPoint1, mediumColoredPoint2)
                standardQuadFromTo(mediumColoredPoint2, mediumColoredPoint3)
                standardQuadFromTo(mediumColoredPoint3, mediumColoredPoint4)
                standardQuadFromTo(mediumColoredPoint4, mediumColoredPoint5)
                lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
                lineTo(-100f, height.toFloat() + 100f)
                close()
            }

            // Light colored path
            val lightPoint1 = Offset(0f, height * 0.35f)
            val lightPoint2 = Offset(width * 0.1f, height * 0.4f)
            val lightPoint3 = Offset(width * 0.3f, height * 0.35f)
            val lightPoint4 = Offset(width * 0.65f, height.toFloat())
            val lightPoint5 = Offset(width * 1.4f, -height.toFloat() / 3f)

            val lightColoredPath = Path().apply {
                moveTo(lightPoint1.x, lightPoint1.y)
                standardQuadFromTo(lightPoint1, lightPoint2)
                standardQuadFromTo(lightPoint2, lightPoint3)
                standardQuadFromTo(lightPoint3, lightPoint4)
                standardQuadFromTo(lightPoint4, lightPoint5)
                lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
                lineTo(-100f, height.toFloat() + 100f)
                close()
            }
            Canvas(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                drawPath(
                    path = mediumColoredPath,
                    color = feature.mediumColor
                )
                drawPath(
                    path = lightColoredPath,
                    color = feature.lightColor
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(15.dp)
            ) {
                Icon(
                    painter = painterResource(id = feature.iconId),
                    contentDescription = feature.title,
                    tint = Color.White,
                    modifier = Modifier.align(Alignment.BottomStart)
                )
                Text(
                    text = "Start",
                    color = TextWhite,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .clickable {
                            // Handle the click
                        }
                        .align(Alignment.BottomEnd)
                        .clip(RoundedCornerShape(10.dp))
                        .background(ButtonBlue)
                        .padding(vertical = 6.dp, horizontal = 15.dp)
                )
            }
        }
        FeatureDescription()
    }




}

@Composable
fun FeatureDescription() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 16.dp)) {
        Text(text = "Sleep Music • 45 min")
        Text( modifier = Modifier.padding(vertical = 8.dp),
            text = "Ease the mind into a restful night sleep with these deep, amblent tones."
        )
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()) {
            MeditationStats(R.drawable.ic_star, "12,542 Saved")
            MeditationStats(R.drawable.ic_headphone, "43,453 Listening")
        }
    }

}

@Composable
fun MeditationStats(statImage: Int, count: String) {
    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.wrapContentWidth()) {

        Icon(
            painter = painterResource(id = statImage),
            contentDescription = "Play",
            tint = Color.White,
            modifier = Modifier.size(16.dp)
        )
        Text(modifier = Modifier.padding(start = 8.dp),
            text = count)
    }
}

@ExperimentalFoundationApi
@Composable
fun RelatedSection(features: List<Feature>) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Releated",
            style = MaterialTheme.typography.h1,
            modifier = Modifier.padding(15.dp)
        )
        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
            modifier = Modifier.fillMaxHeight()
        ) {
            items(features.size) {
                FeatureItem(feature = features[it])
            }
        }
    }
}
