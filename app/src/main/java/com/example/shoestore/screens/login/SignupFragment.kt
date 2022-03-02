package com.example.shoestore.screens.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.SignupFragmentBinding

class SignupFragment: Fragment() {

    lateinit var binding: SignupFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //Create the binding object that will
        //be used to access views
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.signup_fragment,
            container,
            false
        )

        //When the "don't have an account" link is pressed
        //replaces fragment with the loginFragment
        binding.signupSecondaryButton.setOnClickListener{
            replaceFragment(LoginFragment())
        }

        //When "Join" button is pressed
        //navigates to the welcome screen
        binding.signupPrimaryButton.setOnClickListener{

            findNavController().navigate(LoginContainerFragmentDirections.actionLoginContainerFragmentToWelcomeFragment())
        }

        //return the binding object
        return binding.root
    }

    /**
     * @method replaceFragment
     * @description sets the fragment to be displayed
     * @param {Fragment} fragment - the fragment to be displayed
     * @return void
     */
    private fun replaceFragment(fragment:Fragment){

        var fragmentManager = parentFragmentManager
        var fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.loginFragmentContainer,fragment)
        fragmentTransaction.commit()

    }
}