package com.example.shoestore.screens.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.shoestore.R
import com.example.shoestore.databinding.LoginContainerFragmentBinding

class LoginContainerFragment: Fragment() {

    lateinit var binding: LoginContainerFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //Create the binding object that will
        //be used to access views
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.login_container_fragment,
            container,
            false
        )

        //Set the fragment to be displayed
        replaceFragment(LoginFragment())



        //Return the binding object
        return binding.root
    }

    /**
     * @method replaceFragment
     * @description sets the fragment to be displayed
     * @param {Fragment} fragment - the fragment to be displayed
     * @return void
     */
    private fun replaceFragment(fragment:Fragment){

        var fragmentManager = childFragmentManager
        var fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.loginFragmentContainer,fragment)
        fragmentTransaction.commit()

    }
}