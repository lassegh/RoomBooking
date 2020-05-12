package dk.lgr.roombooking.viewmodel

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat.startActivity
import dk.lgr.roombooking.helpers.CommonInstances
import dk.lgr.roombooking.helpers.LoginHelper
import dk.lgr.roombooking.repository.getReservationService
import dk.lgr.roombooking.view.DatePicker
import dk.lgr.roombooking.view.LoginActivity

class MainViewModel(context: Context) {

    val context:Context = context
    val cInstances = CommonInstances
    val loginHelper = LoginHelper()

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
}