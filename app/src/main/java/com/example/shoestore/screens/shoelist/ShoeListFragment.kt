package com.example.shoestore.screens.shoelist

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import android.view.View.TEXT_ALIGNMENT_CENTER
import android.widget.TextView
import androidx.core.view.marginTop
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavArgs
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.shoestore.R
import com.example.shoestore.databinding.ShoelistFragmentBinding
import com.example.shoestore.models.Shoe

class ShoeListFragment: Fragment() {

    lateinit var binding: ShoelistFragmentBinding
    lateinit var viewModel: ShoeListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //ViewModel
        viewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)


        //Create binding that will be
        //used to access views
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.shoelist_fragment,
            container,
            false
        )


        binding.shoelistFab.setOnClickListener{
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListDestinationToDetailsDestination())
        }

        //Add shoe
        val args = ShoeListFragmentArgs.fromBundle(requireArguments())
        addShoe(args)

        viewModel.shoesToDisplay.observe(viewLifecycleOwner, Observer{ newList ->

            createListView(newList)

        })


        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

    private fun addItemToView(item:Shoe){
        //Create TextView
        val newView = TextView(this.context)
        newView.textAlignment = TEXT_ALIGNMENT_CENTER
        newView.setPadding(8,16,8,8)
        newView.textSize = 20F

        //Create Spacer
        val spacerView = TextView(this.context)
        spacerView.textAlignment = TEXT_ALIGNMENT_CENTER

        //Create string to display
        val name = item.name
        val size = item.size
        val description = item.description
        val company = item.company
        val stringToDisplay = "Size $size $name by $company. $description"

        //Add to view
        newView.text = stringToDisplay
        binding.shoeListViewInner.addView(newView)

        spacerView.text = "__________"
        binding.shoeListViewInner.addView(spacerView)
    }

    private fun createListView(shoeList:MutableList<Shoe>){
        for(shoe in shoeList){
            addItemToView(shoe)
        }
    }

    private fun addShoe(args: ShoeListFragmentArgs){
        if(args.shoe is Shoe){
            viewModel.addShoe(args.shoe!!)
        }
    }


}