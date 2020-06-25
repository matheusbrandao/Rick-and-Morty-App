package com.matheusbrandao.rickandmorty.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.matheusbrandao.rickandmorty.R
import com.matheusbrandao.rickandmorty.databinding.FragmentCharacterBinding
import com.matheusbrandao.rickandmorty.presentation.character.CharacterBinding
import com.matheusbrandao.rickandmorty.presentation.character.CharacterListViewModel
import com.matheusbrandao.rickandmorty.ui.adapter.CharacterListAdapter
import com.matheusbrandao.rickandmorty.ui.fragment.CharacterDetailFragment.Companion.ARG_CHARACTER_DATA
import com.matheusbrandao.rickandmorty.ui.utils.OnItemClickListener
import com.orgpick.dannypaginationlibrary.RecyclerScrollChangeListener
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterFragment : Fragment() {

    private lateinit var viewDataBinding: FragmentCharacterBinding
    private val viewModel by viewModel<CharacterListViewModel>()
    private lateinit var recyclerView: RecyclerView
    private var currentPage = 1

    private val onCharacterClickListener = object : OnItemClickListener<CharacterBinding> {
        override fun onItemClick(data: CharacterBinding) {
            val bundle = bundleOf(ARG_CHARACTER_DATA to data)
            findNavController().navigate(R.id.action_characterFragment_to_characterDetailFragment, bundle)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_character, container, false)
        viewDataBinding = FragmentCharacterBinding.bind(root).apply {
            viewModel = this@CharacterFragment.viewModel
        }
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.lifecycleOwner = this.viewLifecycleOwner
        setupListAdapter()
        viewModel.getCharacters(currentPage)

        activity!!.setTitle(R.string.label_title_character)
    }

    private fun setupListAdapter() {
        recyclerView = viewDataBinding.recyclerViewList
        recyclerView.adapter = CharacterListAdapter(emptyList(), onCharacterClickListener)
        recyclerView.layoutManager = GridLayoutManager(
            context, 2,
            GridLayoutManager.VERTICAL, false
        )

        recyclerView.addOnScrollListener(object : RecyclerScrollChangeListener() {
            override fun onLoadMore(page: Int, totalItemsCount: Int) {
                currentPage = page;
                viewModel.getCharacters(currentPage)
            }
        })
    }



}
