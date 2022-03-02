package com.example.shoestore.screens.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.DetailsFragmentBinding

class DetailsFragment: Fragment() {

    lateinit var binding: DetailsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //Create binding object that will be used to
        //access views
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.details_fragment,
            container,
            false
        )

        //When "Save" button is pressed
        //navigate back to the details view
        binding.detailsPrimaryButton.setOnClickListener{
            findNavController().navigate(DetailsFragmentDirections.actionDetailsDestinationToShoeListDestination())
        }

        //When "Cancel" button is pressed
        //navigate back to the details view
        binding.detailsSecondaryButton.setOnClickListener{
            findNavController().navigate(DetailsFragmentDirections.actionDetailsDestinationToShoeListDestination())
        }

        return binding.root
    }
}