package com.afzaln.materialcontainertransform

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds

class MainViewModel : ViewModel() {

    private val initialThresholdsState = ThresholdsState(
        ProgressThresholds(0f, 0.25f),
        ProgressThresholds(0.25f, 0.5f),
        ProgressThresholds(0.5f, 0.75f),
        ProgressThresholds(0.75f, 1f)
    )

    val thresholdsState = MutableLiveData(initialThresholdsState)

    fun updateFadeThresholds(start: Float, end: Float) {
        thresholdsState.value = thresholdsState.value?.copy(
            fadeProgressThresholds = ProgressThresholds(
                start,
                end
            )
        )
    }

    fun updateScaleMaskThresholds(start: Float, end: Float) {
        thresholdsState.value = thresholdsState.value?.copy(
            scaleMaskProgressThresholds = ProgressThresholds(
                start,
                end
            )
        )
    }

    fun updateScaleProgressThresholds(start: Float, end: Float) {
        thresholdsState.value = thresholdsState.value?.copy(
            scaleProgressThresholds = ProgressThresholds(
                start,
                end
            )
        )
    }

    fun updateShapeMaskThresholds(start: Float, end: Float) {
        thresholdsState.value = thresholdsState.value?.copy(
            shapeMaskProgressThresholds = ProgressThresholds(
                start,
                end
            )
        )
    }

    fun resetThresholds() {
        thresholdsState.value = initialThresholdsState
    }
}

data class ThresholdsState(
    val fadeProgressThresholds: ProgressThresholds,
    val scaleMaskProgressThresholds: ProgressThresholds,
    val scaleProgressThresholds: ProgressThresholds,
    val shapeMaskProgressThresholds: ProgressThresholds
)
