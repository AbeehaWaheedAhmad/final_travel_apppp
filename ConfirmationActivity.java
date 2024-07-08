package com.example.final_travel_apppp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

public class ConfirmationActivity extends AppCompatActivity {

    private DatabaseHelper dbHelper;
    private TextView confirmationText;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        dbHelper = new DatabaseHelper(this);
        confirmationText = findViewById(R.id.confirmation_text);


        String userId = "user123";
        String flightName = getIntent().getStringExtra("flightName");
        String flightDetails = getIntent().getStringExtra("flightDetails");
        String flightPrice = getIntent().getStringExtra("flightPrice");

        // Store booking details in SQLite
        dbHelper.addBooking(userId, flightName, flightDetails, flightPrice);

        // Display confirmation message
        String confirmationMessage = "Booking confirmed for " + flightName + ".\nDetails: " + flightDetails + "\nPrice: " + flightPrice;
        confirmationText.setText(confirmationMessage);
    }
}
