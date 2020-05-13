package dk.lgr.roombooking.viewmodel

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat.startActivity
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import dk.lgr.roombooking.BR
import dk.lgr.roombooking.helpers.CommonInstances
import dk.lgr.roombooking.helpers.LoginHelper
import dk.lgr.roombooking.model.Booking
import dk.lgr.roombooking.repository.getBookingService
import dk.lgr.roombooking.view.DatePicker
import dk.lgr.roombooking.view.LoginActivity
import dk.lgr.roombooking.view.util.toUnix
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(context: Context): BaseObservable() {

    val context:Context = context
    val cInstances = CommonInstances
    val loginHelper = LoginHelper()

    @get:Bindable
    var bookingList:List<Booking> = listOf<Booking>()
        set(value) {
            Log.d("AppMy", "Liste er ved at blive sat")
            field = value
            notifyPropertyChanged(BR.bookingList)
            Log.d("AppMy", "Listen er sat")
        }

    @get:Bindable
    var recyclerViewIsRefreshing:Boolean = false
        set(value) {
            field = value
            notifyPropertyChanged(BR.recyclerViewIsRefreshing)
        }

    fun fabAction() {
        // TODO floating action button action
        Log.d("AppMy","Floating action Button pressed")
    }

    fun showFromCalendar(){
        val datePicker = DatePicker(context, CommonInstances.fromCalendar)
        datePicker.show()
    }

    fun showToCalendar(){
        val datePicker = DatePicker(context, CommonInstances.toCalendar)
        datePicker.show()
    }

    fun goToLogin(){
        val intent:Intent = Intent(context, LoginActivity::class.java)
        startActivity(context,intent,null)
    }

    fun goToLogout(){
        val alertDialog =
            AlertDialog.Builder(context).create()
        alertDialog.setTitle("Logged in as " + LoginHelper.firebaseUser!!.getEmail())
        alertDialog.setMessage("Do you want to log out?")
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Yes") {
                dialog: DialogInterface, _: Int ->
                loginHelper.logout(context)
                dialog.dismiss()
        }
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "No") {
                dialog: DialogInterface, _: Int -> dialog.dismiss()
        }
        alertDialog.show()
    }

    fun refreshRecyclerView(){
        recyclerViewIsRefreshing = true
        bookingListFetch()
        recyclerViewIsRefreshing = false
    }

    fun bookingListFetch(){
        val callReservations = getBookingService().getAllReservations(1, cInstances.fromCalendar.toUnix(),cInstances.toCalendar.toUnix())
        callReservations.enqueue(object:Callback<List<Booking>> {
            override fun onResponse(call:Call<List<Booking>>, response:Response<List<Booking>>) {
                if (response.isSuccessful) {
                    Log.d("AppMy", "Response successful")
                    bookingList = response.body()!!.toList()
                    Log.d("AppMy", response.body().toString())
                } else {
                    Toast.makeText(context,"'To Date' cannot be before 'From Date'.", Toast.LENGTH_LONG).show()
                }
            }
            override fun onFailure(call: Call<List<Booking>>, t: Throwable) {
                Log.e("AppMy", t.message)
                Toast.makeText(context,"An error occurred. Try again later", Toast.LENGTH_LONG).show()
            }
        })
    }
}