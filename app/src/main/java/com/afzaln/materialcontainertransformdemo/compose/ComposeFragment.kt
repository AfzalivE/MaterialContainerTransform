package com.afzaln.materialcontainertransformdemo.compose

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.afzaln.materialcontainertransformdemo.applySystemWindowInsetsPadding
import com.afzaln.materialcontainertransformdemo.databinding.FragmentComposeBinding
import com.afzaln.materialcontainertransformdemo.themeColor
import com.google.android.material.transition.MaterialContainerTransform
import com.google.android.material.transition.MaterialContainerTransform.FADE_MODE_CROSS

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ComposeFragment : Fragment() {

    private var _binding: FragmentComposeBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    private val composeViewModel: ComposeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentComposeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        composeViewModel.currentAccount.observe(viewLifecycleOwner) {
            binding.senderEditText.setText(it.first().email)
        }

        binding.composeConstraintLayout.applySystemWindowInsetsPadding(
            previousApplyLeft = false,
            previousApplyTop = false,
            previousApplyRight = false,
            previousApplyBottom = false,
            applyLeft = false,
            applyTop = true,
            applyRight = false,
            applyBottom = true
        )

        sharedElementEnterTransition = MaterialContainerTransform().apply {
            fadeMode = FADE_MODE_CROSS
            setAllContainerColors(requireContext().themeColor(com.google.android.material.R.attr.colorSurface))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}