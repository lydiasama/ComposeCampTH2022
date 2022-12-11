package com.codelabs.state

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    // This is Stateful because it remember the state inside of the function
    Column {
//    var count by remember { mutableStateOf(0) }
        var count by rememberSaveable { mutableStateOf(0) } // Save state when rotate
        StatelessCounter(
            modifier = modifier,
            count = count,
            onIncrement = { count++ }
        )

        var juice by rememberSaveable { mutableStateOf(0) } // Save state when rotate
        StatelessCounter(
            modifier = modifier,
            count = juice,
            onIncrement = { juice++ }
        )
    }
}

@Composable
fun StatelessCounter(
    count: Int, // state
    onIncrement: () -> Unit, // event
    modifier: Modifier = Modifier
) {
    // This is Stateless
    Column(
        modifier = modifier.padding(16.dp)
    ) {
        AnimatedVisibility(visible = count > 0) {
            Text(text = "You've had $count glasses.")
        }
        Button(
            onClick = onIncrement,
            enabled = count < 10
        ) {
            Text(text = "Add one")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StatelessWaterCounterPreview_0() {
    StatelessCounter(count = 0, onIncrement = { /*TODO*/ })
}

@Preview(showBackground = true)
@Composable
fun StatelessWaterCounterPreview_1() {
    StatelessCounter(count = 1, onIncrement = { /*TODO*/ })
}

@Preview(showBackground = true)
@Composable
fun StatelessWaterCounterPreview_10() {
    StatelessCounter(count = 10, onIncrement = { /*TODO*/ })
}
