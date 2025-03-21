package com.example.assignment02_sodv3202;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    GameActivity[] questions = new GameActivity[5];

    Button btnStartGame, btnSettings, btnAbout;

    ImageView celebImage;
    int scoreCount = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnStartGame = findViewById(R.id.btnStartGame);
        btnSettings = findViewById(R.id.btnSettings);
        btnAbout = findViewById(R.id.btnAbout);



    }

    public void startGame(View view){
        Intent intent = new Intent(this, GameActivity.class);

        startActivity(intent);
    }

    public void aboutGame(View view){
        Intent intent =new Intent(this, AboutActivity.class);

        startActivity(intent);
    }

    public void settings(View view){
        Intent intent = new Intent(this, SettingsActivity.class);

        startActivity(intent);
    }


}
