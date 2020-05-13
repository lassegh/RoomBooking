package dk.lgr.roombooking.helpers

import android.icu.util.Calendar
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import dk.lgr.roombooking.view.util.toDate
import dk.lgr.roombooking.BR
import kotlin.properties.Delegates

object CommonInstances : BaseObservable() {

    @get:Bindable
    var fromCalendar:Calendar = Calendar.getInstance()
        set(value) {
            field = value
            notifyPropertyChanged(BR.fromCalendar)
        }

    @get:Bindable
    var toCalendar:Calendar = Calendar.getInstance()
        set(value) {
            field = value
            notifyPropertyChanged(BR.toCalendar)
        }

    init {
        toCalendar.add(Calendar.DAY_OF_MONTH, 7)
    }

    var refreshListeners = ArrayList<() -> Unit>()

    @get:Bindable
    var fromCalendarText:String = fromCalendar.toDate()
        set(value) {
            field = value
            fromCalendarObservable = value
            notifyPropertyChanged(BR.fromCalendarText)
        }

    @get:Bindable
    var toCalendarText:String = toCalendar.toDate()
        set(value) {
            field = value
            toCalendarObservable = value
            notifyPropertyChanged(BR.toCalendarText)
        }

    var fromCalendarObservable:String by Delegates.observable(fromCalendarText) {
            property, oldValue, newValue -> refreshListeners.forEach{
        it()
    }
    }

    var toCalendarObservable:String by Delegates.observable(toCalendarText) {
            property, oldValue, newValue -> refreshListeners.forEach{
        it()
    }
    }
}