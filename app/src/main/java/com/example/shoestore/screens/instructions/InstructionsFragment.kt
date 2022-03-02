package com.example.shoestore.screens.instructions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.InstructionsFragmentBinding

class InstructionsFragment: Fragment() {

    lateinit var binding: InstructionsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //Create binding object that will be
        //used to access views
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.instructions_fragment,
            container,
            false
        )

        //When "next" button is pressed
        //navigates to "shoe list" fragment
        binding.instructionsButton.setOnClickListener{
            findNavController().navigate(InstructionsFragmentDirections.actionInstructionsDestinationToShoeListDestination())
        }

        //return binding object
        return binding.root
    }
}