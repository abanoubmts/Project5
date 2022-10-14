package com.udacity.project4.authentication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.udacity.project4.R
import com.udacity.project4.databinding.ActivityAuthenticationBinding
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.FirebaseAuth
import com.udacity.project4.Constants
import com.udacity.project4.locationreminders.RemindersActivity


/**
 * This class should be the starting point of the app, It asks the users to sign in / register, and redirects the
 * signed in users to the RemindersActivity.
 */
class AuthenticationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAuthenticationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)
//         TODO: Implement the create account and sign in using FirebaseUI, use sign in using email and sign in using Google

//          TODO: If the user was authenticated, send him to RemindersActivity

//          TODO: a bonus is to customize the sign in flow to look nice using :
        //https://github.com/firebase/FirebaseUI-Android/blob/master/auth/README.md#custom-layout

        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_authentication
        )

        binding.lifecycleOwner = this

        binding.signInButton.setOnClickListener {
            launchSign_AUTH()
        }
    }

    // to use AuthUI  / IdpResponse  classes inside firbase package , we implement
    // 'com.firebaseui:firebase-ui-auth:7.1.1'  in side gradle project
    private fun launchSign_AUTH() {
        val providers = arrayListOf(
            AuthUI.IdpConfig.EmailBuilder().build(), AuthUI.IdpConfig.GoogleBuilder().build()
        )

        // Create and launch sign-in intent.
        // We listen to the response of this activity with the
        // SIGN_IN_REQUEST_CODE
        startActivityForResult(
            AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(providers)
                .build(),
            Constants.SIGN_IN_RESULT_CODE
        )
    }

    //Starting another activity, whether one within my app or from another app,
    //  You can also start another activity and receive a result back through on activity result
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == Constants.SIGN_IN_RESULT_CODE) {
            val response = IdpResponse.fromResultIntent(data)
            if (resultCode == Activity.RESULT_OK) {
                // User successfully signed in
                Log.i(Constants.TAG, "Success >> signed in user ${FirebaseAuth.getInstance().currentUser?.displayName}!")
                Toast.makeText(this, "Success >>signed in", Toast.LENGTH_SHORT).show()
                startReminderActivity()

            } else {


                Log.i(Constants.TAG, "Sign in failed ${response?.error?.errorCode}")
                Toast.makeText(this, "Sign in failed", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun startReminderActivity() {
        val intent = Intent(this, RemindersActivity::class.java)
        startActivity(intent)
        finish()
    }


}
