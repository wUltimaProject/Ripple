package com.wultimaproject.ripple.presentation

/**
 * Created by Antonio Coppola on 06/11/2021.
 */

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.wultimaproject.ripple.presentation.screen.StateReaderScreen

class StateReaderFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = ComposeView(requireContext()).apply {
        setContent {
            StateReaderScreen(findNavController())
        }
    }
}
