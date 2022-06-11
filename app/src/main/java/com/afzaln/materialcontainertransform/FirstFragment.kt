package com.afzaln.materialcontainertransform

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.afzaln.materialcontainertransform.databinding.FragmentFirstBinding

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
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
