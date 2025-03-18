package com.example.assignment02_sodv3202;

public class Settings {

    public static int MAX_LEVELS = 5;

    public static boolean DARK_THEME = true;


    public static void setMaxLevels(int newMax){
        if(newMax > 0 && newMax <= 10){
            MAX_LEVELS = newMax;
        }
    }

    public static void toggleTheme(boolean input){
        DARK_THEME = input;
    }
}
