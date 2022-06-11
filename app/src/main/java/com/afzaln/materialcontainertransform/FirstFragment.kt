package com.afzaln.materialcontainertransform

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.afzaln.materialcontainertransform.databinding.FragmentFirstBinding
import com.google.android.material.transition.MaterialContainerTransform
import com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val mainViewModel: MainViewModel by activityViewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModel()

        binding.fadeThreshold.addOnChangeListener { slider, _, _ ->
            mainViewModel.updateFadeThresholds(slider.values[0], slider.values[1])
        }

        binding.scaleMaskThreshold.addOnChangeListener { slider, _, _ ->
            mainViewModel.updateScaleMaskThresholds(slider.values[0], slider.values[1])
        }

        binding.scaleThreshold.addOnChangeListener { slider, _, _ ->
            mainViewModel.updateScaleProgressThresholds(slider.values[0], slider.values[1])
        }

        binding.shapeMaskThreshold.addOnChangeListener { slider, _, _ ->
            mainViewModel.updateShapeMaskThresholds(slider.values[0], slider.values[1])
        }

        binding.fab.setOnClickListener {
            findNavController()
                .navigate(
                    R.id.action_FirstFragment_to_SecondFragment,
                    null,
                    null,
                    FragmentNavigatorExtras(
                        binding.fab to getString(R.string.second_transition_name)
                    )
                )
        }
    }

    private fun setupViewModel() {
        mainViewModel.thresholdsState.observe(viewLifecycleOwner) {
            binding.fadeThreshold.values = it.fadeProgressThresholds.values()
            binding.scaleMaskThreshold.values = it.scaleMaskProgressThresholds.values()
            binding.scaleThreshold.values = it.scaleProgressThresholds.values()
            binding.shapeMaskThreshold.values = it.shapeMaskProgressThresholds.values()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

private fun ProgressThresholds.values() = listOf(start * 100, end * 100)
