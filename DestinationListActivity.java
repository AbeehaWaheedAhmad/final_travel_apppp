package com.example.final_travel_apppp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class DestinationListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FavoritePlacesAdapter adapter;
    private List<Place> favoritePlaces;
    private DatabaseHelper dbHelper;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination_details);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        dbHelper = new DatabaseHelper(this);

        favoritePlaces = dbHelper.getAllFavoritePlaces(); // Retrieve favorite places from SQLite
        adapter = new FavoritePlacesAdapter(favoritePlaces, place -> {
            Intent intent = new Intent(DestinationListActivity.this, PlaceDetailsActivity.class);
            intent.putExtra("placeName", place.getName());
            intent.putExtra("placeLocation", place.getLocation());
            intent.putExtra("placeImageResId", place.getImageResId());
            startActivity(intent);
        });

        recyclerView.setAdapter(adapter);
    }
}
