package com.example.ex9;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

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
        sViewModel = new ViewModelProvider(getActivity()).get(SharedViewModel.class);

//        NavHostFragment navHostFragment = (NavHostFragment) requireActivity().getSupportFragmentManager()
//                .findFragmentById(R.id.nav_host_fragment);
//        NavController navCo = navHostFragment.getNavController();



        // TODO: Use the ViewModel
        view.findViewById(R.id.start_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (listener!=null){
//                    listener.onButtonClicked();
//                    mViewModel.
//                }
                sViewModel.started.setValue(true);
                sViewModel.progress.setValue(sViewModel.progress.getValue()+1);
                NavHostFragment navHostFragment =(NavHostFragment) requireActivity().getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
                NavController navController = navHostFragment.getNavController();
                navController.navigate(R.id.action_welcomeInfoFrag_to_ageFrag);
//                Navigation.createNavigateOnClickListener(R.id.ageFrag, null);

//                NavHostFragment navHostFragment = (NavHostFragment) sViewModel.fragMan.getValue().findFragmentById(R.id.nav_host_fragment);
//                NavController navController = navHostFragment.getNavController();
//                NavDirections action = WelcomeInfoFragDirections.actionWelcomeInfoFragToAgeFrag();
//                navController.navigate(action);
//
//                Navigation.findNavController(view).navigate(action);
                sViewModel.started.setValue(true);

            }
        });



    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

}