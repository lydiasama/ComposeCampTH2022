package com.codelabs.state.step10

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class WellnessViewModel : ViewModel() {

    // TODO: step10 waterCount State
    // วิธีธรรมดา
//    var waterCount by mutableStateOf(0)
//        private set

    // วิธี encapsulate
    private val _waterCount = MutableStateFlow(0) // it is MutableState of Coroutine
    val waterCount: StateFlow<Int>
        get() = _waterCount

    fun addWaterCount() {
//        waterCount++
        _waterCount.value++
    }

    // region list

    // TODO: step10 tasks: List<WellnessTask>>
    private val _tasks = MutableStateFlow(getWellnessTasks())
    val tasks: StateFlow<List<WellnessTask>>
        get() = _tasks

    fun removeTask(taskId: TaskId) {
//        val tempTasks = _tasks.value.toMutableList()
//        val index = tempTasks.indexOfFirst { it.id == taskId }
//        tempTasks.removeAt(index)
//        _tasks.value = tempTasks

        _tasks.value = _tasks.value.filter { it.id != taskId }
    }

    fun setTaskChecked(taskId: TaskId, checked: Boolean) {
        _tasks.value = _tasks.value.map {
            if (it.id == taskId) it.copy(checked = checked) else it
        }
    }

    private fun getWellnessTasks() = List(30) { i -> WellnessTask(i.toLong(), "Task # $i", checked = false) }
    // endregion
}

