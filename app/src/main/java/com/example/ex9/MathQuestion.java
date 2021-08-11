package com.example.ex9;

public class MathQuestion {
    private int num1;
    private int num2;
    private int answer;

    public MathQuestion(int n1,int n2){
        num1 = n1;
        num2 = n2;
        answer = n1+n2;
    }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }

    public int getAnswer() {
        return answer;
    }
}
