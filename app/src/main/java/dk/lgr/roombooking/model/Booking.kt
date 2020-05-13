package dk.lgr.roombooking.model

data class Booking(val id:Int, val fromTime:Int, val toTime:Int, val userMail:String, val purpose:String, val roomId:Int)