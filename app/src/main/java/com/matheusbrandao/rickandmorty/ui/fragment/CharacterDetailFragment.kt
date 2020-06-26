package com.matheusbrandao.rickandmorty.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.matheusbrandao.rickandmorty.R
import com.matheusbrandao.rickandmorty.databinding.FragmentCharacterDetailBinding
import com.matheusbrandao.rickandmorty.presentation.character.CharacterBinding
import kotlinx.android.synthetic.main.activity_main.view.*

class CharacterDetailFragment : Fragment() {

    companion object {
        const val ARG_CHARACTER_DATA = "characterData"
    }

    private lateinit var viewDataBinding: FragmentCharacterDetailBinding
    private var characterData: CharacterBinding? = null
    private lateinit var bottomNavViewMain: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            characterData = it.getSerializable(ARG_CHARACTER_DATA) as CharacterBinding?
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_character_detail, container, false)
        viewDataBinding = FragmentCharacterDetailBinding.bind(root).apply {
            character = characterData
        }
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.lifecycleOwner = this.viewLifecycleOwner

        setupBottomNav(view)
        setupActionBar()
    }

    override fun onDestroy() {
        super.onDestroy()
        bottomNavViewMain.visibility = View.VISIBLE
    }

    private fun setupActionBar() {
        activity!!.title = characterData?.name
    }

    private fun setupBottomNav(view: View) {
        bottomNavViewMain = view.rootView.bottomNavView_main
        bottomNavViewMain.visibility = View.GONE
    }

}