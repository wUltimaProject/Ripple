package com.wultimaproject.ripple.presentation

/**
 * Created by Antonio Coppola on 06/11/2021.
 */

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.wultimaproject.ripple.presentation.screen.ListScreen

class ListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = ComposeView(requireContext()).apply {
        setContent {
            ListScreen()
        }
    }
}
