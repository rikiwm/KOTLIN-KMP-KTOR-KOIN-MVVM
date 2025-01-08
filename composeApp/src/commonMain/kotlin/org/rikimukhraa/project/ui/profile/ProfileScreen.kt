package org.rikimukhraa.project.ui.profile

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp


@Composable
fun ProfileScreen(
//    navi
) {
    Box(
        modifier = androidx.compose.ui.Modifier.fillMaxWidth()
    )
    Column(modifier = androidx.compose.ui.Modifier.fillMaxWidth().padding(10.dp)) {
        Text(text = "halaman Profile")
        Spacer(modifier = androidx.compose.ui.Modifier.height(10.dp))
//        Button(onClick = navigateToDetail) { Text("Profile") }

        Spacer(modifier = androidx.compose.ui.Modifier.height(10.dp))
    }
}