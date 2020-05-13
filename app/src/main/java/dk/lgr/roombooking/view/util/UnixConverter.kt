package dk.lgr.roombooking.view.util

import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import java.util.*

fun Calendar.toUnix():Int = (this.time.time / 1000).toInt()
fun Int.toDateTimeString():String = SimpleDateFormat("dd/MM/yy HH:mm", Locale.GERMAN).format(this)