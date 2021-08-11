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

public class NameFrag extends Fragment {

    private NameViewModel mViewModel;
    private EditText firstName;
    private EditText lastName;
    private Button finishButton;


    public static NameFrag newInstance() {
        return new NameFrag();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.name_fragment, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        firstName = (EditText) view.findViewById(R.id.first_name);
        lastName = (EditText) view.findViewById(R.id.last_name);
        finishButton = (Button) view.findViewById(R.id.finish);

        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(CheckNameIsLegal(firstName.getText().toString())){
                    // todo: go to after screen
                }
                else{
                    // todo: illegal name
                }
            }
        });

        mViewModel = new ViewModelProvider(this).get(NameViewModel.class);
//        mViewModel.accept.observe(getViewLifecycleOwner(), new Observer<Integer>() {
//            @Override
//            public void onChanged(Integer integer) {
//                // TODO
//                // might be redundent
//            }
//        });

    }

    private boolean CheckNameIsLegal(String name){
        // todo: implement
        return true;
    }


}