package com.curiousapps.listed.ui.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.curiousapps.listed.domain.ListIdItem

@Composable
fun ListIdRow(
    listIdItem: ListIdItem,
    modifier: Modifier = Modifier
){
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        elevation = 12.dp,
        backgroundColor = Color.LightGray,
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                modifier = modifier.align(Alignment.Start),
                text = "ListId: ${listIdItem.listId}" ,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                modifier = modifier.align(Alignment.Start),
                text = "Name: ${listIdItem.name}",
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun previewListIdRow(){
    val listIdItem = ListIdItem(
        id = 100,
        listId = 3,
        name = "JohnBoy"
    )

    ListIdRow(
        listIdItem = listIdItem
    )
}