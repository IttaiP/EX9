package com.example.ex9;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NameViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    public MutableLiveData<String> firstName = new MutableLiveData<>("");
    public MutableLiveData<String> lastName = new MutableLiveData<>("");


}