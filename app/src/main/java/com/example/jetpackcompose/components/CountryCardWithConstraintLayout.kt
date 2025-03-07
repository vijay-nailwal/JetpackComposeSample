package com.example.jetpackcompose.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.jetpackcompose.data.CountryInfo

@Composable
fun CountryCardWithConstraintLayout(countryInfo: CountryInfo) {
    ConstraintLayout(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth().padding(5.dp)
    ) {
        val (flag, commonName, capital, officialName, region, subregion, currencySymbol, currencyName, mobileCode, tld) = createRefs()
        val imageResId = countryInfo.flagId
        val imagePainter: Painter = painterResource(id = imageResId)

        //using barrier
        val startingBarrier = createStartBarrier(flag)
        val topBarrier = createTopBarrier(flag)
        val flagBottomBarrier = createBottomBarrier(flag)
        val bottomBarrier = createBottomBarrier(capital)

        //flag
        Image(painter = imagePainter,
            contentDescription = "Country Flag",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth(0.2f)
                .height(50.dp)
                .padding(2.dp)
                .constrainAs(flag) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                })

        //india
        Text(
            text = countryInfo.commonName,
            modifier = Modifier
                .padding(2.dp)
                .constrainAs(commonName) {
                    top.linkTo(flag.bottom)
                    start.linkTo(startingBarrier)
                    end.linkTo(flag.end)
                },
            fontFamily = FontFamily.SansSerif,
            textAlign = TextAlign.Center,
            fontSize = 20.sp
        )

        //new delhi
        Text(text = countryInfo.nationalCapital,
            fontSize = 15.sp,
            textAlign = TextAlign.Left,
            modifier = Modifier
                .padding(2.dp)
                .constrainAs(capital) {
                    top.linkTo(commonName.bottom)
                    start.linkTo(startingBarrier)
                    end.linkTo(flag.end)
                })
        //republic of india
        Text(text = countryInfo.officialName,
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .constrainAs(officialName) {
                    start.linkTo(flag.end)
                    end.linkTo(parent.end)
                }
                .padding(2.dp)
                .fillMaxWidth(0.60f))
        //asia
        Text(text = countryInfo.region,
            fontSize = 15.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .constrainAs(region) {
                    top.linkTo(officialName.bottom)
                    start.linkTo(flag.end)
                    end.linkTo(parent.end)
                }
                .padding(2.dp)
                .fillMaxWidth(0.60f))
        //south asia
        Text(text = countryInfo.subRegion,
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .constrainAs(subregion) {
                    start.linkTo(region.start)
                    end.linkTo(region.end)
                    top.linkTo(region.bottom)
                }
                .padding(2.dp)
                .fillMaxWidth(0.60f))
        CircularText(text = countryInfo.currencySymbol,
            modifier = Modifier
                .constrainAs(currencySymbol) {
                    start.linkTo(flag.end, margin = 30.dp)
                    bottom.linkTo(bottomBarrier, margin = 8.dp)
                })
        //indian rupee
        Text(
            text = countryInfo.currencyName,
            modifier = Modifier
                .constrainAs(currencyName) {
                    start.linkTo(subregion.start)
                    end.linkTo(subregion.end)
                    top.linkTo(subregion.bottom)
                }.fillMaxWidth(0.60f)
                .padding(2.dp),
            textAlign = TextAlign.Center

        )
        //+91
        Text(
            text = countryInfo.mobileCode,
            modifier = Modifier.constrainAs(mobileCode) {
                end.linkTo(parent.end)
                top.linkTo(subregion.bottom)

            }.width(50.dp)

        )

        //.in
        Text(
            text = countryInfo.tld,
            modifier = Modifier.constrainAs(tld) {
                top.linkTo(mobileCode.bottom)
                end.linkTo(mobileCode.end)
                start.linkTo(mobileCode.start)
            }.width(50.dp)
        )
    }
}