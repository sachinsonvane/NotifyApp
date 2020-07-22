package com.sns.notifyapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sns.notifyapp.repository.DataRepository
import javax.inject.Inject

class NotifyListViewModel @Inject constructor(private val repository: DataRepository) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is NotifyList Fragment"
    }
    val text: LiveData<String> = _text



}