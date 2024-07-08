package com.example.final_travel_apppp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
//import com.google.firebase.firestore.FirebaseFirestore;
import java.util.HashMap;
import java.util.Map;

public class PaymentSelectionActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private Button btnConfirmPayment;
//    private FirebaseFirestore db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_selection);

        radioGroup = findViewById(R.id.radioGroupPayment);
        btnConfirmPayment = findViewById(R.id.btnConfirmPayment);
  //      db = FirebaseFirestore.getInstance();

        btnConfirmPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                if (selectedId != -1) {
                    RadioButton selectedRadioButton = findViewById(selectedId);
                    String paymentMethod = selectedRadioButton.getText().toString();
                    Toast.makeText(PaymentSelectionActivity.this, "Payment confirmed using " + paymentMethod, Toast.LENGTH_SHORT).show();

                    // Store payment details in Firestore
                    storePaymentDetails(paymentMethod);
                } else {
                    Toast.makeText(PaymentSelectionActivity.this, "Please select a payment method", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void storePaymentDetails(String paymentMethod) {
        /*
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();

        if (currentUser != null) {
            // Create a new document in "payments" collection
            Map<String, Object> payment = new HashMap<>();
            payment.put("userId", currentUser.getUid());
            payment.put("paymentMethod", paymentMethod);

            db.collection("payments")
                    .add(payment)
                    .addOnSuccessListener(documentReference -> {
                        // Payment details stored successfully
                        Intent intent = new Intent(PaymentSelectionActivity.this, ConfirmationActivity.class);
                        startActivity(intent);
                        finish(); // Finish this activity after payment is stored
                    })
                    .addOnFailureListener(e -> {
                        // Handle failure
                        Toast.makeText(PaymentSelectionActivity.this, "Failed to store payment details", Toast.LENGTH_SHORT).show();
                    });
        } else {
            // Handle user authentication issue
            Toast.makeText(PaymentSelectionActivity.this, "User not authenticated", Toast.LENGTH_SHORT).show();
        }

         */
    }

}
