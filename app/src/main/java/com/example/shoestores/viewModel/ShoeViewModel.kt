package com.example.shoestores.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestores.model.Shoe

class ShoeViewModel : ViewModel() {

    var _isValidShoe: MutableLiveData<Boolean> = MutableLiveData(false)

    private val _shoeItem = MutableLiveData<MutableList<Shoe>?>(mutableListOf())
    var newShoe = Shoe()


    // to add shoe
    fun addItem(shoe: Shoe) {
        _shoeItem.value?.add(shoe)
    }

    // clear newShoe after store it
    fun clearShoeData() {
        _isValidShoe.value = false
        newShoe = Shoe()

    }

    fun getShoeLive(): LiveData<MutableList<Shoe>?> {
        return _shoeItem
    }

    fun isValid(itmeData: String?): Boolean {
        return !itmeData.isNullOrEmpty()
    }

    // validation on shoe data
    fun correctInputNewShoe(): Boolean {
        return newShoe.let {

            isValid(it.company) &&
                    isValid(it.name) &&
                    isValid(it.description) &&
                    isValid(it.size)
        }

    }


}