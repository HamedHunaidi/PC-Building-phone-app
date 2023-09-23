package com.example.rigmaker.view.fragments;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.rigmaker.databinding.FragmentHelpBinding;
import com.example.rigmaker.view.activities.WebViewActivity;


public class HelpFragment extends Fragment {

    private FragmentHelpBinding binding;

    public HelpFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentHelpBinding.inflate(inflater,container,false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //click listener for user guide
        binding.btnUserGuide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent webViewIntent = new Intent(getContext(), WebViewActivity.class);
                webViewIntent.putExtra("help_url","http://fyhh3.sci-project.lboro.ac.uk/MobileApp/UserGuide.html");
                startActivity(webViewIntent);
            }
        });
        //click listener for button FAQ
        binding.btnFaq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent webViewIntent = new Intent(getContext(), WebViewActivity.class);
                webViewIntent.putExtra("help_url","http://fyhh3.sci-project.lboro.ac.uk/MobileApp/FAQ.html");
                startActivity(webViewIntent);
            }
        });
        //click listener for contact us
        binding.btnContactUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMailClient("Contact us at RigMaker");
            }
        });
        // click listener for button report
        binding.btnReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMailClient("Report a RigMaker Bug");
            }
        });

    }
    //Helps to open a mail client on the click
    private void openMailClient(String str) {
        //fire a send to intent
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        String mailList[] = {"help@rigmaker.in"};
        intent.putExtra(Intent.EXTRA_EMAIL, mailList);
        intent.putExtra(Intent.EXTRA_SUBJECT, str);
        intent.putExtra(Intent.EXTRA_TEXT, "Hi, Team \n ");
        //check if email client is installed
        try {
            startActivity(Intent.createChooser(intent, "Send mail..."));
        } catch ( ActivityNotFoundException ex) {
            Toast.makeText(
                    requireContext(),
                    "There are no email clients installed.",
                    Toast.LENGTH_SHORT
            ).show();
        }
    }
}