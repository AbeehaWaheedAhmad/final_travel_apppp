package com.example.final_travel_apppp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class PlaceDetailsActivity extends AppCompatActivity {

    private ViewPager imageCarousel;
    private TextView placeNameTextView;
    private TextView placeLocationTextView;
    private Button bookNowButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_details);

        imageCarousel = findViewById(R.id.image_carousel);
        placeNameTextView = findViewById(R.id.place_name);
        placeLocationTextView = findViewById(R.id.place_location);
        bookNowButton = findViewById(R.id.book_now_button);

        Intent intent = getIntent();
        String placeName = intent.getStringExtra("placeName");
        String placeLocation = intent.getStringExtra("placeLocation");
        int placeImageResId = intent.getIntExtra("placeImageResId", 0);

        placeNameTextView.setText(placeName);
        placeLocationTextView.setText(placeLocation);

        // Set adapter for ViewPager
        List<Integer> images = new ArrayList<>();
        images.add(placeImageResId);
        imageCarousel.setAdapter(new ImageCarouselAdapter(this, images));

        bookNowButton.setOnClickListener(v -> {
            Intent paymentIntent = new Intent(PlaceDetailsActivity.this, PaymentSelectionActivity.class);
            startActivity(paymentIntent);
        });
    }
}