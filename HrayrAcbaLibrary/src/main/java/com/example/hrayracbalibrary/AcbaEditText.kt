package com.example.hrayracbalibrary

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.AppCompatEditText

class AcbaEditText : AppCompatEditText, ViewValidator {

    private var acbaInputLayout: AcbaInputLayout? = null

    private var validationType: Int = 0
    private var isRequired: Boolean = false
    private var minLength: Int = UNDEFINED
    private var viewId: Int = UNDEFINED


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
        acbaInputLayout = (parent.parent as View).findViewById(viewId)
    }

    private fun init(context: Context, attrs: AttributeSet) {
        val attrValues = context.obtainStyledAttributes(attrs, R.styleable.AcbaEditText)
        try {
            isRequired = attrValues.getBoolean(R.styleable.AcbaEditText_isRequired, false)
            minLength = attrValues.getInt(R.styleable.AcbaEditText_minLength, 0)
            validationType = attrValues.getInt(R.styleable.AcbaEditText_validationType, 0)
            viewId = attrValues.getResourceId(R.styleable.AcbaEditText_viewId, 0)
        } finally {
            attrValues.recycle()
        }

        onFocusChangeListener = null
    }

    override fun setOnFocusChangeListener(l: OnFocusChangeListener?) {
        super.setOnFocusChangeListener { view, onFocus ->
            if (!onFocus) {
                validate()
            }
            l?.onFocusChange(view, onFocus)
        }

    }

    override fun validate(): Boolean {

        val viewText = text.toString()
        if (validationType != UNDEFINED && !isValidationPassed(validationType, viewText)) {
            if (viewText.isEmpty() || isRequired) {
                setErrorSate(setErrorText(validationType))
                return false
            }
        }
        setDeafaultState()
        return true
    }

    private fun isValidationPassed(validationType: Int, text: String): Boolean {

        return when (validationType) {

            resources.getInteger(R.integer.validate_is_Required)-> text.validateIsRequired()
            resources.getInteger(R.integer.validate_email) -> text.validateEmail()
            resources.getInteger(R.integer.validate_password) -> text.validatePassword()
            resources.getInteger(R.integer.validate_min_length) -> text.validateMinLength(minLength)
            else -> false
        }

    }

    private fun setErrorText(validationType: Int): String {
        return when (validationType) {
            resources.getInteger(R.integer.validate_is_Required) -> resources.getString(R.string.isRequired_error)
            resources.getInteger(R.integer.validate_min_length) -> String.format(resources.getString(R.string.min_length_error),minLength)
            resources.getInteger(R.integer.validate_email) -> resources.getString(R.string.email_error)
            resources.getInteger(R.integer.validate_password) -> resources.getString(R.string.password_error)
            else -> ""
        }
    }

    override fun setDeafaultState() {
        acbaInputLayout?.error = null
        acbaInputLayout?.isErrorEnabled = false
    }

    override fun setErrorSate(errorMessage: String) {
        acbaInputLayout?.error = errorMessage
        acbaInputLayout?.isErrorEnabled = true
    }

    companion object {
        const val UNDEFINED = -1
    }

}