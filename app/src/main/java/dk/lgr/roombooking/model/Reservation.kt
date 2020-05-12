package dk.lgr.roombooking.model

data class Reservation(val id:Int, val fromTime:Int, val toTime:Int, val userMail:String, val purpose:String, val roomId:Int)