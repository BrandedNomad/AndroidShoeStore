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
import com.example.shoestore.models.Shoe

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
            val name = if(binding.detailsShoeName.text.toString() != "") binding.detailsShoeName.text.toString() else null
            val size = binding.detailsShoeSize.text.toString().toDoubleOrNull()
            val company = if(binding.detailsCompanyName.text.toString() != "") binding.detailsCompanyName.text.toString() else null
            val description = if(binding.detailsDescription.text.toString() != "") binding.detailsDescription.text.toString() else null

            if(name == null || size == null || company == null || description == null){

            } else {
                val shoe:Shoe = Shoe(name,size,company,description)
                findNavController().navigate(DetailsFragmentDirections.actionDetailsDestinationToShoeListDestination(shoe))
            }


        }

        //When "Cancel" button is pressed
        //navigate back to the details view
        binding.detailsSecondaryButton.setOnClickListener{
            findNavController().navigate(DetailsFragmentDirections.actionDetailsDestinationToShoeListDestination(null))
        }

        return binding.root
    }


}