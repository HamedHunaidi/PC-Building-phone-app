package com.example.rigmaker.view.fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.rigmaker.R;
import com.example.rigmaker.databinding.FragmentHomeBinding;
import com.example.rigmaker.model.Case;
import com.example.rigmaker.view.activities.LoginActivity;
import com.example.rigmaker.view.activities.MainActivity;

import java.util.Arrays;
import java.util.List;

// landing page of the app
public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;



    public HomeFragment() {
        // Required empty public constructor
    }






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater,container,false);
        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor editor = sp.edit();
        //shows the suggested builds from the remote database
        binding.btmSuggested.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(HomeFragment.this).navigate(R.id.action_homeFragment_to_suggestedFragment);
            }
        });
        // shows the community build for the database
        binding.btnCommunity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(HomeFragment.this).navigate(R.id.action_homeFragment_to_communityFragment);

            }
        });
        // takes you to the create your rig section of the code
        binding.ivCreateYourRig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              NavHostFragment.findNavController(HomeFragment.this).navigate(R.id.action_homeFragment_to_createRigFragment);
            }
        });
        // takes you to the help section of the app
        binding.btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               NavHostFragment.findNavController(HomeFragment.this).navigate(R.id.action_homeFragment_to_helpFragment);
            }
        });
        //logs out the current user
        binding.btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putInt("logged",0);
                editor.apply();
                //goes back to to the login screen
                startActivity(new Intent(getContext(), LoginActivity.class));
            }
        });

    }
}