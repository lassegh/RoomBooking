package dk.lgr.roombooking

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import com.google.android.material.snackbar.Snackbar
import dk.lgr.roombooking.databinding.ActivityMainBinding
import dk.lgr.roombooking.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // layout / xml inflates
        val mBinding:ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // viewmodel sættes
        val mainViewModel = MainViewModel(this)
        mBinding.viewModel = mainViewModel

    }
}
