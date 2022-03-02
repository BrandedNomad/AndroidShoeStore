package com.example.shoestore.screens.shoelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.shoestore.R
import com.example.shoestore.databinding.ShoelistFragmentBinding

class ShoeListFragment: Fragment() {

    lateinit var binding: ShoelistFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //Create binding that will be
        //used to access views
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.shoelist_fragment,
            container,
            false
        )

        binding.shoelistFab.setOnClickListener{
            //TODO
        }

        return binding.root
    }
}