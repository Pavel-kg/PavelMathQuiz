package com.example.pavelmathquiz.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import androidx.annotation.NonNull;

public class Quiz implements Serializable, Comparable{
    private int num1;
    private int num2;

    private String operator;
    private double calculation;
    private int score;
    private double user_answer;
    private String whatAnswer;
    private static DecimalFormat df = new DecimalFormat("0.00");

    public Quiz() {
    }

    public Quiz(int num1, int num2, String operator, double calculation, int score, double user_answer, String whatAnswer) {
        this.num1 = num1;
        this.num2 = num2;
        this.operator = operator;
        this.calculation = calculation;
        this.score = score;
        this.user_answer = user_answer;
        this.whatAnswer = whatAnswer;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public double getCalculation() {
        return calculation;
    }

    public void setCalculation(double calculation) {
        this.calculation = calculation;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score)
    {
        this.score = score;
    }

    public double getUser_answer()
    {
        return user_answer;
    }

    public void setUser_answer(double user_answer)
    {
        this.user_answer = user_answer;
    }

    public String getWhatAnswer() {
        return whatAnswer;
    }

    public void setWhatAnswer(String whatAnswer) {
        this.whatAnswer = whatAnswer;
    }

    @Override
    public String toString() {
        return whatAnswer + " User Answer:" + user_answer + " Quiz: " + num1 + operator + num2 +
               "=" + df.format(calculation);
    }


    @Override
    public int compareTo(@NonNull Object o) {
        Quiz otherObject = (Quiz) o;
        return whatAnswer.compareTo(otherObject.getWhatAnswer());
    }
}
