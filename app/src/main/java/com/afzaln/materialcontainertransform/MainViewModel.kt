package com.afzaln.materialcontainertransform

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.material.transition.MaterialContainerTransform.ProgressThresholds

class MainViewModel : ViewModel() {
    val fadeProgressThresholds = MutableLiveData<ProgressThresholds>()
    val scaleMaskProgressThresholds = MutableLiveData<ProgressThresholds>()
    val scaleProgressThresholds = MutableLiveData<ProgressThresholds>()
    val shapeMaskProgressThresholds = MutableLiveData<ProgressThresholds>()

    fun updateFadeThresholds(start: Float, end: Float) {
        fadeProgressThresholds.value = ProgressThresholds(start / 100, end / 100)
    }

    fun updateScaleMaskThresholds(start: Float, end: Float) {
        scaleMaskProgressThresholds.value = ProgressThresholds(start / 100, end / 100)
    }

    fun updateScaleProgressThresholds(start: Float, end: Float) {
        scaleProgressThresholds.value = ProgressThresholds(start / 100, end / 100)
    }

    fun updateShapeMaskThresholds(start: Float, end: Float) {
        shapeMaskProgressThresholds.value = ProgressThresholds(start / 100, end / 100)
    }
}
