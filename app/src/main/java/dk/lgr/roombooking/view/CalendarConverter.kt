package dk.lgr.roombooking.view

import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import java.util.*

fun Calendar.toDate() = SimpleDateFormat("dd/MM/yy", Locale.GERMAN).format(this.getTime())

fun Calendar.toDateTime() = SimpleDateFormat("dd/MM/yy - HH:mm", Locale.GERMAN).format(this.getTime())


