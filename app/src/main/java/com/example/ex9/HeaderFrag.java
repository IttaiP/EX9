package com.example.ex9;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HeaderFrag extends Fragment {

    private HeaderViewModel mViewModel;

    public HeaderFrag(){
        super(R.layout.header_fragment);
    }

    public static HeaderFrag newInstance() {
        return new HeaderFrag();
    }


    public void setText(String text){
        View view = getView();
        if(view!=null){
            TextView textView = view.findViewById(R.id.head_text);
            textView.setText(text);
        }
    };

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.header_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(HeaderViewModel.class);
        // TODO: Use the ViewModel
    }

}