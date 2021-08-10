package com.example.ex9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainerView;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    SharedViewModel svm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        svm = new ViewModelProvider(this).get(SharedViewModel.class);

        setContentView(R.layout.activity_main);

        FragmentContainerView topFrame = findViewById(R.id.top_frame);
        FragmentContainerView bottomFrame = findViewById(R.id.bottom_frame);

        HeaderFrag headerFrag = new HeaderFrag();
        TermsFrag ageFrag = new TermsFrag();


        getSupportFragmentManager()
                .beginTransaction()
                .replace(topFrame.getId(), headerFrag)
                .replace(bottomFrame.getId(),ageFrag)
                .commit();


//        ageFrag.listener = new StartButtonInterface() {
//            @Override
//            public void onButtonClicked() {
//                headerFrag.setText("started");
//            }
//        };
    }


}