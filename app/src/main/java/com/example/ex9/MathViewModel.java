package com.example.ex9;

import androidx.lifecycle.ViewModel;

import java.util.Random;

public class MathViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    int number1;
    int number2;
    Random rand = new Random();

    private int generateRandomNum(){
        return rand.nextInt(10);
    }

    public MathQuestion generateRandomQuestion(){
        return new MathQuestion(generateRandomNum(), generateRandomNum());
    }


}