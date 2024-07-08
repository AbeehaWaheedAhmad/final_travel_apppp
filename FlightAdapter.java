package com.example.final_travel_apppp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class FlightAdapter extends RecyclerView.Adapter<FlightAdapter.FlightViewHolder> {

    private List<Flight> flightList;

    public FlightAdapter(List<Flight> flightList) {
        this.flightList = flightList;
    }

    @NonNull
    @Override
    public FlightViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_flight, parent, false);
        return new FlightViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FlightViewHolder holder, int position) {
        Flight flight = flightList.get(position);
        holder.tvFlightName.setText(flight.getName());
        holder.tvFlightDetails.setText(flight.getDetails());
        holder.tvFlightPrice.setText(flight.getPrice());
    }

    @Override
    public int getItemCount() {
        return flightList.size();
    }

    static class FlightViewHolder extends RecyclerView.ViewHolder {

        TextView tvFlightName;
        TextView tvFlightDetails;
        TextView tvFlightPrice;

        public FlightViewHolder(@NonNull View itemView) {
            super(itemView);
            tvFlightName = itemView.findViewById(R.id.tvFlightName);
            tvFlightDetails = itemView.findViewById(R.id.tvFlightDetails);
            tvFlightPrice = itemView.findViewById(R.id.tvFlightPrice);
        }
    }
}
