package com.bulumutka.quiz.model;


public interface QuizManager {
    Boolean checkForCorrectAnswer(Boolean answer);

    void NextQuestion();

    TrueFalse getCurrentQuestion();
}
