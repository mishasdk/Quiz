package com.bulumutka.quiz.model;

public interface QuizManager {
    Boolean checkForCorrectAnswer(Boolean answer);
    TrueFalse getNextQuestion();
    TrueFalse getCurrentQuestion();
}
