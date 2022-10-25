package com.example.shoestores.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.shoestores.R
import com.example.shoestores.databinding.FragmentShoeListBinding
import com.example.shoestores.databinding.ShoeItemBinding
import com.example.shoestores.model.Shoe
import com.example.shoestores.viewModel.ShoeViewModel


class ShoeListFragment : Fragment() {
    private lateinit var binding: FragmentShoeListBinding
    private val shoeViewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)


        binding.fabAddShoe.setOnClickListener {
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeInfoFragment())
        }

        shoeViewModel.getShoeLive().observe(viewLifecycleOwner) {
            it?.forEach { shoe ->
                binding.llShoeItem.addView(addView(shoe))

            }

        }


        return binding.root
    }


    private fun addView(shoe: Shoe): View {
        val itemShoeBinding = ShoeItemBinding.inflate(LayoutInflater.from(requireContext()), null, false)
        itemShoeBinding.shoe = shoe
        itemShoeBinding.executePendingBindings()
        return itemShoeBinding.root
    }


}