package com.bookshop.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import com.bookshop.Fragments.CartFragment;
import com.bookshop.Fragments.HomeFragment;
import com.bookshop.Fragments.ProfileFragment;
import com.bookshop.Fragments.WishlistFragment;
import com.bookshop.R;
import com.bookshop.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        replaceFragment(new HomeFragment());
        binding.bottomNav.setBackground(null);
        getWindow().setStatusBarColor(getResources().getColor(R.color.cool_purple_light));
        bottomNavigation();
    }

    private void bottomNavigation() {
        binding.bottomNav.setOnItemSelectedListener( item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.explorer) {
                replaceFragment(new HomeFragment());
            } else if (itemId == R.id.wishlist) {
                replaceFragment(new WishlistFragment());
            } else if (itemId == R.id.cart) {
                replaceFragment(new CartFragment());
            } else if (itemId == R.id.profile) {
                replaceFragment(new ProfileFragment());
            }
            return true;
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}