package dk.lgr.roombooking.view

import android.os.Bundle
import android.text.TextUtils.split
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import dk.lgr.roombooking.R
import dk.lgr.roombooking.databinding.ActivityMainBinding
import dk.lgr.roombooking.databinding.ContentMainBinding
import dk.lgr.roombooking.viewmodel.MainViewModel
import dk.lgr.roombooking.viewmodel.adapter.BookingAdapter

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
