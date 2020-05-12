package dk.lgr.roombooking.repository

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "http://anbo-roomreservationv3.azurewebsites.net/api/"

fun getBookingService(): ModelService {
    return retrofit.create(ModelService::class.java)
}

private val retrofit: Retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()