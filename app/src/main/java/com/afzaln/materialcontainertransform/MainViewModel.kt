package com.afzaln.materialcontainertransform

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds

class MainViewModel : ViewModel() {

    private val staggeredThresholdsState = ThresholdsState(
        ProgressThresholds(0f, 0.25f),
        ProgressThresholds(0.25f, 0.5f),
        ProgressThresholds(0.5f, 0.75f),
        ProgressThresholds(0.75f, 1f)
    )

    private val prototypeEnterThresholdsState = ThresholdsState(
        ProgressThresholds(0f, 0.295f),
        ProgressThresholds(0.154f, 1f),
        ProgressThresholds(0.154f, 1f),
        ProgressThresholds(0.8f, 1f)
    )

    val prototypeReturnThresholdsState = ThresholdsState(
        ProgressThresholds(0.705f, 1f),
        ProgressThresholds(0f, 0.846f),
        ProgressThresholds(0f, 0.846f),
        ProgressThresholds(0f, 0.2f)
    )

    val thresholdsState = MutableLiveData(prototypeEnterThresholdsState)

    fun updateFadeThresholds(start: Float, end: Float) {
        thresholdsState.value = thresholdsState.value?.copy(
            fadeProgressThresholds = ProgressThresholds(start, end)
        )
    }

    fun updateScaleMaskThresholds(start: Float, end: Float) {
        thresholdsState.value = thresholdsState.value?.copy(
            scaleMaskProgressThresholds = ProgressThresholds(start, end)
        )
    }

    fun updateScaleProgressThresholds(start: Float, end: Float) {
        thresholdsState.value = thresholdsState.value?.copy(
            scaleProgressThresholds = ProgressThresholds(start, end)
        )
    }

    fun updateShapeMaskThresholds(start: Float, end: Float) {
        thresholdsState.value = thresholdsState.value?.copy(
            shapeMaskProgressThresholds = ProgressThresholds(start, end)
        )
    }

    fun resetThresholds() {
        thresholdsState.value = prototypeEnterThresholdsState
    }
}

data class ThresholdsState(
    val fadeProgressThresholds: ProgressThresholds,
    val scaleMaskProgressThresholds: ProgressThresholds,
    val scaleProgressThresholds: ProgressThresholds,
    val shapeMaskProgressThresholds: ProgressThresholds
)
