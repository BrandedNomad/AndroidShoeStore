package com.example.shoestore.screens.instructions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
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

        return binding.root
    }
}