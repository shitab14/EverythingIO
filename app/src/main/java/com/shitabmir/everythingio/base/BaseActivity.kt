package com.shitabmir.everythingio.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.shitabmir.everythingio.R
import kotlin.properties.Delegates

/**
 * Created by Shitab Mir on 2/22/24.
 * shitabmir@gmail.com
 **/
abstract class BaseActivity<DataBinding: ViewDataBinding> : AppCompatActivity() {

    var binding: DataBinding by Delegates.notNull()
    private val loaderDialog: AlertDialog by lazy {
        val builder = AlertDialog.Builder(this@BaseActivity, R.style.LoaderDialogTheme)
        val dialogView = LayoutInflater.from(applicationContext).inflate(R.layout.dialog_loader, null)
        builder.setView(dialogView)
        builder.setCancelable(false)
        return@lazy builder.create()
    }

    @get:LayoutRes
    abstract val layoutResourceId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        // AndroidInjection.inject(getActivity())
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(getActivity(), layoutResourceId)
    }

    fun getActivity(): AppCompatActivity = this

    fun getContext(): Context = this

    fun showLoader() {
        try {
            runOnUiThread {
                if (!loaderDialog.isShowing) loaderDialog.show()
            }
        } catch (e: Exception) {
            // SHITAB TODO
        }
    }

    fun hideLoader() {
        try {
            runOnUiThread {
                if (loaderDialog.isShowing) loaderDialog.dismiss()
            }
        } catch (e: Exception) {
            // SHITAB TODO
        }
    }

}