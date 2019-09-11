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

    private Button trueButton;
    private Button falseButton;
    private Button nextButton;

    private TextView textView;
    private QuizManager quizManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initActivity();
        OnNext();
    }

    protected void initActivity() {
        quizManager = new QuizManagerImp();
        textView = findViewById(R.id.questionTextView);
        trueButton = findViewById(R.id.button1);
        falseButton = findViewById(R.id.button2);
        nextButton = findViewById(R.id.nextButton);

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizManager.checkForCorrectAnswer(true)) {
                    CorrectAlert();
                } else {
                    IncorrectAlert();
                }
            }
        });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizManager.checkForCorrectAnswer(false)) {
                    CorrectAlert();
                } else {
                    IncorrectAlert();
                }
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnNext();
            }
        });
    }

    protected void CorrectAlert() {
        Toast.makeText(this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
    }

    protected void IncorrectAlert() {
        Toast.makeText(this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();

    }

    protected void OnNext() {
        quizManager.getNextQuestion();
        updateView();
    }

    protected void updateView() {
        textView.setText(quizManager.getCurrentQuestion().getQuestion());
    }
}
