package dk.lgr.roombooking.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import dk.lgr.roombooking.R
import dk.lgr.roombooking.databinding.ActivityLoginBinding
import dk.lgr.roombooking.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mBinding:ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        val viewModel = LoginViewModel(this)
        mBinding.viewModel = viewModel
    }
}
