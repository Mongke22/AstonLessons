package com.example.astonlesson2

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout

class AstonElement(
    context: Context,
    attrs: AttributeSet?,
    defStyleAttr: Int,
    defStyleRes: Int
): ConstraintLayout(context, attrs, defStyleAttr, defStyleRes) {

    private

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int): this(context, attrs, defStyleAttr, 0)
    constructor(context: Context, attrs: AttributeSet?): this(context, attrs, 0)
    constructor(context: Context): this(context, null)

    init{
        val inflater = LayoutInflater.from(context)
        inflater.inflate(R.layout.aston_combined_element, this, true)
        //initAttrs(attrs)
    }

    private fun initAttrs(attrs: AttributeSet?, defStyleAttr: Int){

    }
}