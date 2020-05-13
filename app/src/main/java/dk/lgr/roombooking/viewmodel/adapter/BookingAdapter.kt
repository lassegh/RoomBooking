package dk.lgr.roombooking.viewmodel.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import dk.lgr.roombooking.R
import dk.lgr.roombooking.databinding.BookingRowBinding
import dk.lgr.roombooking.model.Booking

class BookingAdapter(context:Context, bookings:List<Booking>?) : RecyclerView.Adapter<BookingAdapter.BindingViewHolder>() {

    val context = context
    val bookings:MutableList<Booking> = bookings!!.toMutableList()

    class BindingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding:BookingRowBinding? = DataBindingUtil.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder {
        val binding:BookingRowBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.booking_row, parent, false)

        return BindingViewHolder(binding.root)
    }

    override fun getItemCount(): Int = bookings!!.count()

    override fun onBindViewHolder(holder: BindingViewHolder, position: Int) {
        val booking = bookings?.get(position)
        holder.binding?.booking = booking
        //holder.binding?.setVariable(BR.booking, booking)
    }

    fun refreshList(bookings:List<Booking>?) {
        this.bookings.removeAll(this.bookings)
        if (bookings != null) this.bookings.addAll(bookings)
        notifyDataSetChanged()
    }
}