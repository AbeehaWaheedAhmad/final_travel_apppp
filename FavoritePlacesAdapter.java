package com.example.final_travel_apppp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FavoritePlacesAdapter extends RecyclerView.Adapter<FavoritePlacesAdapter.ViewHolder> {

    private List<Place> favoritePlaces;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Place place);
    }

    public FavoritePlacesAdapter(List<Place> favoritePlaces, OnItemClickListener listener) {
        this.favoritePlaces = favoritePlaces;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_favorite_place, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Place place = favoritePlaces.get(position);
        holder.placeName.setText(place.getName());
        holder.placeLocation.setText(place.getLocation());
        holder.placeImage.setImageResource(place.getImageResId());
        holder.itemView.setOnClickListener(v -> listener.onItemClick(place));
    }

    @Override
    public int getItemCount() {
        return favoritePlaces.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView placeName;
        public TextView placeLocation;
        public ImageView placeImage;

        public ViewHolder(View itemView) {
            super(itemView);
            placeName = itemView.findViewById(R.id.place_name);
            placeLocation = itemView.findViewById(R.id.place_location);
            placeImage = itemView.findViewById(R.id.place_image);
        }
    }
}
