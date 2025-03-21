package com.example.assignment02_sodv3202;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatDelegate;

public class Settings {
    private static final String PREFS_NAME = "AppSettings";
    private static final String KEY_MAX_LEVELS = "max_levels";
    private static final String KEY_DARK_THEME = "dark_theme";

    private static final int MAX_LEVELS_LIMIT = 10; // max of questions

    // Recover the number of questions level



    public static int getMaxLevels(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        // Retorna 5 por padrão, a menos que o usuário tenha alterado nas configurações
        return prefs.getInt(KEY_MAX_LEVELS, 5);
    }

    // Define the number of questions level
    public static void setMaxLevels(Context context, int newMax) {
        // Validation to make sure the min is 5 and max is 10 for the questions
        if (newMax >= 5 && newMax <= MAX_LEVELS_LIMIT) {
            SharedPreferences.Editor editor = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit();
            editor.putInt(KEY_MAX_LEVELS, newMax);
            editor.apply();
        } else {
            //It will show the toast in case the number is invalid
            Toast.makeText(context, "Invalid Entry. The number of questions must be between 5 and " + MAX_LEVELS_LIMIT, Toast.LENGTH_SHORT).show();
        }
    }

    // Verifies if is in dark mode theme
    public static boolean isDarkTheme(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        return prefs.getBoolean(KEY_DARK_THEME, false); // the standard value will be always light mode
    }

    // the toogle between light and dark modes
    public static void toggleTheme(Context context, boolean isDark) {
        SharedPreferences.Editor editor = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit();
        editor.putBoolean(KEY_DARK_THEME, isDark);
        editor.apply();

        if (isDark) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }
}



   /* public static void setMaxLevels(int newMax) {
        if (newMax > 0 && newMax <= 10) {
            MAX_LEVELS = newMax;
        }
    }

    public static void toggleTheme(boolean input) {
        if (input) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
           AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            //DARK_THEME = input;
        }
    }
}
*/