package org.rikimukhraa.project.screen.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.rikimukhraa.project.data.model.Product


@Composable
fun ProductScreen(
){
    Box(
        modifier = Modifier.fillMaxWidth()
    )
    Column(modifier = Modifier.fillMaxWidth().padding(10.dp)) {
        Text(text = "halaman Detaol")
        Spacer(modifier = Modifier.height(10.dp))

    }
}