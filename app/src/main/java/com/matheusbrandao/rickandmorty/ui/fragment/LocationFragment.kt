package com.matheusbrandao.rickandmorty.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.matheusbrandao.rickandmorty.R
import com.matheusbrandao.rickandmorty.databinding.FragmentLocationBinding
import com.matheusbrandao.rickandmorty.presentation.location.LocationListViewModel
import com.matheusbrandao.rickandmorty.ui.adapter.LocationListAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class LocationFragment : Fragment() {

    private lateinit var viewDataBinding: FragmentLocationBinding
    private val viewModel by viewModel<LocationListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_location, container, false)
        viewDataBinding = FragmentLocationBinding.bind(root).apply {
            viewModel = this@LocationFragment.viewModel
        }
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.lifecycleOwner = this.viewLifecycleOwner
        setupListAdapter()
        viewModel.getLocations()

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
        activity!!.setTitle(R.string.label_title_location)
    }

    private fun setupListAdapter() {
        viewDataBinding.recyclerViewList.adapter = LocationListAdapter(emptyList())
        viewDataBinding.recyclerViewList.layoutManager = GridLayoutManager(
            context, 2,
            GridLayoutManager.VERTICAL, false
        )
    }
}
