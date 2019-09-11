package com.bulumutka.quiz.model;

import java.io.Serializable;

public class TrueFalse implements Serializable {
    private int question;
    private boolean correctAnswer;

    public TrueFalse(int question, boolean correctAnswer) {
        setQuestion(question);
        setCorrectAnswer(correctAnswer);
    }

    public boolean getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(boolean correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public int getQuestion() {
        return question;
    }

    public void setQuestion(int question) {
        this.question = question;
    }
}
