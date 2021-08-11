package com.example.ex9;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NameViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    public MutableLiveData<String> firstName = new MutableLiveData<>("");
    public MutableLiveData<String> lastName = new MutableLiveData<>("");



    public boolean CheckNameIsLegal(){
        // todo: implement
        return checkName(firstName.getValue().toString()) && checkName(lastName.getValue().toString());
    }

    private boolean checkName(String name){
        return name.matches("[A-Za-z]+") && (name.length()>2);
    }

}