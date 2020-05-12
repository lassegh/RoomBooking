package dk.lgr.roombooking.helpers

import android.R.attr.password
import android.app.Activity
import android.content.Context
import android.util.Log
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


class LoginHelper {
    companion object{
        var mAuth: FirebaseAuth = FirebaseAuth.getInstance()
        var firebaseUser: FirebaseUser? = mAuth.currentUser
    }

    fun isSomeoneLoggedIn() = firebaseUser != null

    fun logout(context:Context){
        mAuth.signOut()
        firebaseUser = null
        Toast.makeText(
            context,
            "You have been logged out.",
            Toast.LENGTH_LONG
        ).show()
    }

    fun login(email:String, password:String, activity:Activity){

        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(activity,
                OnCompleteListener<AuthResult?> { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d("AppMy", "signInWithEmail:success")
                        Toast.makeText(
                            activity.applicationContext, "You are successfully logged in.",
                            Toast.LENGTH_SHORT
                        ).show()
                        activity.finish()
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w("AppMy", "signInWithEmail:failure", task.exception)
                        Toast.makeText(
                            activity.applicationContext, "Authentication failed.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                })
    }
}