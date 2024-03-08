package com.bookshop.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.bookshop.databinding.ActivityIntroBinding;

public class IntroActivity extends BaseActivity {

    ActivityIntroBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityIntroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setClickActivity();
        getWindow().setStatusBarColor(Color.parseColor("#F9ABFF"));
    }

    private void setClickActivity() {
        binding.goToLogin.setOnClickListener(v -> {
            if(mAuth.getCurrentUser() != null) {
                startActivity(new Intent(IntroActivity.this, MainActivity.class));
            } else {
                startActivity(new Intent(IntroActivity.this, LoginActivity.class));
            }
        });

        binding.goToSignup.setOnClickListener(v -> {
            startActivity(new Intent(IntroActivity.this, SignupActivity.class));
        });
    }
}