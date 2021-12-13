package com.afzaln.materialcontainertransformdemo.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.afzaln.materialcontainertransformdemo.R
import com.afzaln.materialcontainertransformdemo.applySystemWindowInsetsPadding
import com.afzaln.materialcontainertransformdemo.databinding.FragmentHomeBinding
import com.afzaln.materialcontainertransformdemo.doOnApplyWindowInsets
import com.google.android.material.transition.MaterialElevationScale
import com.google.android.material.transition.MaterialSharedAxis

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    private val emailViewModel: EmailViewModel by viewModels()

    private val emailAdapter = EmailAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.bottomAppBarContentContainer.applySystemWindowInsetsPadding(
            previousApplyLeft = false,
            previousApplyTop = false,
            previousApplyRight = false,
            previousApplyBottom = false,
            applyLeft = false,
            applyTop = false,
            applyRight = false,
            applyBottom = true
        )

        binding.fab.setOnClickListener {
            exitTransition = MaterialSharedAxis(MaterialSharedAxis.Z, false)
            reenterTransition = MaterialSharedAxis(MaterialSharedAxis.Z, true)

            findNavController().navigate(
                R.id.action_FirstFragment_to_SecondFragment,
                null,
                null,
                FragmentNavigatorExtras(binding.fab to getString(R.string.compose_transition_name))
            )
        }

        binding.emails.applySystemWindowInsetsPadding(
            previousApplyLeft = false,
            previousApplyTop = false,
            previousApplyRight = false,
            previousApplyBottom = false,
            applyLeft = false,
            applyTop = true,
            applyRight = false,
            applyBottom = true
        )
        binding.emails.adapter = emailAdapter

        emailViewModel.emails.observe(viewLifecycleOwner) { emailAdapter.submitList(it) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}