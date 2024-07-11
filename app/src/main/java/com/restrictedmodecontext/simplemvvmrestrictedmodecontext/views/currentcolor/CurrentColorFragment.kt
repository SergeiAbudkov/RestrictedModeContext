package com.restrictedmodecontext.simplemvvmrestrictedmodecontext.views.currentcolor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.restrictedmodecontext.databinding.FragmentCurrentColorBinding
import com.restrictedmodecontext.foundation.views.BaseFragment
import com.restrictedmodecontext.foundation.views.BaseScreen
import com.restrictedmodecontext.foundation.views.screenViewModel
import com.restrictedmodecontext.simplemvvmrestrictedmodecontext.views.onTryAgain
import com.restrictedmodecontext.simplemvvmrestrictedmodecontext.views.renderSimpleResult

class CurrentColorFragment : BaseFragment() {
    private lateinit var binding: FragmentCurrentColorBinding

    // no arguments for this screen
    class Screen : BaseScreen

    override val viewModel by screenViewModel<CurrentColorViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCurrentColorBinding.inflate(layoutInflater, container, false)
        viewModel.currentColor.observe(viewLifecycleOwner) { result ->
            renderSimpleResult(
                binding.root,
                result = result,
                onSuccess = {
                    binding.colorView.setBackgroundColor(it.value)
                })

        }
        binding.changeColorButton.setOnClickListener {
            viewModel.changeColor()
        }
        binding.askPermissionsButton.setOnClickListener {
            viewModel.requestPermission()
        }

        onTryAgain(binding.root) {
            viewModel.tryAgain()
        }

        return binding.root
    }


}
