package com.example.ex9;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    public MutableLiveData<Boolean> started = new MutableLiveData<>(false);
    public MutableLiveData<Boolean> age = new MutableLiveData<>(false);
    public MutableLiveData<Boolean> terms = new MutableLiveData<>(false);
    public MutableLiveData<Boolean> name = new MutableLiveData<>(false);
    public MutableLiveData<FragmentManager> fragMan = new MutableLiveData<>(null);

    public MutableLiveData<Integer> progress = new MutableLiveData<>(0);

    public MutableLiveData<Boolean> done = new MutableLiveData<>(false);







}
