package com.example.ex9;

import android.app.Application;
import android.content.SharedPreferences;

public class ShoeApp extends Application {
    SharedPreferences sp;

    @Override
    public void onCreate() {
        super.onCreate();
        sp = getSharedPreferences("shoe_app",MODE_PRIVATE);

    }
}
