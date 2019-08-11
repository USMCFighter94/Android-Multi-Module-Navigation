package com.brevitz.navigationcomponenttest.feature.subreddit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.brevitz.navigationcomponenttest.App
import com.brevitz.navigationcomponenttest.R
import com.brevitz.navigationcomponenttest.data.subreddit.SubRedditViewModel
import com.brevitz.navigationcomponenttest.domain.ViewState
import com.brevitz.navigationcomponenttest.feature.PostController
import com.brevitz.navigationcomponenttest.hide
import com.brevitz.navigationcomponenttest.show
import com.google.android.material.snackbar.Snackbar
import io.reactivex.rxkotlin.addTo
import kotlinx.android.synthetic.main.fragment_subreddit.*
import kotlinx.android.synthetic.main.layout_loading.*
import javax.inject.Inject

class SubRedditFragment : Fragment() {
    @Inject
    lateinit var viewModel: SubRedditViewModel
    private val controller = PostController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (context!!.applicationContext as App).coreComponent.inject(this)
        viewModel.subreddit = arguments?.getString("subreddit").orEmpty()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(R.layout.fragment_subreddit, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        subredditRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            isNestedScrollingEnabled = true
            adapter = controller.adapter
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL))
        }

        viewModel.getPosts()
    }

    override fun onResume() {
        super.onResume()
        viewModel.observe()
            .subscribe {
                when (it) {
                    is ViewState.Success -> {
                        controller.setData(it.data.children)
                        loadingLayout.hide()
                    }
                    is ViewState.Error -> {
                        Snackbar.make(
                            subredditRecyclerView,
                            it.error.localizedMessage.orEmpty(),
                            Snackbar.LENGTH_LONG
                        ).show()
                        loadingLayout.hide()
                    }
                    is ViewState.Loading -> loadingLayout.show()
                }
            }
            .addTo(viewModel.disposables)
    }

    override fun onPause() {
        super.onPause()
        viewModel.stop()
    }
}
