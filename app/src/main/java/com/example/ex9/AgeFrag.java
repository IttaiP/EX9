package com.example.ex9;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class AgeFrag extends Fragment {

    private AgeViewModel mViewModel;
    private SeekBar seekBar;
    private TextView ageNum;
    private int age;

    public AgeFrag(){
        super(R.layout.age_fragment);
    }

    public static AgeFrag newInstance() {
        return new AgeFrag();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.age_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        seekBar = (SeekBar) view.findViewById(R.id.seek_bar);
        ageNum = (TextView) view.findViewById(R.id.age_num);
        ageNum.setText("17");
        mViewModel = new ViewModelProvider(this).get(AgeViewModel.class);
        mViewModel.age.observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                // TODO
                seekBar.setProgress(integer); // might be redundent
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
    }

}