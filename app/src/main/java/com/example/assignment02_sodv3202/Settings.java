package com.example.assignment02_sodv3202;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatDelegate;

public class Settings {
    private static final String PREFS_NAME = "AppSettings";
    private static final String KEY_MAX_LEVELS = "max_levels";
    private static final String KEY_DARK_THEME = "dark_theme";

    public static final int MAX_LEVELS_LIMIT = 10; // max of questions
    public static final int MIN_LEVELS_LIMIT = 5;
    public static final int DEFAULT_LEVELS_LIMIT = 5;

    /**
    *
    * @return 5 by default, unless the user has changed the settings
    */
    public static int getMaxLevels(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        // Returns 5 by default, unless the user has changed the settings
        return prefs.getInt(KEY_MAX_LEVELS, DEFAULT_LEVELS_LIMIT);
    }

    /**
     * Sets the number of levels to the user-defined value.
     *
     * @param newLevelCount The user's input
     */
    public static void setMaxLevels(Context context, int newLevelCount) {
        // Validation to make sure the min is 5 and max is 10 for the questions
        if (newLevelCount >= MIN_LEVELS_LIMIT && newLevelCount <= MAX_LEVELS_LIMIT) {
            SharedPreferences.Editor editor = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit();
            editor.putInt(KEY_MAX_LEVELS, newLevelCount);
            editor.apply();
        } else {
            //It will show the toast in case the number is invalid
            Toast.makeText(context, "Invalid Entry. The number of questions must be between"
                    + MIN_LEVELS_LIMIT + " and " + MAX_LEVELS_LIMIT, Toast.LENGTH_SHORT).show();
        }
    }

    // Verifies if is in dark mode theme
    public static boolean isDarkTheme(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        return prefs.getBoolean(KEY_DARK_THEME, true); // the standard value will be always light mode
    }

    //
    /**
     * the toggle between light and dark modes
     *
     * @param isDark Sets the dark mode to the input's value (true of false)
     */
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