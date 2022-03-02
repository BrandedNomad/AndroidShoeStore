package com.example.shoestore.screens.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.WelcomeFragmentBinding


class WelcomeFragment: Fragment() {

    lateinit var binding: WelcomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //Create the binding object that will be
        //used to access views
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.welcome_fragment,
            container,
            false
        )

        //When the "next" button is clicked
        //navigates to the "instructions" fragment
        binding.welcomeButton.setOnClickListener{
            findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToInstructionsFragment())
        }

        //return the binding object
        return binding.root
    }
}