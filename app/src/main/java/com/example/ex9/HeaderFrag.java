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
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class HeaderFrag extends Fragment {

    private SharedViewModel svm;
    ProgressBar progressBar;
    TextView textView;

    public HeaderFrag(){
        super(R.layout.header_fragment);
    }


    public static HeaderFrag newInstance() {
        return new HeaderFrag();
    }


    public void setText(String text){
        View view = getView();
        if(view!=null){
            textView.setText(text);
        }
    };

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.header_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        svm = new ViewModelProvider(getActivity()).get(SharedViewModel.class);
        textView = view.findViewById(R.id.head_text);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
//        sViewModel.progress.observe(getViewLifecycleOwner(), new Observer<Integer>() {
//            @Override
//            public void onChanged(Integer integer) {
//                progressBar.setProgress(integer);
//            }
//        });

        svm.done.observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean){
                    textView.setText("DONE");
                }
            }
        });


    }


}