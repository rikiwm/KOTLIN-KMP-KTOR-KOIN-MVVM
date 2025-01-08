package org.rikimukhraa.project.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Search

import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import org.koin.compose.viewmodel.koinViewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import com.seiko.imageloader.rememberImagePainter


@Composable
fun Homecreen(
    onNavigateToDetail:(prductId:String)->Unit
) {
    val viewModel = koinViewModel<HomeViewModel>()
    val product = viewModel.products.collectAsState()
    BoxWithConstraints {
        val scope = this
        val maxWith = scope.maxWidth
        var cols = 2
        var modifier = Modifier.fillMaxWidth()
        if (maxWith > 1240.dp) {
            cols = 3
            modifier = Modifier.widthIn(max = 1240.dp)
        }

        val scrollState = rememberLazyGridState()
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(cols),
                state = scrollState,
                contentPadding =  PaddingValues(16.dp),
            ) {

                items(product.value, key = { product -> product.id .toString() }) { product ->
                    Card(
                        shape = RoundedCornerShape(15.dp),
                        modifier = Modifier.padding(8.dp).fillMaxWidth(),
                        colors = CardDefaults.cardColors(Color.White),
                        elevation = CardDefaults.cardElevation(3.dp)
                    ){
//                        Column(
//                            horizontalAlignment = Alignment.CenterHorizontally,
//                            verticalArrangement = Arrangement.Center
//                        )
//                        {
//                            val painter = rememberImagePainter(url =  product.image?:"")
//                            Image(painter,
//                                modifier = Modifier.height(130.dp).padding(12.dp),
//                                contentDescription =  product.title.toString()
//                            )
//                            Text(
//                                product.title.toString(),
//                                maxLines = 2,
//                                overflow = TextOverflow.Ellipsis,
//                                modifier = Modifier.padding(12.dp).heightIn(min = 30.dp)
//                            )
//                        }
                        Spacer(
                            modifier = Modifier.height(6.dp)
                        )
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ){
                            Text(
                                product.price.toString(),
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier.padding(5.dp).heightIn(min = 10.dp)
                            )
                            IconButton(onClick = {
                                onNavigateToDetail(product.id.toString())
                                println("productDetail/${product.id}")
                            }, modifier = Modifier.align(Alignment.BottomEnd)) {
                                Icon(imageVector = Icons.Default.Info, contentDescription = "detail product ")
                            }
                        }
                    }
                }
            }
        }
    }

}