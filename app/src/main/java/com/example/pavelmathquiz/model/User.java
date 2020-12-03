package com.example.pavelmathquiz.model;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    private String name;
    private String score;
    private ArrayList<Quiz> quizList = new ArrayList<>();

    public User() {
    }

    public User(String name, String score, ArrayList<Quiz> quizList) {
        this.name = name;
        this.score = score;
        this.quizList = quizList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public ArrayList<Quiz> getQuizList() {
        return quizList;
    }

    public void setQuizList(ArrayList<Quiz> quizList) {
        this.quizList = quizList;
    }

    @Override
    public String toString() {
        return "User{" +
        "UserName='" + name + '\'' +
         ", score='" + score + '\'' + ", quizList=" + quizList +
                '}';
    }

}
