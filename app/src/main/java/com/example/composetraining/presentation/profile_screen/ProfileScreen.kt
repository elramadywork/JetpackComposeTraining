package com.example.composetraining.presentation.profile_screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetraining.R
import com.example.composetraining.domain.model.ImageWithText

@Composable
@Preview(showSystemUi = true)
fun ProfileScreen(){
    var selectedTapIndex by rememberSaveable {
        mutableIntStateOf(0)
    }
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TopBar(name = "Mahmoud ELramady")
        Spacer(modifier = Modifier.height(4.dp))
        ProfileSection()
        ProfileDescription(
            displayName = "Android developer(Java & Kotlin)",
            description ="+3 years of experience in Android development and +1 year of experience in Flutter \n" +
                    "Jetpack Compose| Xml | Clean Architecture | Solid Principles | Co-routines | " +
                    "Rx Java | dagger hilt | Room database | Paging 3 " ,
            url = "https://github.com/Mahmoud-ELramady",
            followedBy = listOf("eslamelsodany","kirbalo", "MonsifFadl","AmrElskhawy"),
            otherCount =5
        )
        ButtonSection()
        Spacer(modifier = Modifier.height(20.dp))
        HighlightSection(
            highlights = listOf(
            ImageWithText(painterResource(id = R.drawable.story1),"dagger hilt"),
            ImageWithText(painterResource(id = R.drawable.story3),"Android studio"),
            ImageWithText(painterResource(id = R.drawable.story4),"Jetpack Compose"),
            ImageWithText(painterResource(id = R.drawable.story5),"Google launches"),
            ImageWithText(painterResource(id = R.drawable.story1),"Room"),
        ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))
        PostTapLayout(listTaps = listOf(
            ImageWithText(image = painterResource(id = R.drawable.icon_grid),
                text = "Posts"
             ),
             ImageWithText(image = painterResource(id = R.drawable.icon_reel),
            text = "Reels"
            ),
            ImageWithText(image = painterResource(id = R.drawable.icon_igtv),

            text = "IGTV"
        ),
                ImageWithText(image = painterResource(id = R.drawable.ic_user),
            text = "User"
        )
        )) {
            selectedTapIndex=it
        }
        when(selectedTapIndex){
            0-> PostSecion(
                posts = listOf(
                painterResource(id = R.drawable.story1),
                painterResource(id = R.drawable.story2),
                painterResource(id = R.drawable.story3),
                painterResource(id = R.drawable.story4),
                painterResource(id = R.drawable.story5),
                painterResource(id = R.drawable.story1),
                painterResource(id = R.drawable.story2),
                painterResource(id = R.drawable.story3),
                painterResource(id = R.drawable.story4),
                painterResource(id = R.drawable.story5),
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }


    }

}



@Composable
fun TopBar(
    name:String,
    modifier: Modifier=Modifier
){
    Row(
       verticalAlignment =  Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {

       Icon(
           imageVector = Icons.Default.ArrowBack,
           contentDescription = "Back",
           tint = Color.Black,
           modifier = Modifier.size(24.dp)
       )
       Text(
           text = name,
           fontWeight = FontWeight.Bold,
           overflow = TextOverflow.Ellipsis,
           fontSize = 20.sp,
       )
        Icon(
            painter = painterResource(id = R.drawable.ic_bell),
            contentDescription = "Back",
            tint = Color.Black,
            modifier = Modifier.size(20.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_menu),
            contentDescription = "Back",
            tint = Color.Black,
            modifier = Modifier.size(20.dp)
        )

    }

}


@Composable
fun ProfileSection(
    modifier: Modifier=Modifier
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
    ) {
        RoundImage(
            image = painterResource(id = R.drawable.im_profile),
            modifier = Modifier
                .size(100.dp)
                .weight(3f)

        )
        Spacer(modifier = Modifier.width(16.dp))
        StateSection(modifier = Modifier.weight(7f))
    }
}

@Composable
fun RoundImage(
    image: Painter,
    modifier: Modifier=Modifier
){

  Image(
      painter = image,
      contentDescription = null,
      modifier = modifier
          .aspectRatio(1f, matchHeightConstraintsFirst = true)
          .border(
              1.dp,
              color = Color.LightGray,
              shape = CircleShape
          )
          .padding(3.dp)
          .clip(CircleShape)
  )



}

@Composable
fun StateSection(
    modifier: Modifier=Modifier
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
    ) {
        ProfileState(textNumber = "50", text = "Posts")
        ProfileState(textNumber = "100K", text = "Followers")
        ProfileState(textNumber = "80", text = "Following")
    }
}


