package dk.lgr.roombooking.view

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.content.Context
import android.icu.util.Calendar
import android.widget.DatePicker
import dk.lgr.roombooking.helpers.CommonInstances

class DatePicker(context:Context, cal:Calendar ) : DatePickerDialog(context, setDate(
    cal), cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH)) {

    companion object{
        fun setDate(cal: Calendar): OnDateSetListener? {
            return OnDateSetListener { _: DatePicker?, year: Int, monthOfYear: Int, dayOfMonth: Int ->
                cal[Calendar.YEAR] = year
                cal[Calendar.MONTH] = monthOfYear
                cal[Calendar.DAY_OF_MONTH] = dayOfMonth

                when(cal) {
                    CommonInstances.fromCalendar -> CommonInstances.fromCalendarText = cal.toDate()
                    CommonInstances.toCalendar -> CommonInstances.toCalendarText = cal.toDate()
                }
            }
        }
    }
}