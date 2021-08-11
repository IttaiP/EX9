package com.example.ex9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    SharedViewModel svm;
    FragmentManager supportFragManager;
    ShoeApp app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        app = (ShoeApp) getApplication();
        svm = new ViewModelProvider(this).get(SharedViewModel.class);

        setContentView(R.layout.activity_main);

        FragmentContainerView topFrame = findViewById(R.id.top_frame);
        FragmentContainerView bottomFrame = findViewById(R.id.nav_host_fragment);

        HeaderFrag headerFrag = new HeaderFrag();
        WelcomeInfoFrag welcomeFrag = new WelcomeInfoFrag();

        supportFragManager = getSupportFragmentManager();
        svm.fragMan.setValue(supportFragManager);


        getSupportFragmentManager()
                .beginTransaction()
                .replace(topFrame.getId(), headerFrag)
//                .replace(bottomFrame.getId(),welcomeFrag)
                .commit();


//        ageFrag.listener = new StartButtonInterface() {
//            @Override
//            public void onButtonClicked() {
//                headerFrag.setText("started");
//            }
//        };

        svm.progress.observe(this, new Observer<Integer>() {

            @Override
            public void onChanged(Integer integer) {
                headerFrag.progressBar.setProgress(integer);
                switch (integer){
                    case 0:
                        return;
                    case 1:
                        headerFrag.setText("1/5 stages");
                        return;
                    case 2:
                        headerFrag.setText("2/5 stages");
                        return;
                    case 3:
                        headerFrag.setText("3/5 stages");
                        return;
                    case 4:
                        headerFrag.setText("4/5 stages");
                        return;
                    case 5:
                        svm.done.setValue(true);
                        app.sp.
                        headerFrag.setText("DONE!");
                }
            }
        });
    }



}