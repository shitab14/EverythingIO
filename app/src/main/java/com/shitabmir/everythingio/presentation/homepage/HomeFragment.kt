package com.shitabmir.everythingio.presentation.homepage

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shitabmir.everythingio.R
import com.shitabmir.everythingio.databinding.FragmentHomeBinding
import com.shitabmir.everythingio.base.BaseFragment

/**
 * Created by Shitab Mir on 2/22/24.
 * shitabmir@gmail.com
 **/
class HomeFragment: BaseFragment<FragmentHomeBinding>() {
    private val lifecycleTextSpannableBuilder = SpannableStringBuilder()

    override val layoutResourceId: Int
        get() = R.layout.fragment_home

    // ------------------------------ Fragment LifeCycle ------------------------------------------
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        updateFragmentLifeCycleText("\nonCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        updateFragmentLifeCycleText("\nonCreateView")

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateFragmentLifeCycleText("\nonViewCreated")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        updateFragmentLifeCycleText("\nonViewStateRestored")
    }

    override fun onStart() {
        super.onStart()
        updateFragmentLifeCycleText("\nonStart")
    }

    override fun onResume() {
        super.onResume()
        updateFragmentLifeCycleText("\nonResume")
    }

    override fun onPause() {
        super.onPause()
        updateFragmentLifeCycleText("\nonPause")
    }

    override fun onStop() {
        super.onStop()
        updateFragmentLifeCycleText("\nonStop")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        updateFragmentLifeCycleText("\nonSaveInstanceState")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        updateFragmentLifeCycleText("\nonDestroyView")
    }
    override fun onDestroy() {
        super.onDestroy()
        updateFragmentLifeCycleText("\nonDestroy")
    }



    // ------------------------------------ My Methods --------------------------------------------
    private fun updateFragmentLifeCycleText(text: String) {
        lifecycleTextSpannableBuilder.setSpan(ForegroundColorSpan(Color.DKGRAY), 0, lifecycleTextSpannableBuilder.length, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
        lifecycleTextSpannableBuilder.insert(0, text)
        lifecycleTextSpannableBuilder.setSpan(ForegroundColorSpan(Color.GREEN), 0, text.length, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
        binding.tvFragmentLifecycleTrack.text = lifecycleTextSpannableBuilder

        binding.nestedScrollViewFragment.fullScroll(View.FOCUS_UP)
    }

}