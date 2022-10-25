package com.example.shoestores.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.shoestores.R
import com.example.shoestores.databinding.FragmentInstructionBinding

class InstructionFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentInstructionBinding>(inflater , R.layout.fragment_instruction,container,false)

        binding.btnDetails.setOnClickListener {
            findNavController().navigate(InstructionFragmentDirections.actionInstructionToShoeList())
        }
        return binding.root
    }

}