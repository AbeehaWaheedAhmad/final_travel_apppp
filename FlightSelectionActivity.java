package com.example.final_travel_apppp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

public class FlightSelectionActivity extends AppCompatActivity {

    private RecyclerView rvFlights;
    private FlightAdapter flightAdapter;
    private List<Flight> flightList;
    private DatabaseReference flightsRef;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_selection);

        // Initialize Firebase
  //      FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    //    FirebaseUser currentUser = firebaseAuth.getCurrentUser();
/*
        if (currentUser == null) {
            // If user is not logged in, redirect to LoginActivity
            startActivity(new Intent(FlightSelectionActivity.this, LoginActivity.class));
            finish(); // Optional: Prevents user from returning to FlightSelectionActivity using the back button
        }
*/
        // Initialize RecyclerView
        rvFlights = findViewById(R.id.rvFlights);
        rvFlights.setLayoutManager(new LinearLayoutManager(this));
        flightList = new ArrayList<>();
        flightAdapter = new FlightAdapter(flightList);
        rvFlights.setAdapter(flightAdapter);

        // Firebase Database Reference
        flightsRef = FirebaseDatabase.getInstance().getReference().child("flights");

        Button btnFilter = findViewById(R.id.btnFilter);
        Button btnSort = findViewById(R.id.btnSort);
        Button btnProceedToPayment = findViewById(R.id.btnProceedToPayment);

        btnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFilterDialog();
            }
        });

        btnSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSortDialog();
            }
        });

        btnProceedToPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to PaymentSelectionActivity
                Intent intent = new Intent(FlightSelectionActivity.this, PaymentSelectionActivity.class);
                startActivity(intent);
            }
        });

        loadFlights();
    }

    private void loadFlights() {
        // Read data from Firebase Database
        flightsRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                flightList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Flight flight = snapshot.getValue(Flight.class);
                    if (flight != null) {
                        flightList.add(flight);
                    }
                }
                flightAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(FlightSelectionActivity.this, "Failed to load flights.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showFilterDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Filter Flights")
                .setItems(new String[]{"Price Range", "Airline", "Departure Time", "Arrival Time", "Duration"}, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Handle the filter options
                        Toast.makeText(FlightSelectionActivity.this, "Filter option selected", Toast.LENGTH_SHORT).show();
                    }
                });
        builder.create().show();
    }

    private void showSortDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Sort Flights")
                .setItems(new String[]{"Price (Low to High)", "Price (High to Low)", "Departure Time (Earliest)", "Departure Time (Latest)", "Arrival Time (Earliest)", "Arrival Time (Latest)", "Duration (Shortest)", "Duration (Longest)"}, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(FlightSelectionActivity.this, "Sort option selected", Toast.LENGTH_SHORT).show();
                    }
                });
        builder.create().show();
    }
}
