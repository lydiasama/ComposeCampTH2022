package com.codelabs.state.step10

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun WellnessTaskItem(
    taskName: String,
    checked: Boolean, // Stateless เพราะไม่ได้จำ state ข้างใน แต่รับมา
    onCheckedChange: (Boolean) -> Unit,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier, verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp),
            text = taskName
        )
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
        IconButton(onClick = onClose) {
            Icon(Icons.Filled.Close, contentDescription = "Close")
        }
    }
}

@Preview
@Composable
fun Preview_WellnessTaskItem_UnChecked() {
    WellnessTaskItem(
        taskName = "Task1",
        checked = false,
        onCheckedChange = {},
        onClose = {},
    )
}

@Preview
@Composable
fun Preview_WellnessTaskItem_Checked() {
    WellnessTaskItem(
        taskName = "Task1",
        checked = true,
        onCheckedChange = {},
        onClose = {},
    )
}
