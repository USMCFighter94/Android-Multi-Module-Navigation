package com.brevitz.navigationcomponenttest.feature.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.brevitz.navigationcomponenttest.App
import com.brevitz.navigationcomponenttest.R
import io.reactivex.rxkotlin.addTo
import javax.inject.Inject

class HomeFragment : Fragment() {
    @Inject
    lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerHomeComponent.builder()
            .coreComponent((context!!.applicationContext as App).coreComponent)
            .build()
            .inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(R.layout.fragment_home, container, false)

    override fun onResume() {
        super.onResume()
        viewModel.observe()
            .subscribe {}
            .addTo(viewModel.disposables)
    }
}
