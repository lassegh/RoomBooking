package dk.lgr.roombooking.viewmodel.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dk.lgr.roombooking.model.Booking

@BindingAdapter("bookingsList")
 fun setProductsList(view:RecyclerView, bookings:List<Booking>) {
     if (bookings == null)return

     /*val layoutManager: RecyclerView.LayoutManager? = view.layoutManager
     if (layoutManager == null) {
         view.setLayoutManager(GridLayoutManager(view.getContext(),1))
     }
     var adapter: BookingAdapter? = view.getAdapter() as BookingAdapter*/
     //if (adapter == null) {
         var adapter = BookingAdapter(view.getContext(), bookings)
         view.setAdapter(adapter)
     //}
 }
