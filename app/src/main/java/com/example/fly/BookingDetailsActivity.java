package com.example.fly;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class BookingDetailsActivity extends AppCompatActivity {

    private final TextView tvDate;
    private final AlertDialog dialog;

    public BookingDetailsActivity(TextView tvDate, AlertDialog dialog) {
        this.tvDate = tvDate;
        this.dialog = dialog;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_details);

        // Initialize UI elements
        TextView tvPassengerName = findViewById(R.id.tvPassengerName);
        TextView tvRoute = findViewById(R.id.tvRoute);
        TextView tvDeparture = findViewById(R.id.tvDeparture);
        TextView tvDestination = findViewById(R.id.tvDestination);
        TextView tvTicketType = findViewById(R.id.tvTicketType);

        // Get data from the Intent
        Intent intent = getIntent();
        if (intent != null) {
            String passengerName = intent.getStringExtra("passenger_name");
            String route = intent.getStringExtra("route");
            long dateMillis = intent.getLongExtra("date", 0);
            String departure = intent.getStringExtra("departure");
            String destination = intent.getStringExtra("destination");
            String ticketType = intent.getStringExtra("ticket_type");

            Date date = new Date(dateMillis);

            // Set data to the TextViews
            tvPassengerName.setText(passengerName);
            tvRoute.setText(route);
            tvDate.setText(formatDate(date));
            tvDeparture.setText(departure);
            tvDestination.setText(destination);
            tvTicketType.setText(ticketType);

            // Set up click listeners for back buttons


            // Show booking confirmation dialog when the primary back button is clicked

            // Finish the activity when the additional back button is clicked

        }
    }

    // Helper method to format Date object as a String
    private String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy", Locale.getDefault());
        return sdf.format(date);
    }

    @Override
    protected void onDestroy() {
        // Dismiss the dialog if it is showing to avoid memory leaks
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
        super.onDestroy();
    }
}
