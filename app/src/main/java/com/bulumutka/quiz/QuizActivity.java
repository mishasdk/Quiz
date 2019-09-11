package com.bulumutka.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bulumutka.quiz.model.QuizManager;
import com.bulumutka.quiz.model.QuizManagerImp;

public class QuizActivity extends AppCompatActivity {

    private TextView textView;
    private QuizManager quizManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initActivity();
        onNext(new View(this));
    }

    protected void initActivity() {
        quizManager = new QuizManagerImp();
        textView = findViewById(R.id.questionTextView);
    }

    public void onClickAnswerButton(View view) {
        Button thisButton = (Button) view;
        Boolean answer = thisButton.getId() == R.id.button_true;
        if (quizManager.checkForCorrectAnswer(answer)) {
            CorrectAlert();
        } else {
            IncorrectAlert();
        }
    }

    public void onNext(View view) {
        quizManager.getNextQuestion();
        updateTextView();
    }

    protected void CorrectAlert() {
        Toast.makeText(this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
    }

    protected void IncorrectAlert() {
        Toast.makeText(this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();

    }

    protected void updateTextView() {
        textView.setText(quizManager.getCurrentQuestion().getQuestion());
    }
}
