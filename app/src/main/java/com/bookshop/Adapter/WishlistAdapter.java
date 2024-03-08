package com.bookshop.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bookshop.Activity.DetailActivity;
import com.bookshop.Domain.PopularDomain;
import com.bookshop.databinding.ViewholderWishlistBinding;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;

import java.util.ArrayList;

public class WishlistAdapter  extends RecyclerView.Adapter<WishlistAdapter.Viewholder> {
    ArrayList<PopularDomain> items;
    Context context;
    ViewholderWishlistBinding binding;

    public WishlistAdapter(ArrayList<PopularDomain> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public WishlistAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ViewholderWishlistBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        context = parent.getContext();
        return new WishlistAdapter.Viewholder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull WishlistAdapter.Viewholder holder, int position) {
        binding.titleTxt.setText(items.get(position).getTitle());
        binding.feeTxt.setText("Ksh" + items.get(position).getPrice());
        binding.scoreTxt.setText("" + items.get(position).getScore());
        binding.reviewTxt.setText("" + items.get(position).getReview());

        int drawableResource = holder.itemView.getResources().getIdentifier(items.get(position).getPicUrl(),
                "drawable",holder.itemView.getContext().getPackageName());

        Glide.with(context)
                .load(drawableResource)
                .transform(new GranularRoundedCorners(30, 30, 0, 0))
                .into(binding.pic);


        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("object", items.get(position));
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        public Viewholder(ViewholderWishlistBinding binding) {
            super(binding.getRoot());
        }
    }
}
