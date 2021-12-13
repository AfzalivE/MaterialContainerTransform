package com.afzaln.materialcontainertransformdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import androidx.navigation.Navigation
import androidx.navigation.Navigator
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.afzaln.materialcontainertransformdemo.databinding.FragmentFirstBinding
import com.afzaln.materialcontainertransformdemo.databinding.FragmentFirstNonsharedBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragmentNonShared : Fragment() {

    private var _binding: FragmentFirstNonsharedBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstNonsharedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fab.setOnClickListener {
            childFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.container, SecondFragment())
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}