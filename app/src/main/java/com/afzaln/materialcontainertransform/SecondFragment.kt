package com.afzaln.materialcontainertransform

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.google.android.material.transition.MaterialContainerTransform

class SecondFragment : Fragment() {

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val thresholdsState = viewModel.thresholdsState.value!!

        sharedElementEnterTransition = MaterialContainerTransform().apply {
            fadeMode = MaterialContainerTransform.FADE_MODE_CROSS
            fadeProgressThresholds = thresholdsState.fadeProgressThresholds
            scaleMaskProgressThresholds = thresholdsState.scaleMaskProgressThresholds
            scaleProgressThresholds = thresholdsState.scaleProgressThresholds
            shapeMaskProgressThresholds = thresholdsState.shapeMaskProgressThresholds
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         */
        @JvmStatic
        fun newInstance() = SecondFragment()
    }
}
