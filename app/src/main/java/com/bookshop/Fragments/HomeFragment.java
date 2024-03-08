package com.bookshop.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bookshop.Adapter.PopularAdapter;
import com.bookshop.Domain.PopularDomain;

import com.bookshop.databinding.FragmentHomeBinding;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View rootView = binding.getRoot();

        initRecyclerView();
        return rootView;
    }

    private void initRecyclerView() {
        ArrayList<PopularDomain> items = new ArrayList<>();
        items.add(new PopularDomain("Oxford Dictionary", "oxford_dic", 15, 4, 1500, "test"));
        items.add(new PopularDomain("English Aid", "english_aid",10 , 4.5, 350,"English Aid 1 offers a wide range of features to support your language learning journey. From grammar rules to common phrases and expressions, this tool covers all the essential elements of English language proficiency. With clear explanations and examples, you'll quickly grasp the fundamentals of grammar and gain confidence in using the language correctly."));
        items.add(new PopularDomain("Primary Mathematics", "primary_maths", 3, 4.9, 580, "This is the first book in the new series of Primary Mathematics written specifically for the competence-based curriculum. The coursebook is intended for use by Grade 1 learners. It prepares the learner for day to day living and number work in higher levels of schooling."));

        binding.PopularView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL, false));
        binding.PopularView.setAdapter(new PopularAdapter(items));
    }

    public void onDestroyView() {
        super.onDestroyView();

        binding = null;
    }
}