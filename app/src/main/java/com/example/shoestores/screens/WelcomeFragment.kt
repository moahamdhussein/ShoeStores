package com.example.shoestores.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.shoestores.R
import com.example.shoestores.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentWelcomeBinding>(inflater ,R.layout.fragment_welcome , container ,false )

        binding.btnGetStarted.setOnClickListener {
            findNavController().navigate(WelcomeFragmentDirections.actionWelcomToInstruction())
        }
        return binding.root
    }


}