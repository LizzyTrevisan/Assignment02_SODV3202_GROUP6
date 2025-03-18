package com.example.assignment02_sodv3202;


import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity{

    public String questionAsk;
    TextView question, score;
    Button btnOption1, btnOption2, btnOption3, btnOption4, btnOption5, btnPrevious, btnNext;

    public String option1, option2, option3, option4, option5;


    public int celebrityImage;

    public String correctAnswer;
    ImageView celebImage;
    int scoreCount = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Button btnOption1 = findViewById(R.id.btnOption1);
        Button btnOption2 = findViewById(R.id.btnOption2);
        Button btnOption3 = findViewById(R.id.btnOption3);
        Button btnOption4 = findViewById(R.id.btnOption4);
        Button btnOption5 = findViewById(R.id.btnOption5);
        TextView question = findViewById(R.id.question);
        TextView score = findViewById(R.id.score);
        ImageView celebImage = findViewById(R.id.celebImage);


    }


    public GameActivity(String questionAsk, String op1, String op2, String op3, String opt4, String op5, int celebrityPic, String correct)
        {
            this.questionAsk = questionAsk;
            this.option1 = op1;
            this.option2 = op2;
            this.option3 = op3;
            this.option4 = opt4;
            this.option5 = op5;
            this.celebrityImage = celebrityPic;
            this.correctAnswer = correct;

        }



}
