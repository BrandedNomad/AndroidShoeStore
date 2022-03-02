package com.example.shoestore.screens.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.LoginFragmentBinding

class LoginFragment: Fragment() {

    lateinit var binding: LoginFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //Create the binding object that will
        //be used to access views
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.login_fragment,
            container,
            false
        )

        //When "need an account?" link is clicked
        //replaces fragment with signup fragment
        binding.loginSecondaryButton.setOnClickListener{
            replaceFragment(SignupFragment())
        }

        //When "login" button is pressed
        //navigates to the welcome screen
        binding.loginPrimaryButton.setOnClickListener{

            findNavController().navigate(LoginContainerFragmentDirections.actionLoginContainerFragmentToWelcomeFragment())
        }

        //returns binding object
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