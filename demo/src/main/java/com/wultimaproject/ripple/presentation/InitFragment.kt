package com.wultimaproject.ripple.presentation

/**
 * Created by Antonio Coppola on 06/11/2021.
 */

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.wultimaproject.ripple.R
import com.wultimaproject.ripple.presentation.screen.IntroScreen

class InitFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = ComposeView(requireContext()).apply {
        setContent {
            IntroScreen {
                findNavController().navigate(R.id.action_initFragment_to_listFragment)
            }
        }
    }
}
