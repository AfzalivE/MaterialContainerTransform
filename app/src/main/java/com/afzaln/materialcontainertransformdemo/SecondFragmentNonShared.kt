package com.afzaln.materialcontainertransformdemo

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.afzaln.materialcontainertransformdemo.databinding.FragmentSecondBinding
import com.google.android.material.transition.MaterialContainerTransform
import com.google.android.material.transition.MaterialContainerTransform.FADE_MODE_CROSS
import com.google.android.material.transition.MaterialContainerTransform.FADE_MODE_OUT

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragmentNonShared : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        enterTransition = MaterialContainerTransform().apply {
            // startView = requireActivity().findViewById(R.id.mainFab)
            endView = binding.root
            drawingViewId = R.id.nav_host_fragment_content_main
            scrimColor = Color.TRANSPARENT
            fadeMode = FADE_MODE_CROSS
            containerColor = requireContext().themeColor(com.google.android.material.R.attr.colorSurface)
            startContainerColor = requireContext().themeColor(com.google.android.material.R.attr.colorSecondary)
            endContainerColor = requireContext().themeColor(com.google.android.material.R.attr.colorSurface)
        }

        returnTransition = MaterialContainerTransform().apply {
            startView = binding.root
            // endView = requireActivity().findViewById(R.id.mainFab)
            addTarget(binding.root)
            drawingViewId = R.id.nav_host_fragment_content_main
            scrimColor = Color.TRANSPARENT
            fadeMode = FADE_MODE_CROSS
            containerColor = requireContext().themeColor(com.google.android.material.R.attr.colorSurface)
            startContainerColor = requireContext().themeColor(com.google.android.material.R.attr.colorSecondary)
            endContainerColor = requireContext().themeColor(com.google.android.material.R.attr.colorSurface)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}