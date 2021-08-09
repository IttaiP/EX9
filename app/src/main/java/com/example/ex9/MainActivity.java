package com.example.ex9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentContainerView topFrame = findViewById(R.id.top_frame);
        FragmentContainerView bottomFrame = findViewById(R.id.bottom_frame);

        HeaderFrag headerFrag = new HeaderFrag();
        InfoFrag infoFrag = new InfoFrag();


        getSupportFragmentManager()
                .beginTransaction()
                .replace(topFrame.getId(), headerFrag)
                .replace(bottomFrame.getId(),infoFrag)
                .commit();
    }
}