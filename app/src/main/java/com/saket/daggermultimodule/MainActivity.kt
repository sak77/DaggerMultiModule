package com.saket.daggermultimodule

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.saket.booking.BookingFragment
import com.saket.daggermultimodule.databinding.ActivityMainBinding
import com.saket.daggermultimodule.di.DaggerApplicationComponent
import com.saket.data.BookingRepository
import com.saket.data.di.RepositoryModule
import com.saket.domain.model.Booking
import com.saket.domain.model.User
import com.saket.domain.repository.IBookingRepository
import com.saket.login.LoginFragment
import com.saket.register.RegisterFragment
import javax.inject.Inject

class MainActivity : FragmentActivity() {
    @Inject
    lateinit var bookingRepository: IBookingRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MainApplication).applicationComponent.inject(this)
        /*
        DaggerApplicationComponent
            .factory()
            .create(applicationContext, RepositoryModule())
            .inject(this)
         */
        val binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        binding.btnLogin.setOnClickListener {
            fragmentTransaction.replace(R.id.fragment_container, LoginFragment())
                .commit()
        }
        binding.btnNewUser.setOnClickListener {
            fragmentTransaction.replace(R.id.fragment_container, RegisterFragment())
                .commit()
        }
        binding.btnBook.setOnClickListener {
            fragmentTransaction.replace(R.id.fragment_container, BookingFragment())
                .commit()
        }
    }
}