package com.bulumutka.quiz.model;

import java.io.Serializable;

public final class TrueFalse implements Serializable {
    public final int question;
    public final boolean correctAnswer;

    public TrueFalse(int question, boolean correctAnswer) {
        this.question = question;
        this.correctAnswer = correctAnswer;
    }
}
