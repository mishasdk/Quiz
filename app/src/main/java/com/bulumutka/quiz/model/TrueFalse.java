package com.bulumutka.quiz.model;

import java.io.Serializable;

public class TrueFalse implements Serializable {
    private int question;
    private boolean correctAnswer;

    public TrueFalse(int question, boolean correctAnswer) {
        this.question = question;
        this.correctAnswer = correctAnswer;
    }

    public boolean getCorrectAnswer() {
        return correctAnswer;
    }

    public int getQuestion() {
        return question;
    }
}
