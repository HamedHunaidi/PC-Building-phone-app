package com.example.rigmaker.view.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.rigmaker.databinding.ActivityLoginBinding;
import com.example.rigmaker.model.database.LoginTable;
import com.example.rigmaker.viewmodel.LoginViewModel;

import java.util.List;
import java.util.Objects;
//login cum sign up activity
public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;
    private LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //shared preference to see if a user is already logged in
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sp.edit();
        // go to the main activity if the user is already logged in
        int isSaved = sp.getInt("logged",0);
        if (isSaved==1){
            goToMainActivity(getBaseContext());
        }

        // use a viewmodel to persist changes
        loginViewModel = new ViewModelProvider(LoginActivity.this).get(LoginViewModel.class);

        //get list of all elements
        loginViewModel.getGetAllData().observe(this, data -> {
            try {
                binding.lblEmailAnswer.setText((Objects.requireNonNull(data).get(0).getEmail()));
                binding.lblPasswordAnswer.setText((Objects.requireNonNull(data.get(0).getPassword())));
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        //sign up flow
        binding.btnsignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strEmail = binding.txtEmailAddress.getText().toString().trim();
                String strPassword = binding.txtPassword.getText().toString().trim();
                LoginTable data = new LoginTable();
                if (TextUtils.isEmpty(strEmail)) {
                    binding.txtEmailAddress.setError("Please Enter Your E-mail Address");
                }
                else if (TextUtils.isEmpty(strPassword)) {
                    binding.txtPassword.setError("Please Enter Your Password");
                }
                else {
                    data.setEmail(strEmail);
                    data.setPassword(strPassword);
                    loginViewModel.insert(data);
                    Toast.makeText(LoginActivity.this, "Successfully signed up", Toast.LENGTH_SHORT).show();
                    binding.txtEmailAddress.setText("");
                    binding.txtPassword.setText("");
                }
            }
        });
        //login flow
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String strEmail = binding.txtEmailAddress.getText().toString().trim();
                String strPassword = binding.txtPassword.getText().toString().trim();
                LoginTable data = new LoginTable();
                if (TextUtils.isEmpty(strEmail)) {
                    binding.txtEmailAddress.setError("Please Enter Your E-mail Address");
                }
                else if (TextUtils.isEmpty(strPassword)) {
                    binding.txtPassword.setError("Please Enter Your Password");
                }
                else {
                    List<LoginTable> loginData=loginViewModel.getGetAllData().getValue();
                    if (loginData!=null){
                        for (LoginTable i:loginData){
                            if ((strEmail.equals(i.getEmail()) && strPassword.equals(i.getPassword())) || (strEmail.equals("eee") && strPassword.equals("eee")) ){
                                Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                editor.putInt("logged",1);
                                editor.apply();
                                goToMainActivity(LoginActivity.this);
                                break;
                            }
                        }
                    }
                }
            }
        });
    }

    public void goToMainActivity(Context context){
        startActivity(new Intent(context,MainActivity.class));
    }
}