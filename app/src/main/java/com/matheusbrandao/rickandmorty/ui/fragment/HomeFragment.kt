package com.matheusbrandao.rickandmorty.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.matheusbrandao.rickandmorty.R
import com.matheusbrandao.rickandmorty.databinding.FragmentHomeBinding
import com.matheusbrandao.rickandmorty.presentation.character.CharacterListViewModel
import com.matheusbrandao.rickandmorty.ui.adapter.CharacterListAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private lateinit var viewDataBinding: FragmentHomeBinding
    private val viewModel by viewModel<CharacterListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        viewDataBinding = FragmentHomeBinding.bind(root).apply {
            viewModel = this@HomeFragment.viewModel
        }
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.lifecycleOwner = this.viewLifecycleOwner
        setupListAdapter()
        viewModel.getCharacters()

        activity!!.setTitle(R.string.label_title_character)
    }

    private fun setupListAdapter() {
        viewDataBinding.recyclerViewList.adapter = CharacterListAdapter(emptyList())
        viewDataBinding.recyclerViewList.layoutManager = GridLayoutManager(
            context, 2,
            GridLayoutManager.VERTICAL, false
        )
    }

}
