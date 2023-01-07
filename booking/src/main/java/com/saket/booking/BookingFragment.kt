package com.saket.booking

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.saket.booking.databinding.FragmentBookingBinding
import com.saket.booking.di.BookingComponentProvider
import javax.inject.Inject

class BookingFragment : Fragment() {

    @Inject
    lateinit var bookingViewModelFactory: BookingViewModelFactory
    private val bookingViewModel:BookingViewModel by viewModels {
        bookingViewModelFactory
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val bookingComponentProvider = activity?.applicationContext as BookingComponentProvider
        val bookingComponent = bookingComponentProvider.provideBookingComponent()
        bookingComponent.inject(this)
        /*
        DaggerBookingComponent.builder()
            .bookingModule(BookingModule(context))
            .build()
            .inject(this)
         */
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bookingViewModel.initBooking()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentBookingBinding.inflate(inflater, container, false)
        var locationsArray: ArrayAdapter<String>?
        var flightsArray: ArrayAdapter<String>?
        bookingViewModel.liveLocations.observe(viewLifecycleOwner) { list ->
            locationsArray = context?.let { it1 ->
                ArrayAdapter(
                    it1,
                    android.R.layout.simple_list_item_1,
                    list.map { location -> location.name }
                )
            }
            binding.spinnerSource.adapter = locationsArray
            binding.spinnerDestination.adapter = locationsArray
        }
        bookingViewModel.liveFlights.observe(viewLifecycleOwner) { flights ->
            flightsArray = context?.let { it1 ->
                ArrayAdapter(
                    it1,
                    android.R.layout.simple_list_item_1,
                    flights.map { flight -> flight.name }
                )
            }
            binding.spinnerFlight.adapter = flightsArray
        }

        binding.btnBook.setOnClickListener {
            val id = (1..20).random().toString()
            //bookingViewModel.addBooking(Booking(id,))
        }
        return binding.root
    }
}