package com.example.assignment02_sodv3202;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        // Define o texto sobre o app
        TextView aboutText = findViewById(R.id.aboutText);
        aboutText.setText("Celebrity Game App\n\n" +
                "A fun and interactive game, in which players guess celebrities based on the pictures displayed.\n\n"  +
                "Created by: Sameel Haider & Leiziane Trevisan Dardin\n" +
                "Version: 1.0\n" +
                "Release Date: April 5, 2025");

        // it will allow to go back to main menu
        Button backToMenuBtn = findViewById(R.id.backToMenuBtn);
        backToMenuBtn.setOnClickListener(view -> {
            Intent intent = new Intent(AboutActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // close all the activities
            startActivity(intent);
            finish(); // close about page
        });
    }
}