@Composable
fun ProfileState(
    textNumber:String,
    text: String,
    modifier: Modifier=Modifier
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(
            text = textNumber,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = text,
        )
    }
}

@Composable
fun ProfileDescription(
    displayName:String,
    description:String,
    url:String,
    followedBy:List<String>,
    otherCount:Int
){
    val letterSpacing=0.5.sp
    val lineHeight=20.sp

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        Text(
            text = displayName,
            fontWeight = FontWeight.Bold,
            lineHeight=lineHeight,
            letterSpacing=letterSpacing
        )
        Text(
            text = description,
            lineHeight=lineHeight,
            letterSpacing=letterSpacing
        )
        Text(
            text = url,
            color = Color(0xFF3D3D91),
            lineHeight=lineHeight,
            letterSpacing=letterSpacing
        )

        if (followedBy.isNotEmpty()){
            Text(
                text = buildAnnotatedString {
                    val boldStyle= SpanStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                    append("Followed by ")

                    followedBy.forEachIndexed{index,name->
                        pushStyle(boldStyle)
                        append(name)
                        pop()

                        if (index<followedBy.size-1){
                            append(", ")
                        }
                    }

                    if (otherCount > 2){
                        append(" and ")
                        pushStyle(boldStyle)
                        append("$otherCount Others")
                    }

                },
                letterSpacing=letterSpacing,
                lineHeight=lineHeight
            )
        }

    }
}


@Composable
fun ButtonSection(
    modifier: Modifier=Modifier
){
    val minWidth=95.dp
    val height=30.dp
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier.fillMaxWidth()
    ){
        ActionButton(
            textButton = "Following",
            image = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minWidth)
                .height(height)

            )
        ActionButton(
            textButton = "Message",
            modifier = Modifier
                .defaultMinSize(minWidth)
                .height(height)

        )
        ActionButton(
            textButton = "Email",
            modifier = Modifier
                .defaultMinSize(minWidth)
                .height(height)

        )
        ActionButton(
            image = Icons.Default.KeyboardArrowDown,
            modifier = Modifier.size(height)
        )
    }
}


@Composable
fun ActionButton(
    modifier: Modifier=Modifier,
    textButton:String?=null,
    image:ImageVector?=null
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier.border(
            color = Color.LightGray,
            shape = RoundedCornerShape(5.dp),
            width = 1.dp
        )
    ) {


        if (textButton!=null){
            Text(
                text = textButton,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp
                )
        }


        if (image!=null){
            Icon(
                imageVector = image,
                contentDescription = null,
                tint = Color.Black
            )
        }



    }
}


@Composable
fun HighlightSection(
    modifier: Modifier=Modifier,
    highlights:List<ImageWithText>
){

    LazyRow(
        modifier = modifier
    ) {
        items(highlights.size) {index->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(end = 15.dp)
            ) {
                RoundImage(
                    image = highlights[index].image,
                    modifier = Modifier.size(70.dp)
                )

                Text(
                    text = highlights[index].text,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center

                )


            }
        }
    }
}

@Composable
fun  PostTapLayout(
    listTaps:List<ImageWithText>,
    modifier: Modifier=Modifier,
    onTapSelected:(selectedIndex:Int)->Unit
){

    var tapSelectedIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    var inactiveColor=Color(0xFF777777)


    TabRow(
        selectedTabIndex = tapSelectedIndex,
        contentColor = Color.Black,
        modifier = modifier,
    ) {
        listTaps.forEachIndexed{index,item->
        Tab(
            selected = tapSelectedIndex==index,
            selectedContentColor = Color.Black,
            unselectedContentColor = inactiveColor,
            onClick = {
                tapSelectedIndex = index
                onTapSelected(tapSelectedIndex)
            }

        ) {
            Icon(painter = item.image,
                contentDescription = item.text,
                tint = if (tapSelectedIndex==index) Color.Black else inactiveColor,
                modifier = Modifier
                    .padding(10.dp)
                    .size(20.dp)
                )
        }
    }
    }

}

@Composable
fun PostSecion(
    posts:List<Painter>,
    modifier: Modifier=Modifier
){
    LazyVerticalGrid(
        columns =GridCells.Fixed(3),
        modifier=modifier.scale(1.01f)
    ) {
        items(posts.size){index->
            Image(
                painter = posts[index],
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(
                        width = 1.dp,
                        color = Color.White
                    )

            )
        }
    }
}


