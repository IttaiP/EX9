package com.example.ex9;

import androidx.lifecycle.ViewModel;

import java.util.Random;

public class MathViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    int number1;
    int number2;
    MathQuestion question;
    boolean answered = false;
    Random rand = new Random();

    private int generateRandomNum(){
        return rand.nextInt(10);
    }

    public MathQuestion generateRandomQuestion(){
        number1 = generateRandomNum();
        number2 = generateRandomNum();
        question = new MathQuestion(number1, number2);
        return question;
    }

    public void Continued(){
        answered = true;
    }


}