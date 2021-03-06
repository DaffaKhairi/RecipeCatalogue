package com.daffakhairi.recipecatalogue.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.daffakhairi.recipecatalogue.adapter.RecipesAdapter
import com.daffakhairi.recipecatalogue.data.DataRecipe
import com.daffakhairi.recipecatalogue.data.Recipes
import com.daffakhairi.recipecatalogue.databinding.FragmentBreakfastBinding

class BreakfastFragment : Fragment() {


    private var _binding: FragmentBreakfastBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentBreakfastBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvBreakfast.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(activity, 2)
            adapter = RecipesAdapter(DataRecipe.listBreakfast)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}