package com.example.shoestores.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.shoestores.R
import com.example.shoestores.databinding.FragmentShoeInfoBinding
import com.example.shoestores.viewModel.ShoeViewModel


class ShoeInfoFragment : Fragment() {
    private lateinit var binding: FragmentShoeInfoBinding
    private val shoeViewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_info, container, false)

        binding.shoeVM = shoeViewModel
        binding.lifecycleOwner = this


        binding.btnSave.setOnClickListener {

            shoeViewModel._isValidShoe.value = true

            if (shoeViewModel.correctInputNewShoe()) {
                shoeViewModel.newShoe.apply {
                    println(shoeViewModel.getShoeLive().value)
                    println(shoeViewModel.newShoe)
                    shoeViewModel.addItem(shoe = this)
                    it.findNavController()
                        .navigate(ShoeInfoFragmentDirections.actionShoeInfoFragmentToShoeListFragment())

                    clearErrorState()
                }
            }
             else {
                showCheckError()
            }
        }

        return binding.root

    }

    private fun showCheckError(): Boolean {
        clearErrorState()
        var check = true
        if (!shoeViewModel.isValid(shoeViewModel.newShoe.name)) {
            binding.tilShoeName.error = "shoe name must not be empty"
            binding.tilShoeName.isErrorEnabled = true
            check = false
        }
        if (!shoeViewModel.isValid(shoeViewModel.newShoe.description)) {
            binding.tilDescription.error = "description must not be empty"
            binding.tilDescription.isErrorEnabled = true
            check = false
        }
        if (!shoeViewModel.isValid(shoeViewModel.newShoe.company)) {
            binding.tilCompany.error = "company name must not be empty"
            binding.tilCompany.isErrorEnabled = true
            check = false
        }
        if (!shoeViewModel.isValid(shoeViewModel.newShoe.size)) {
            binding.tilShoeSize.error = "size must be over than 0 "
            binding.tilShoeSize.isErrorEnabled = true
            check = false
        }
        return check
    }


    private fun clearErrorState() {

        binding.tilShoeName.error = null
        binding.tilShoeName.isErrorEnabled = false

        binding.tilCompany.error = null
        binding.tilCompany.isErrorEnabled = false

        binding.tilDescription.error = null
        binding.tilDescription.isErrorEnabled = false

        binding.tilShoeSize.error = null
        binding.tilShoeSize.isErrorEnabled = false

    }

    override fun onDestroy() {
        super.onDestroy()
        shoeViewModel.clearShoeData()
    }

    override fun onStop() {
        super.onStop()
        shoeViewModel.clearShoeData()
    }

}