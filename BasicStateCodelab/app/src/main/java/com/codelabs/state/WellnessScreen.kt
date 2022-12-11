package com.codelabs.state

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.codelabs.state.step10.WellnessTasksList
import com.codelabs.state.step10.WellnessViewModel

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    viewModel: WellnessViewModel = viewModel() // hoisting
) {
    /*// Stateful
//    WaterCounter(modifier)

    // Stateless
    StatelessCounter(
//        count = viewModel.waterCount, // วิธีธรรมดา
        count = viewModel.waterCount.collectAsState().value, // encapsulate
        onIncrement = viewModel::addWaterCount
    )*/

    Column(modifier = modifier) {
        StatelessCounter(
            count = viewModel.waterCount.collectAsState().value, // encapsulate
            onIncrement = viewModel::addWaterCount
        )
        WellnessTasksList(
            tasks = viewModel.tasks.collectAsState().value,
            onCheckedChange = viewModel::setTaskChecked,
            onClose = viewModel::removeTask
        )
    }
}
