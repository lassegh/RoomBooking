package dk.lgr.roombooking.viewmodel.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import dk.lgr.roombooking.BR
import dk.lgr.roombooking.R
import dk.lgr.roombooking.databinding.BookingRowBinding
import dk.lgr.roombooking.model.Booking

class BookingAdapter(context:Context, bookings:List<Booking>?) : RecyclerView.Adapter<BookingAdapter.BindingViewHolder>() {

    val context = context
    val bookings = bookings

    class BindingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding:BookingRowBinding? = DataBindingUtil.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder {
        val binding:ViewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.booking_row, parent, false)

        return BindingViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: BindingViewHolder, position: Int) {
        val booking = bookings?.get(position)
        holder.binding?.setVariable(BR.booking, booking)
    }
}