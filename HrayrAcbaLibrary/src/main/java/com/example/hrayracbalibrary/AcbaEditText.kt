package com.example.hrayracbalibrary

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.AppCompatEditText

class AcbaEditText : AppCompatEditText, ViewValidator {

    private var viewType = 0
    private var errorMessage = ""
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
        acbaInputLayout = getAcbaInputLayout(this)
    }

    fun getAcbaInputLayout(view: View): AcbaInputLayout? {
        return if (view.parent is AcbaInputLayout) {
            view.parent as AcbaInputLayout
        } else {
            return getAcbaInputLayout(view.parent as View)
        }
    }

    private fun init(context: Context, attrs: AttributeSet) {
        val attrValues = context.obtainStyledAttributes(attrs, R.styleable.AcbaEditText)
        viewType = attrValues.getInt(R.styleable.AcbaEditText_type, 0)
        errorMessage = attrValues.getString(R.styleable.AcbaEditText_errorMessage) ?: ""

        addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(text: CharSequence, start: Int, before: Int, count: Int) {
               hideError()
            }
        })

        attrValues.recycle()
    }

    private fun showError() {
        acbaInputLayout?.error = errorMessage
    }

    private fun hideError() {
        acbaInputLayout?.error = null
    }

    override fun validate() {
        when (viewType) {
            1 -> {
                if (!Validator.isValidEmail(text.toString())) {
                    showError()
                }
            }
            2 -> {
                if (!Validator.isValidPassword(text.toString())) {
                    showError()
                }
            }
        }
    }

}