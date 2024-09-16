package br.edu.satc.todolistcompose.ui.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import br.edu.satc.todolistcompose.ui.data.TaskDatabase
import br.edu.satc.todolistcompose.ui.data.TaskEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class TaskViewModel(application: Application) : AndroidViewModel(application) {
    private val taskDao = TaskDatabase.getDatabase(application).taskDao()
    val tasks: Flow<List<TaskEntity>> = taskDao.getTasks()

    fun insertTask(title: String, description: String) {
        viewModelScope.launch {
            val task = TaskEntity(title = title, description = description, complete = false)
            taskDao.insertTask(task)
        }
    }

    fun updateTask(task: TaskEntity) {
        viewModelScope.launch {
            taskDao.updateTask(task)
        }
    }
}