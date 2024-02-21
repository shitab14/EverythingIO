package com.shitabmir.everythingio

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.view.MotionEvent
import android.view.View
import androidx.databinding.DataBindingUtil
import com.shitabmir.everythingio.buttonpage.ButtonsComposeActivity
import com.shitabmir.everythingio.databinding.ActivityMainBinding
import io.reactivex.rxjava3.subjects.PublishSubject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val lifecycleTextSpannableBuilder = SpannableStringBuilder()
    private val touchMotionTextSpannableBuilder = SpannableStringBuilder()

    // -------------------------------- <Android Lifecycle> ----------------------------------------

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupClicks()
        updateLifeCycleText("\nonCreate")

    }

    override fun onStart() {
        super.onStart()
        updateLifeCycleText("\nonStart")
    }

    override fun onResume() {
        super.onResume()
        updateLifeCycleText("\nonResume")
    }

    override fun onPause() {
        super.onPause()
        updateLifeCycleText("\nonPause")
    }

    override fun onStop() {
        super.onStop()
        updateLifeCycleText("\nonStop")
    }

    override fun onRestart() {
        super.onRestart()
        updateLifeCycleText("\nonRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        updateLifeCycleText("\nonDestroy")
    }

    // ------------------------------- Saved Instance ---------------------------------------------
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        updateLifeCycleText("\nonSaveInstanceState(outState: Bundle)")
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        updateLifeCycleText("\nonSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle)")
    }

    @Deprecated("Deprecated in Java")
    override fun onStateNotSaved() {
        super.onStateNotSaved()
        updateLifeCycleText("\nonStateNotSaved")
    }

    // ----------------------------------- Interactions -------------------------------------------
    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        super.onBackPressed()
        updateTouchMotionText("\nonBackPressed")
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        updateTouchMotionText("\nonTouchEvent\n(x,y):(${event?.x},${event?.y})")
        return super.onTouchEvent(event)
    }

    // -------------------------------------- My Methods ------------------------------------------
    private fun updateLifeCycleText(text: String) {
        lifecycleTextSpannableBuilder.setSpan(ForegroundColorSpan(Color.DKGRAY), 0, lifecycleTextSpannableBuilder.length, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
        lifecycleTextSpannableBuilder.insert(0, text)
//        lifecycleTextSpannableBuilder.setSpan(ForegroundColorSpan(Color.GREEN), lifecycleTextSpannableBuilder.length - text.length, lifecycleTextSpannableBuilder.length, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
        lifecycleTextSpannableBuilder.setSpan(ForegroundColorSpan(Color.GREEN), 0, text.length, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
        binding.tvLifecycleTrack.text = lifecycleTextSpannableBuilder

        binding.nestedScrollView.fullScroll(View.FOCUS_UP)
    }

    private fun updateTouchMotionText(text: String) {
        touchMotionTextSpannableBuilder.clear()
        touchMotionTextSpannableBuilder.append(text)
        touchMotionTextSpannableBuilder.setSpan(ForegroundColorSpan(Color.BLUE), 0, touchMotionTextSpannableBuilder.length, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
        binding.tvTouchMotionTrack.text = touchMotionTextSpannableBuilder

    }

    private fun setupClicks() {
        binding.btnNavigateA.setOnClickListener {

        }

        binding.btnNavigateToActivity.setOnClickListener {
            navigateUsingIntentExtra()
        }
    }

    // ---------------------------- Different ways of Navigation ----------------------------------
    private fun navigateUsingIntentExtra() {
        val intent = Intent(this, ButtonsComposeActivity::class.java)
        intent.putExtra("key", "value")
        startActivity(intent)
        // Receiving activity
        // val receivedData = intent.getStringExtra("key")
    }

    private val REQUEST_CODE = 1
    @Suppress("DEPRECATION")
    private fun navigateUsingStartActivityForResult() {
        val intent = Intent(this, ButtonsComposeActivity::class.java)
        startActivityForResult(intent, REQUEST_CODE)

        /*
        // Receiving activity
        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)
            if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
                val receivedData = data?.getStringExtra("key")
            }
        }
         */

    }

    private fun navigateUsingRxJava() {
        // Create a PublishSubject
        val publishSubject = PublishSubject.create<String>()
        // Send data using onNext
        publishSubject.onNext("Hello RxJava!")

        // Navigate to the next activity
        val intent = Intent(this, ButtonsComposeActivity::class.java)
        startActivity(intent)

        /*
        // Subscribe to the PublishSubject
        val disposable: Disposable = publishSubject
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { data ->
                // Handle received data
                textView.text = data
            }

         // Don't forget to dispose the subscription when it's no longer needed
        override fun onDestroy() {
            super.onDestroy()
            disposable.dispose()
        }

         */
    }

}