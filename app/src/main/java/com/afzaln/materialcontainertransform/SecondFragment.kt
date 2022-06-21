package com.afzaln.materialcontainertransform

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.PathInterpolator
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.transition.Transition
import androidx.transition.TransitionListenerAdapter
import com.google.android.material.shape.ShapeAppearanceModel
import com.google.android.material.transition.MaterialContainerTransform

class SecondFragment : Fragment() {

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_second, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val thresholdsState = viewModel.thresholdsState.value!!

        // Shape of the quick add container. In API 24, it's possible to obtain this from the
        // background drawable itself but minSdk is 23 right now.
        val containerShape = ShapeAppearanceModel.builder()
            .setTopLeftCornerSize(resources.getDimension(R.dimen.second_container_radius))
            .setTopRightCornerSize(resources.getDimension(R.dimen.second_container_radius))
            .build()

        sharedElementEnterTransition = MaterialContainerTransform().apply {
            duration = 3000
            interpolator = pathInterpolator
            fadeMode = MaterialContainerTransform.FADE_MODE_CROSS
            fadeProgressThresholds = thresholdsState.fadeProgressThresholds
            scaleMaskProgressThresholds = thresholdsState.scaleMaskProgressThresholds
            scaleProgressThresholds = thresholdsState.scaleProgressThresholds
            shapeMaskProgressThresholds = thresholdsState.shapeMaskProgressThresholds
            endShapeAppearanceModel = containerShape
            startContainerColor = requireContext().resources.getColor(R.color.fab)
            endContainerColor = requireContext().resources.getColor(R.color.fab)
            containerColor = requireContext().resources.getColor(R.color.fab)
            scrimColor = requireContext().resources.getColor(R.color.background_dark_transparent)
            addListener(object : TransitionListenerAdapter() {
                override fun onTransitionEnd(transition: Transition) {
                    super.onTransitionEnd(transition)
                    view.setBackgroundResource(R.color.background_dark_transparent)
                    requireActivity().findViewById<View>(R.id.appbar)
                        .setBackgroundResource(R.color.background_dark_transparent)
                }
            })
        }

        sharedElementReturnTransition = MaterialContainerTransform().apply {
            duration = 3000
            transitionDirection = MaterialContainerTransform.TRANSITION_DIRECTION_RETURN
            fadeMode = MaterialContainerTransform.FADE_MODE_CROSS
            fadeProgressThresholds = thresholdsState.fadeProgressThresholds
            scaleMaskProgressThresholds = thresholdsState.scaleMaskProgressThresholds
            scaleProgressThresholds = thresholdsState.scaleProgressThresholds
            shapeMaskProgressThresholds = thresholdsState.shapeMaskProgressThresholds
            scrimColor = requireContext().resources.getColor(R.color.background_dark_transparent)
            endContainerColor = requireContext().resources.getColor(R.color.fab)
            addListener(object : TransitionListenerAdapter() {
                override fun onTransitionStart(transition: Transition) {
                    super.onTransitionStart(transition)
                    view.setBackgroundColor(
                        requireContext().themeColor(com.google.android.material.R.attr.colorSurface)
                    )
                    requireActivity().findViewById<View>(R.id.appbar).setBackgroundColor(
                        requireContext().themeColor(com.google.android.material.R.attr.colorSurface)
                    )
                }
            })
        }
    }

    val pathInterpolator = PathInterpolator(0.25f, 0.1f, 0.25f, 1f)
}
