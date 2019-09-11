package com.bulumutka.quiz.model;

import com.bulumutka.quiz.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class QuizManagerImp implements QuizManager, Serializable {
    private final TrueFalse[] questionsBank = new TrueFalse[]{
            new TrueFalse(R.string.question_oceans, true),
            new TrueFalse(R.string.question_mideast, false),
            new TrueFalse(R.string.question_africa, false),
            new TrueFalse(R.string.question_americas, true),
            new TrueFalse(R.string.question_asia, true)
    };
    private ArrayList<Integer> questionsSequence;
    private TrueFalse currentQuestion;
    private Integer currentIndex;

    public QuizManagerImp() {
        initQuestionsSequence();
    }

    @Override
    public Boolean checkForCorrectAnswer(Boolean answer) {
        return answer == currentQuestion.getCorrectAnswer();
    }

    @Override
    public TrueFalse getNextQuestion() {
        int size = questionsBank.length;
        if (currentIndex == size)
            initQuestionsSequence();
        else {
            int index = questionsSequence.get(currentIndex++);
            currentQuestion = questionsBank[index];
        }
        return currentQuestion;
    }

    @Override
    public TrueFalse getCurrentQuestion() {
        return currentQuestion;
    }

    private void initQuestionsSequence() {
        int size = questionsBank.length;
        questionsSequence = new ArrayList<>();
        for (int i = 0; i < size; ++i)
            questionsSequence.add(i);
        Collections.shuffle(questionsSequence, new Random());
        currentIndex = 0;
        currentQuestion = questionsBank[questionsSequence.get(currentIndex)];
    }
}
