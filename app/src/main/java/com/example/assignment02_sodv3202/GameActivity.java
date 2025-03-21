package com.example.assignment02_sodv3202;


import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class GameActivity extends AppCompatActivity{

    TextView question, scoreText;
    Button btnOption1, btnOption2, btnOption3, btnOption4, btnOption5, btnPrevious, btnNext;

    ImageView celebImage;

    int maxLevels;
    int score = 0;
    int questionIndex = 0;

    ArrayList<CelebrityGuess> levels = new ArrayList<>();

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

        //added this to make sure the game starts with 5 and not the saved settings from previous game
        maxLevels = Settings.getMaxLevels(this);

        CelebrityGuess[] totalGuesses = CelebrityGuess.generateTotalGuesses();

       //it will limit the max of the questions available to the user's choice
        maxLevels = Math.min(maxLevels, totalGuesses.length);

        //add the levels chosen by the user
        levels.addAll(Arrays.asList(totalGuesses).subList(0, maxLevels));

        setLevelData(questionIndex);
        updateScore();
    }

    @Override
    protected void onStart(){
        super.onStart();

        setLevelData(questionIndex);
        updateScore();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState){
        super.onSaveInstanceState(outState);

        outState.putInt("SCORE", score);
        outState.putInt("QUESTION", questionIndex);

        //Fixes a "ClassCastException" that is released because of the ArrayList
        outState.putParcelableArray("QUESTION_ARR", levels.toArray(new CelebrityGuess[0]));

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        score = savedInstanceState.getInt("SCORE");
        questionIndex = savedInstanceState.getInt("QUESTION");

        Parcelable[] parcelableArr = savedInstanceState.getParcelableArray("QUESTION_ARR");

        if(parcelableArr != null){
            for(int i = 0; i < levels.size(); i++){
                levels.set(i, (CelebrityGuess) parcelableArr[i]);
            }
        }

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

    public void resetGame(View view) {
        score = 0;
        questionIndex = 0;
        for (CelebrityGuess question : levels) {
            question.answered = false;  // Reset to false
        }
        setLevelData(questionIndex);
        updateScore();
    }

    public void mainMenu(View view){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

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
            }

            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();

            updateScore();
        }
        else {
            Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show();
        }

        question.answered = true;
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
