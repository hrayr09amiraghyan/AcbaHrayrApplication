package com.example.hrayracbalibrary

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton

class AcbaButton : AppCompatButton {

    private var isDoubleClickEnabled: Boolean = false
    private var isDoubleClicked: Boolean = false
    private var clickInterval: Long = 1000

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

    private fun init(context: Context, attrs: AttributeSet) {
        val values = context.obtainStyledAttributes(attrs, R.styleable.AcbaButton)
        isDoubleClickEnabled = values.getBoolean(R.styleable.AcbaButton_isDoubleClickEnabled, false)
        values.recycle()
    }

    override fun setOnClickListener(listener: OnClickListener?) {
        if (isDoubleClickEnabled) {
            super.setOnClickListener(listener)
        } else
            super.setOnClickListener {
                if (!isDoubleClicked) {
                    listener?.onClick(it)
                    isDoubleClicked = true
                    Handler(Looper.getMainLooper()).postDelayed({
                        isDoubleClicked = false
                    }, clickInterval)
                }
            }
    }

}