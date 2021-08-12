package com.example.ex9;


import android.util.Log;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.lifecycle.ViewModelProvider;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = 28)
public class moreTests extends TestCase {
    private ActivityController<MainActivity> activityController;

    @Before
    public void setup() {
        activityController = Robolectric.buildActivity(MainActivity.class);
    }

    @Test
    public void when_generate_random_in_range() {
        // setup


        MainActivity activityUnderTest = activityController.create().visible().get();
        MathViewModel mvm = new ViewModelProvider(activityUnderTest).get(MathViewModel.class);

        for(int i=0;i<100; i++){
            MathQuestion mq = mvm.generateRandomQuestion();
            int num1 = mq.getNum1();
            int num2 = mq.getNum2();

            // verify
            assertTrue((num1>=0 && num1<10)&& (num2>=0 && num2<10));
        }

    }


    @Test
    public void when_generate_random_answer_correct() {
        // setup


        MainActivity activityUnderTest = activityController.create().visible().get();
        MathViewModel mvm = new ViewModelProvider(activityUnderTest).get(MathViewModel.class);

        for(int i=0;i<100; i++) {
            MathQuestion mq = mvm.generateRandomQuestion();
            int num1 = mq.getNum1();
            int num2 = mq.getNum2();
            assertEquals(num1 + num2, mq.getAnswer());

        }

    }

    @Test
    public void when_short_name_not_valid() {
        // setup


        MainActivity activityUnderTest = activityController.create().visible().get();
        NameViewModel mvm = new ViewModelProvider(activityUnderTest).get(NameViewModel.class);

        String shortName = "ad";

        mvm.firstName.setValue(shortName);
        mvm.lastName.setValue(shortName);

        assertFalse(mvm.CheckNameIsLegal());


    }

    @Test
    public void when_number_name_not_valid() {
        // setup


        MainActivity activityUnderTest = activityController.create().visible().get();
        NameViewModel mvm = new ViewModelProvider(activityUnderTest).get(NameViewModel.class);

        String numName = "aasd4b";

        mvm.firstName.setValue(numName);
        mvm.lastName.setValue(numName);

        assertFalse(mvm.CheckNameIsLegal());
    }

    @Test
    public void when_symbol_name_not_valid() {
        // setup


        MainActivity activityUnderTest = activityController.create().visible().get();
        NameViewModel mvm = new ViewModelProvider(activityUnderTest).get(NameViewModel.class);

        String symbolName = "asdf'b";
        mvm.firstName.setValue(symbolName);
        mvm.lastName.setValue(symbolName);

        assertFalse(mvm.CheckNameIsLegal());

    }

}