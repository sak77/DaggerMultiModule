package com.saket.booking

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saket.domain.model.Booking
import com.saket.domain.model.Flight
import com.saket.domain.model.Location
import com.saket.domain.usecases.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import javax.inject.Inject

class BookingViewModel @Inject constructor(
    private val addFlight: AddFlight,
    private val getAllFlights: GetAllFlights,
    private val addLocation: AddLocation,
    private val getAllLocations: GetAllLocations,
    private val addBooking: AddBooking,
    private val getAllBookings: GetAllBookings,
    private val clearFlights: ClearFlights,
    private val clearLocations: ClearLocations
) : ViewModel() {

    private var _mutableLocations: MutableLiveData<List<Location>> = MutableLiveData(listOf())
    val liveLocations: LiveData<List<Location>>
        get() = _mutableLocations

    private var _mutableFlights: MutableLiveData<List<Flight>> = MutableLiveData(listOf())
    val liveFlights: LiveData<List<Flight>>
        get() = _mutableFlights

    private var _mutableBookings: MutableLiveData<List<Booking>> = MutableLiveData(listOf())
    val liveBookings: LiveData<List<Booking>>
        get() = _mutableBookings


    fun initBooking() {
        clearData()
        setupLocations()
        setupFlights()
        getAllLocations()
        getAllFlights()
    }

    private fun clearData() {
        clearFlights.execute(viewModelScope, null)
        clearLocations.execute(viewModelScope, null)
    }

    private fun setupLocations() {
        val location1 = Location("mum", "Mumbai")
        val location2 = Location("got", "Gothenburg")
        val location3 = Location("dxb", "Dubai")
        val location4 = Location("us", "USA")
        val location5 = Location("sgp", "Singapore")
        val location6 = Location("mas", "Malaysia")
        val location7 = Location("thai", "ThaiLand")
        val location8 = Location("sl", "Sri Lanka")
        addLocation.execute(viewModelScope, location1)
        addLocation.execute(viewModelScope, location2)
        addLocation.execute(viewModelScope, location3)
        addLocation.execute(viewModelScope, location4)
        addLocation.execute(viewModelScope, location5)
        addLocation.execute(viewModelScope, location6)
        addLocation.execute(viewModelScope, location7)
        addLocation.execute(viewModelScope, location8)
    }

    private fun setupFlights() {
        val flight1 = Flight("ai", "Air India")
        val flight2 = Flight("klm", "KLM")
        val flight3 = Flight("luf", "Lufthansa")
        val flight4 = Flight("emt", "Emirates")
        val flight5 = Flight("sgl", "Singapore Airlines")
        addFlight.execute(viewModelScope, flight1)
        addFlight.execute(viewModelScope, flight2)
        addFlight.execute(viewModelScope, flight3)
        addFlight.execute(viewModelScope, flight4)
        addFlight.execute(viewModelScope, flight5)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    private fun getAllLocations() {
        val deferred = getAllLocations.execute(viewModelScope, null)
        deferred.invokeOnCompletion {
            if (it == null) {
                _mutableLocations.postValue(deferred.getCompleted())
                println("Saket getAllLocations completed ${deferred.getCompleted()}")
            } else {
                println("Saket getAllLocations completed ${it.message}")
            }
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    private fun getAllFlights() {
        val deferred = getAllFlights.execute(viewModelScope, null)
        deferred.invokeOnCompletion {
            if (it == null) {
                _mutableFlights.postValue(deferred.getCompleted())
                println("Saket getAllFlights completed ${deferred.getCompleted()}")
            } else {
                println("Saket getAllFlights completed ${it.message}")
            }
        }
    }

    fun addBooking(booking: Booking) {
        addBooking.execute(viewModelScope, booking)
    }

    fun getAllBookings() {
        viewModelScope.launch {
            getAllBookings.executeFlow(viewModelScope, null)
                .collect {
                    _mutableBookings.postValue(it)
                    println("Saket getAllBookings collect $it")
                }
        }
    }
}
