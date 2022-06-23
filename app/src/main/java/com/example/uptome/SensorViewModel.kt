package com.example.uptome

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class SensorViewModel(private val repo: SensorsRepo) : ViewModel(){

    val allActivity: LiveData<List<Activity>> = repo.allActivity.asLiveData()

    fun insert(activity: Activity) = viewModelScope.launch {
        repo.insert(activity)
    }
}

class SensorViewModelFactory(private val repo: SensorsRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SensorViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SensorViewModel(repo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class!")
    }
}