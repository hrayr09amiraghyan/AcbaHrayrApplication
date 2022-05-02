package com.example.hrayracbalibrary

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnFocusChangeListener
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatEditText

class AcbaEditText : AppCompatEditText, ViewValidator {

    private var hasBeenEdited = false
    private var shouldShowError = false
    private var hasFocus = false
    private var mType = 0
    private var errorMessage = ""
    private var resId = 0

    private var acbaInputLayout: AcbaInputLayout? = null

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(context, attrs)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        acbaInputLayout = getInputLayout(this)

    }

    fun getInputLayout(view: View): AcbaInputLayout? {
        return if (view.parent is AcbaInputLayout) {
            view as AcbaInputLayout
        } else {
            return getInputLayout(view.parent as View)
        }
    }


    private fun init(context: Context, attrs: AttributeSet) {
        val values = context.obtainStyledAttributes(attrs, R.styleable.AcbaEditText)
        mType = values.getInt(R.styleable.AcbaEditText_type, 0)
        errorMessage = values.getString(R.styleable.AcbaEditText_errorMessage) ?: ""
        resId = values.getResourceId(R.styleable.AcbaEditText_inputLayout, 0)

        addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(text: CharSequence, start: Int, before: Int, count: Int) {
                hasBeenEdited = true
            }
        })

        onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            this.hasFocus = hasFocus
            updateState()
        }

        values.recycle()
    }

    private fun updateState() {
        shouldShowError = !hasFocus && !Validator.isValidEmail(text.toString()) && hasBeenEdited
        refreshDrawableState()
    }

    override fun validate() {
        when (mType) {
            1 -> {
                if (Validator.isValidEmail(text.toString())) {
                    acbaInputLayout?.error
                }

            }
            2 -> {
                Validator.isValidPassword(text.toString())
            }

        }
    }

}