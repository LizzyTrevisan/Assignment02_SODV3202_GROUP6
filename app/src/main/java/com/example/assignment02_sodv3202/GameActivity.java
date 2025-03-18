package com.example.assignment02_sodv3202;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameActivity extends AppCompatActivity{

    TextView question, scoreText;
    Button btnOption1, btnOption2, btnOption3, btnOption4, btnOption5, btnPrevious, btnNext;

    ImageView celebImage;


    int score = 0;
    int questionIndex = 0;

    List<CelebrityGuess> levels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_game);

        btnOption1 = findViewById(R.id.btnOption1);
        btnOption2 = findViewById(R.id.btnOption2);
        btnOption3 = findViewById(R.id.btnOption3);
        btnOption4 = findViewById(R.id.btnOption4);
        btnOption5 = findViewById(R.id.btnOption5);
        question = findViewById(R.id.question);
        scoreText = findViewById(R.id.score);
        celebImage = findViewById(R.id.celebImage);

        CelebrityGuess[] totalGuesses = CelebrityGuess.generateTotalGuesses();

        //Basically, this adds all the levels, BUT, only up till the user specified max.
        levels.addAll(Arrays.asList(totalGuesses).subList(0, Settings.MAX_LEVELS));
    }

    @Override
    protected void onStart(){
        super.onStart();

        setLevelData(questionIndex);
        updateScore();
    }

    //BUTTON HOOKS
    public void nextQuestion(View view){
        if(questionIndex == levels.size() - 1){
            Toast.makeText(this, "You're at the final question.", Toast.LENGTH_SHORT).show();

            return;
        }

        questionIndex++;

        setLevelData(questionIndex);
    }

    public void previousQuestion(View view){
        if(questionIndex == 0){
            Toast.makeText(this, "You're at the first question.", Toast.LENGTH_SHORT).show();

            return;
        }

        questionIndex--;

        setLevelData(questionIndex);
    }

    public void answer(View view){

        //Juuust in case
        if(!(view instanceof Button)) return;

        Button btn = (Button) view;

        //Both of the variables below are to save on syntax writing.
        CelebrityGuess question = levels.get(questionIndex);

        boolean correct = question.verifyAnswer(btn.getText().toString());

        if(correct){

            if(!question.answered){
                score++;
                question.answered = true;
            }

            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();

            updateScore();
        }
        else {
            Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show();
        }

    }

    //END OF BUTTON HOOKS

    public void updateScore(){
        scoreText.setText(Integer.toString(score));
    }

    public void setLevelData(int index){

        //Doesn't do index checking before .get call
        //Make sure to perform that regularly.

        CelebrityGuess data = levels.get(index);

        celebImage.setImageResource(data.imageResourceID);

        btnOption1.setText(data.options[0]);
        btnOption2.setText(data.options[1]);
        btnOption3.setText(data.options[2]);
        btnOption4.setText(data.options[3]);
        btnOption5.setText(data.options[4]);
    }



}
