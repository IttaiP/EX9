package com.example.ex9;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    public MutableLiveData<Boolean> started = new MutableLiveData<>(false);
    public MutableLiveData<Boolean> age = new MutableLiveData<>(false);
    public MutableLiveData<Boolean> terms = new MutableLiveData<>(false);
    public MutableLiveData<Boolean> name = new MutableLiveData<>(false);



}
