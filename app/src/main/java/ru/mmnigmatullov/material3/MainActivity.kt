package ru.mmnigmatullov.material3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.mmnigmatullov.material3.ui.theme.Material3Theme


@Suppress("DEPRECATION")
@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Material3Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    Scaffold(
                        floatingActionButton = {
                            FloatingActionButton(onClick = { }) {
                                Icon(imageVector = Icons.Default.Add,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.onPrimaryContainer
                                    )
                            }
                        },
                        topBar = {
                            SmallTopAppBar(
                                title = {
                                    Text(text = "Material 3")
                                },
                                colors = TopAppBarDefaults.smallTopAppBarColors(
                                    containerColor = MaterialTheme.colorScheme.surfaceVariant,
                                    titleContentColor = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            )
                        }
                    ) { values ->
                        LazyColumn(contentPadding = values){
                            items(20) {
                                ImageCard(
                                    title = "Bacon ipsum",
                                    description = "Bacon ipsum dolor amet biltong salami pork belly andouille, buffalo pork swine pastrami short ribs shankle turkey corned beef. Strip steak shank shoulder kielbasa ball tip. Bacon meatloaf pork loin tenderloin venison kevin drumstick swine tri-tip chuck. Tri-tip meatball flank chislic pork belly, prosciutto jerky doner porchetta filet mignon tail meatloaf. Shank pig tail bacon pork chop chicken, short ribs pork belly ground round pastrami hamburger. Swine cow strip steak flank turducken, jerky ham hock chislic short loin rump tenderloin bresaola pancetta pork. Meatloaf fatback chuck buffalo beef ribs bacon, beef bresaola short ribs andouille short loin spare ribs ham.",
                                    modifier = Modifier.padding(16.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
