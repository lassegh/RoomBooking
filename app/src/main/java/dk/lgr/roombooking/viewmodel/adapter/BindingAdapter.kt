package dk.lgr.roombooking.viewmodel.adapter

import android.app.Activity
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dk.lgr.roombooking.model.Booking

@BindingAdapter("bookingsList")
 fun setProductsList(view:RecyclerView, bookings:List<Booking>?) {
     if (bookings == null)return

    view.layoutManager = LinearLayoutManager(view.context)
    view.adapter = BookingAdapter(view.context, bookings)
 }
