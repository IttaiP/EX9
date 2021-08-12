package com.example.ex9;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Trace;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class AgeFrag extends Fragment{

    private AgeViewModel mViewModel;
    private SeekBar seekBar;
    private TextView ageNum;
    private Button continueButton;
    private int age;
    private SharedViewModel sViewModel;


    public AgeFrag(){
        super(R.layout.age_fragment);
    }

    public static AgeFrag newInstance() {
        return new AgeFrag();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.age_fragment, container, false);
        view.getBackground().setAlpha(25);
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        continueButton = (Button) view.findViewById(R.id.continueButton);
        seekBar = (SeekBar) view.findViewById(R.id.seek_bar);
        ageNum = (TextView) view.findViewById(R.id.age_num);
        ageNum.setText("17");
        mViewModel = new ViewModelProvider(this).get(AgeViewModel.class);
        sViewModel = new ViewModelProvider(getActivity()).get(SharedViewModel.class);

        mViewModel.age.observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                // TODO
                seekBar.setProgress(integer); // might be redundent
                if(integer>=18){
                    continueButton.setEnabled(true);
                }
                else{
                    continueButton.setEnabled(false);

                }
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                age = progress;
                mViewModel.age.setValue(progress);
                ageNum.setText(Integer.toString(progress));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                ageNum.setText(Integer.toString(seekBar.getProgress()));
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                ageNum.setText(Integer.toString(seekBar.getProgress()));
            }
        });
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sViewModel.age.setValue(true);
                sViewModel.progress.setValue(sViewModel.progress.getValue()+1);
                NavHostFragment navHostFragment =(NavHostFragment) requireActivity().getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
                    NavController navController = navHostFragment.getNavController();
                    navController.navigate(R.id.action_ageFrag_to_termsFrag);
            }
        });
    }



}