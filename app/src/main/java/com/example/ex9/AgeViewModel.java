package com.example.ex9;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AgeViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    public MutableLiveData<Integer> age = new MutableLiveData<>(17);
}