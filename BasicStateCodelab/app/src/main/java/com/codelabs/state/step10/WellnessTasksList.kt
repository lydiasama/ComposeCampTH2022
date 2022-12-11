package com.codelabs.state.step10

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

// TODO: step10
@Composable
fun WellnessTasksList(
    tasks: List<WellnessTask>,
    onCheckedChange: (TaskId, Boolean) -> Unit,
    onClose: (TaskId) -> Unit
) {
    LazyColumn {
        items(tasks) { task ->
            WellnessTaskItem(
                taskName = task.label,
                checked = task.checked,
                onCheckedChange = { checked -> onCheckedChange(task.id, checked) },
                onClose = { onClose(task.id) })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WellnessTasksListPreview() {
    WellnessTasksList(tasks = listOf(
        WellnessTask(id = 1, label = "1", checked = false),
        WellnessTask(id = 1, label = "2", checked = true)
    ), onCheckedChange = { _, _ -> }, onClose = {})

}
