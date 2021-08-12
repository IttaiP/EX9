package com.example.ex9;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class ShoeApp extends Application {
    SharedPreferences sp;

    public ShoeApp getInstance(){
        return this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sp = PreferenceManager.getDefaultSharedPreferences(this);
        // use to clear shared prefferences
//         sp.edit().clear().commit();


    }
}
