package com.example.ex9;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class WelcomeInfoFrag extends Fragment {

    private InfoViewModel mViewModel;
    private SharedViewModel sViewModel;


    public StartButtonInterface listener = null;

    public WelcomeInfoFrag(){
        super(R.layout.welcome_info_fragment);
    }

    public static WelcomeInfoFrag newInstance() {
        return new WelcomeInfoFrag();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.welcome_info_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(InfoViewModel.class);
        sViewModel = new ViewModelProvider(this).get(SharedViewModel.class);
        // TODO: Use the ViewModel
        view.findViewById(R.id.start_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (listener!=null){
//                    listener.onButtonClicked();
//                    mViewModel.
//                }
                sViewModel.started.setValue(true);

            }
        });



    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

}