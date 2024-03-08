package com.bookshop.Activity;

import android.os.Bundle;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.bookshop.R;
import com.bookshop.databinding.ActivityProfileSettingsBinding;

public class ProfileSettingsActivity extends AppCompatActivity {
    ActivityProfileSettingsBinding binding;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        binding = ActivityProfileSettingsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        statusBarColor();

        binding.backBtn.setOnClickListener( v -> finish());
    }

    private void statusBarColor() {
        Window window = ProfileSettingsActivity.this.getWindow();
        window.setStatusBarColor(ContextCompat.getColor(ProfileSettingsActivity.this, R.color.white));
    }
}
