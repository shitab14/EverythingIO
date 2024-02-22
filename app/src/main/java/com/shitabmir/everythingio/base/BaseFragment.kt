package com.shitabmir.everythingio.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

/**
 * Created by Shitab Mir on 2/22/24.
 * shitabmir@gmail.com
 **/
abstract class BaseFragment<DataBinding: ViewDataBinding> : Fragment(){

    private var _binding: DataBinding? = null
    val binding get() = _binding!!

    @get:LayoutRes
    abstract val layoutResourceId: Int

    override fun onAttach(context: Context) {
        // AndroidSupportInjection.inject(getFragment())
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, layoutResourceId, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun getFragment(): Fragment = this
}