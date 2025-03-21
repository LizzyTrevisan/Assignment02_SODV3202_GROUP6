package com.example.assignment02_sodv3202;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class SettingsActivity extends AppCompatActivity {

    private EditText editMaxQuestions;
    private Switch switchDarkTheme;
    private Button btnSaveSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        editMaxQuestions = findViewById(R.id.etMaxLevels);
        switchDarkTheme = findViewById(R.id.settings_switchTheme);
        btnSaveSettings = findViewById(R.id.settings_btn_SaveSettings);

        // Load the settings saved in SharedPreferences
        int currentMaxLevels = Settings.getMaxLevels(this);
        editMaxQuestions.setText(String.valueOf(currentMaxLevels));

        boolean isDarkMode = Settings.isDarkTheme(this);
        switchDarkTheme.setChecked(isDarkMode);

        // it will save the settings defined by the user
        btnSaveSettings.setOnClickListener(this::saveSettings);
    }

    public void resetSettings(View view) {
        Settings.setMaxLevels(this, 5);

        Settings.toggleTheme(this, false);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        editMaxQuestions.setText("5");

        switchDarkTheme.setChecked(false);

        Toast.makeText(this, "Settings were reset successfully", Toast.LENGTH_SHORT).show();

    }

    private void saveSettings(View view){
        // saves the level(max of questions)
        String maxQuestionsStr = editMaxQuestions.getText().toString();

        if (!maxQuestionsStr.isEmpty()) {
            int maxQuestions = Integer.parseInt(maxQuestionsStr);

            // at least 5 and maximum 10 questions as per requirements
            if (maxQuestions >= 5 && maxQuestions <= 10) {
                Settings.setMaxLevels(SettingsActivity.this, maxQuestions);
            } else {
                //it will show a toast if the number is invalid
                Toast.makeText(SettingsActivity.this, "Number of questions is invalid. Choose between 5 and 10.", Toast.LENGTH_SHORT).show();
                return; // it will not allow to save if the number of questions is not valid
            }
        }

        // Dark mode to be applied
        boolean isDark = switchDarkTheme.isChecked();
        Settings.toggleTheme(SettingsActivity.this, isDark);

        // It will display a toast when the settings are saved
        Toast.makeText(SettingsActivity.this, "Settings were saved successfully", Toast.LENGTH_SHORT).show();

        // It will ope the previous screen or close the settings screen
        finish(); // closes the current screen
    }


}