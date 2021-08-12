package com.example.ex9;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
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
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Observable;

public class TermsFrag extends Fragment {

    private TermsViewModel mViewModel;
    private CheckBox termsAccepted;
    private Button continueButton;
    private SharedViewModel sViewModel;


    public static TermsFrag newInstance() {
        return new TermsFrag();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.terms_fragment, container, false);
        view.getBackground().setAlpha(25);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        termsAccepted = (CheckBox) view.findViewById(R.id.checkBox);
        continueButton = (Button) view.findViewById(R.id.continue_button);
        mViewModel = new ViewModelProvider(this).get(TermsViewModel.class);
        sViewModel = new ViewModelProvider(getActivity()).get(SharedViewModel.class);


        termsAccepted.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                if(isChecked){
                    mViewModel.accept.setValue(true);
                }
                else{
                    mViewModel.accept.setValue(false);

                }

            }
        }
        );



        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sViewModel.terms.setValue(true);
                sViewModel.progress.setValue(sViewModel.progress.getValue()+1);

                NavHostFragment navHostFragment =(NavHostFragment) requireActivity().getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
                    NavController navController = navHostFragment.getNavController();
                    navController.navigate(R.id.action_termsFrag_to_mathFrag);
            }
        });

        mViewModel.accept.observe(getViewLifecycleOwner(), new Observer<Boolean>(){

            @Override
            public void onChanged(Boolean aBoolean) {
                if(mViewModel.accept.getValue()){
                    continueButton.setEnabled(true);

                } else{
                    continueButton.setEnabled(false);
                }
            }

        });
    }

}