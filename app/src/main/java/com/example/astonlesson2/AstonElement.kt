package com.example.astonlesson2

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.astonlesson2.databinding.AstonCombinedElementBinding

class AstonElement(
    context: Context,
    attrs: AttributeSet?,
    defStyleAttr: Int,
    defStyleRes: Int
) : ConstraintLayout(context, attrs, defStyleAttr, defStyleRes) {

    private val binding: AstonCombinedElementBinding

    var logoSrcId: Int = 0
        set(value){
            field = value
            binding.logo.setImageResource(value)
        }
    var titleText: String? = null
        set(value){
            field = value
            binding.mainText.text = value ?: "Title"
        }
    var subTitleText: String? = null
        set(value) {
            field = value
            binding.subText.text = value ?: "Subtitle"
        }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : this(
        context,
        attrs,
        defStyleAttr,
        R.style.defaultAstonElementStyle
    )
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, R.attr.astonElementStyle)
    constructor(context: Context) : this(context, null)

    init {
        val inflater = LayoutInflater.from(context)
        inflater.inflate(R.layout.aston_combined_element, this, true)
        binding = AstonCombinedElementBinding.bind(this)
        initAttrs(attrs, defStyleAttr, defStyleRes)
    }

    private fun initAttrs(attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) {
        if (attrs == null) return
        val typedArray = context.obtainStyledAttributes(
            attrs,
            R.styleable.AstonElement,
            defStyleAttr,
            defStyleRes
        )
        titleText = typedArray.getString(R.styleable.AstonElement_astonTitleText)
        subTitleText = typedArray.getString(R.styleable.AstonElement_astonSubTitleText)
        logoSrcId = typedArray.getResourceId(R.styleable.AstonElement_astonImageSrc, R.drawable.aston_logo)

        typedArray.recycle()
    }
}