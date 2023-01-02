package com.saket.booking

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.saket.domain.model.Flight

class FlightsAdapter : ListAdapter<Flight, FlightsAdapter.FlightViewHolder>(FlightsDiff()) {

    class FlightViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(flight: Flight) {
            val itemTextView = itemView.findViewById<TextView>(R.id.item_name)
            itemTextView.text = flight.name
        }
    }

    class FlightsDiff : DiffUtil.ItemCallback<Flight>() {
        override fun areItemsTheSame(oldItem: Flight, newItem: Flight): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Flight, newItem: Flight): Boolean {
            return  oldItem.airlineId == newItem.airlineId
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlightViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: FlightViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}