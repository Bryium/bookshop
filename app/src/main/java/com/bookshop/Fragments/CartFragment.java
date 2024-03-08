package com.bookshop.Fragments;

import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.bookshop.Adapter.CartAdapter;
import com.bookshop.Helper.ChangeNumberItemsListener;
import com.bookshop.Helper.ManagmentCart;
import com.bookshop.R;
import com.bookshop.databinding.FragmentCartBinding;


public class CartFragment extends Fragment {

    private ManagmentCart managmentCart;
    FragmentCartBinding binding;
    double tax;

    public CartFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCartBinding.inflate(inflater, container, false);
        View rootView = binding.getRoot();

        managmentCart = new ManagmentCart(getContext());

        initList();
        calculatorCart();

        return rootView;
    }

    private void calculatorCart() {
        double percentTax = 0.02;
        double delivery = 10;
        tax = Math.round(managmentCart.getTotalFee() * percentTax * 100) / 100;

        double total = Math.round((managmentCart.getTotalFee() + tax + delivery) * 100) / 100;
        double itemTotal = Math.round(managmentCart.getTotalFee() * 100) / 100;
        binding.totalFeeTxt.setText("Ksh" + itemTotal);
        binding.taxTxt.setText("Ksh" + tax);
        binding.deliveryTxt.setText("Ksh" + delivery);
        binding.totalTxt.setText("Ksh" + total);
    }

    private void initList() {
        if(managmentCart.getListCart().isEmpty()) {
            binding.emptyTxt.setVisibility(View.VISIBLE);
            binding.scroll.setVisibility(View.GONE);
        } else {
            binding.emptyTxt.setVisibility(View.GONE);
            binding.scroll.setVisibility(View.VISIBLE);
        }

        binding.cartView.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false));
        binding.cartView.setAdapter(new CartAdapter(managmentCart.getListCart(), new ChangeNumberItemsListener() {
            @Override
            public void change() {
                calculatorCart();
            }
        }));
    }

    public void onDestroyView() {
        super.onDestroyView();

        binding = null;
    }
}