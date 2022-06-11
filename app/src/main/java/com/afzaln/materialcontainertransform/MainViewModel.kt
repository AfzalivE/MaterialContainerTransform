package com.afzaln.materialcontainertransform

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds

class MainViewModel : ViewModel() {
    val thresholdsState = MutableLiveData(
        ThresholdsState(
            ProgressThresholds(0f, 1f),
            ProgressThresholds(0f, 1f),
            ProgressThresholds(0f, 1f),
            ProgressThresholds(0f, 1f)
        )
    )

    fun updateAll(start: Float, end: Float) {
        val initial = ProgressThresholds(start / 100, end / 100)
        thresholdsState.value = ThresholdsState(initial, initial, initial, initial)
    }

    fun updateFadeThresholds(start: Float, end: Float) {
        thresholdsState.value = thresholdsState.value?.copy(
            fadeProgressThresholds = ProgressThresholds(
                start / 100,
                end / 100
            )
        )
    }

    fun updateScaleMaskThresholds(start: Float, end: Float) {
        thresholdsState.value = thresholdsState.value?.copy(
            scaleMaskProgressThresholds = ProgressThresholds(
                start / 100,
                end / 100
            )
        )
    }

    fun updateScaleProgressThresholds(start: Float, end: Float) {
        thresholdsState.value = thresholdsState.value?.copy(
            scaleProgressThresholds = ProgressThresholds(
                start / 100,
                end / 100
            )
        )
    }

    fun updateShapeMaskThresholds(start: Float, end: Float) {
        thresholdsState.value = thresholdsState.value?.copy(
            shapeMaskProgressThresholds = ProgressThresholds(
                start / 100,
                end / 100
            )
        )
    }
}

data class ThresholdsState(
    val fadeProgressThresholds: ProgressThresholds,
    val scaleMaskProgressThresholds: ProgressThresholds,
    val scaleProgressThresholds: ProgressThresholds,
    val shapeMaskProgressThresholds: ProgressThresholds
)
