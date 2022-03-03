package com.example.shoestore.screens.shoelist



import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestore.models.Shoe
import com.example.shoestore.models.listOfShoes

class ShoeListViewModel: ViewModel() {


    private var _shoesToDisplay = MutableLiveData<MutableList<Shoe>>()
    val shoesToDisplay: LiveData<MutableList<Shoe>>
        get() = _shoesToDisplay

    init{
        _shoesToDisplay.value = listOfShoes

    }

    fun addShoe(shoe:Shoe){
        shoesToDisplay.value!!.add(shoe)
    }

    fun getShoesToDisplay():MutableList<Shoe>?{

        var listOfShoesToDisplay:MutableList<Shoe>? = shoesToDisplay.value

        return listOfShoesToDisplay
    }



    override fun onCleared() {
        super.onCleared()
    }


}