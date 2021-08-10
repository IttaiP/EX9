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
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;

public class TermsFrag extends Fragment {

    private TermsViewModel mViewModel;
    private CheckBox termsAccepted;
    private Button continueButton;

    public static TermsFrag newInstance() {
        return new TermsFrag();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.terms_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        termsAccepted = (CheckBox) view.findViewById(R.id.checkBox);
        continueButton = (Button) view.findViewById(R.id.continue_button);
        mViewModel = new ViewModelProvider(this).get(TermsViewModel.class);
//        mViewModel.accept.observe(getViewLifecycleOwner(), new Observer<Integer>() {
//            @Override
//            public void onChanged(Integer integer) {
//                // TODO
//                // might be redundent
//            }
//        });

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // TODO: Use the ViewModel
    }

}