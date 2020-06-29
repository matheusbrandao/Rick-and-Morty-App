package com.matheusbrandao.rickandmorty.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.matheusbrandao.rickandmorty.R
import com.matheusbrandao.rickandmorty.databinding.FragmentEpisodeBinding
import com.matheusbrandao.rickandmorty.presentation.episode.EpisodeListViewModel
import com.matheusbrandao.rickandmorty.ui.adapter.EpisodeListAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class EpisodeFragment : Fragment() {

    private lateinit var viewDataBinding: FragmentEpisodeBinding
    private val viewModel by viewModel<EpisodeListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_episode, container, false)
        viewDataBinding = FragmentEpisodeBinding.bind(root).apply {
            viewModel = this@EpisodeFragment.viewModel
        }
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.lifecycleOwner = this.viewLifecycleOwner
        setupListAdapter()
        viewModel.getEpisodes()

        setupActionBar()
        subscribeToError()
    }

    private fun subscribeToError() {
        viewModel.errorEvent.observe(activity!!, Observer {
            it.getContentIfNotHandled()?.let { errorMessage ->
                Toast.makeText(activity!!, errorMessage.toString(), Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun setupActionBar() {
        activity!!.setTitle(R.string.label_title_episode)
    }

    private fun setupListAdapter() {
        viewDataBinding.recyclerViewList.adapter = EpisodeListAdapter(emptyList())
        viewDataBinding.recyclerViewList.layoutManager = LinearLayoutManager(
            context, LinearLayoutManager.VERTICAL, false
        )
    }

}
