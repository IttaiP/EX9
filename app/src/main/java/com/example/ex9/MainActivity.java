package com.example.ex9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.SharedPreferences;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {
    String WELCOME_MESSAGE = "Welcome! Push The Button To Get Started";

    SharedViewModel svm;
    FragmentManager supportFragManager;
    ShoeApp app;
    Boolean done;

    HeaderFrag headerFrag;
    WelcomeInfoFrag welcomeFrag;
    DoneFragment doneFragment;


    @Override
    public void onBackPressed(){
        super.onBackPressed();
        if(!done){
            svm.progress.setValue(svm.progress.getValue()-1);
            if(svm.progress.getValue()==0){
                headerFrag.textView.setText(WELCOME_MESSAGE);
            }
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        app = (ShoeApp) getApplicationContext();
        done = app.sp.getBoolean("done", false);

        svm = new ViewModelProvider(this).get(SharedViewModel.class);

        setContentView(R.layout.activity_main);

        FragmentContainerView topFrame = findViewById(R.id.top_frame);
        FragmentContainerView bottomFrame = findViewById(R.id.nav_host_fragment);

        headerFrag = new HeaderFrag();
        welcomeFrag = new WelcomeInfoFrag();
        doneFragment = new DoneFragment();

        if(done){

            svm.done.setValue(true);
            svm.progress.setValue(5);

        }








        supportFragManager = getSupportFragmentManager();
        svm.fragMan.setValue(supportFragManager);


        getSupportFragmentManager()
                .beginTransaction()
                .replace(topFrame.getId(), headerFrag)
//                .replace(bottomFrame.getId(),welcomeFrag)
                .commit();


        svm.done.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean){
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(topFrame.getId(), headerFrag)
                            .replace(bottomFrame.getId(),doneFragment)
                            .commit();
                    headerFrag.textView.setText("DONE");
                }
            }
        });


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
                        SharedPreferences.Editor editor = app.sp.edit();
                        editor.putBoolean("done", true);
                        editor.apply();
                        headerFrag.setText("DONE!");
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(bottomFrame.getId(),doneFragment)
                                .commit();
                }
            }
        });
    }



}