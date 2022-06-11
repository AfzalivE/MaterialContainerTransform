package com.afzaln.materialcontainertransform

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.getFloatOrThrow
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import com.afzaln.materialcontainertransform.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.apply {
            setTitle(R.string.app_name)
            inflateMenu(R.menu.menu_main)
            setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.action_reset -> {
                        resetThresholds()
                        true
                    }
                    else -> super.onOptionsItemSelected(item)
                }
            }
        }

        resetThresholds()

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
    }

    @SuppressLint("ResourceType")
    private fun resetThresholds() {
        resources.obtainTypedArray(R.array.initial_slider_values).use { initialValues ->
            val start = initialValues.getFloatOrThrow(0)
            val end = initialValues.getFloatOrThrow(1)
            viewModel.updateAll(start, end)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
            || super.onSupportNavigateUp()
    }
}
