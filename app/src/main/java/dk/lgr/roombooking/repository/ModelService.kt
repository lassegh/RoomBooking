package dk.lgr.roombooking.repository

import dk.lgr.roombooking.model.Reservation
import dk.lgr.roombooking.model.Room
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ModelService {

    // get reservations from specific room
    @GET("reservations/room/{ids}/{fromTime}/{toTime}")
    fun getAllReservations(
        @Path("ids") ids: Int,
        @Path("fromTime") fromTime: Int,
        @Path("toTime") toTime: Int
    ): Call<List<Reservation?>?>?

    @POST("reservations")
    fun postReservation(@Body reservation: Reservation?): Call<Int?>?

    @GET("reservations/{id}")
    fun getOneReservation(id: Int): Call<Reservation?>?

    @DELETE("reservations/{id}")
    fun deleteReservation(@Path("id") id: Int): Call<Void?>?

    @GET("rooms")
    fun getAllRooms(): Call<List<Room?>?>?

    @GET("rooms/free/{fromTime}")
    fun getAvailableRooms(@Path("fromTime") fromTime: Int): Call<List<Room?>?>?
}