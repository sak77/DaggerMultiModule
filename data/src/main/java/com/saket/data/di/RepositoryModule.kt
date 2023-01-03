package com.saket.data.di

import android.content.Context
import com.saket.data.BookingRepository
import com.saket.data.db.BookingDB
import com.saket.domain.repository.IBookingRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/*
Should provides method be static or non-static?
For -
    As per one theory, invocation of static methods is 15 to 20 % faster
    compared to non-static methods....
    also static methods do not require instance of module to be created
    no need for this instance.
    So it is recommended to use static provides method.
Against -
    One should NEVER put Android Framework classes (context, Fragment, Activity etc.)
    in static variables or they can cause Memory Leaks. So having static function
    for context is a BIG NO.
    But in other places, maybe it is fine to have static provides method.
*/
/*
    Having context in class constructor makes it inaccessible to
    functions in companion object. So having context or other external
    module dependencies in class constructor has some drawbacks as well..
 */
//class RepositoryModule constructor(private val testContext: Context) {

//NOTE: Modules cannot be scoped..
@Module
class RepositoryModule {

    /*
    As a rule of thumb, one should never have Android framework classes
    inside static functions.
     */
    @Provides
    fun providesBookingDB(context: Context): BookingDB {
        return BookingDB.getInstance(context)
    }

    companion object {
        /*
           Now Dagger2 (version 2.26) support companion objects
           in @Module annotated classes in kotlin without @Module
           and @JvmStatic annotations
         */
        //@Singleton - scoping provider function, means the
        //component also has to have same scope on it.

        @Singleton
        @Provides
        fun providesBookingRepository(bookingDB: BookingDB): IBookingRepository {
            return BookingRepository(bookingDB)
        }
    }
}
