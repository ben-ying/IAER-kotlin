package com.yjh.iaer.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.yjh.iaer.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by lazy {
        ViewModelProvider(this).get(HomeViewModel::class.java)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val binding = FragmentHomeBinding.inflate(inflater)
        binding.viewModel = homeViewModel
        homeViewModel.loginUser.observe(viewLifecycleOwner, { loginUser ->
            if (loginUser != null) {
                Toast.makeText(context, "Show list", Toast.LENGTH_SHORT).show()
            } else {
                findNavController().navigate(HomeFragmentDirections.actionNavHomeToLoginFragment())
            }
        })

        return binding.root
    }
}