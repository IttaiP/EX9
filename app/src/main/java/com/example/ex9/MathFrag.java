package com.example.ex9;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MathFrag extends Fragment {

    private MathViewModel mViewModel;
    private TextView question;
    private EditText answer;
    private Button continueButton;
    MathQuestion mathQuestion;


    public static MathFrag newInstance() {
        return new MathFrag();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.math_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        question = (TextView) view.findViewById(R.id.question);
        answer = (EditText) view.findViewById(R.id.answer);
        continueButton = (Button) view.findViewById(R.id.continue_button);
        mViewModel = new ViewModelProvider(this).get(MathViewModel.class);

        // todo: generate random questions and their answers
        newQuestion();



        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(answer.getText().toString())==(mathQuestion.getAnswer())){
                    NavHostFragment navHostFragment =(NavHostFragment) requireActivity().getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
                    NavController navController = navHostFragment.getNavController();
                    navController.navigate(R.id.action_mathFrag_to_nameFrag);
                }
                else{
                    answer.setText("");
                    answer.setHint("WRONG!");
                    newQuestion();
                }
            }
        });

//        mViewModel.accept.observe(getViewLifecycleOwner(), new Observer<Integer>() {
//            @Override
//            public void onChanged(Integer integer) {
//                // TODO
//                // might be redundent
//            }
//        });

    }

    private void newQuestion(){
        mathQuestion = mViewModel.generateRandomQuestion();
        question.setText(Integer.toString(mathQuestion.getNum1())+"+"
                +Integer.toString(mathQuestion.getNum2()) + "=?");
    }


}