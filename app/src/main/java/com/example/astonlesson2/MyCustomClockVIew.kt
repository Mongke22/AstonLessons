package com.example.astonlesson2


import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View
import java.lang.Math.min
import kotlin.math.cos
import kotlin.math.sin


class MyCustomClockVIew(
    context: Context,
    attributeSet: AttributeSet?,
    defStyleAttr: Int,
    defStyleRes: Int
) : View(context, attributeSet, defStyleAttr, defStyleRes) {

    private var timer = CurrentTimePicker()

    var secondHandColor = SECOND_HAND_DEFAULT_COLOR
        set(value) {
            field = value
            secondHandPaint.color = value
        }
    var secondHandWidth = SECOND_HAND_DEFAULT_WIDTH
        set(value) {
            field = value
            secondHandPaint.strokeWidth = MAX_HAND_WIDTH * (value / HUNDRED_PERCENT)
        }
    var secondHandLength = SECOND_HAND_DEFAULT_LENGTH
        set(value) {
            field = value
            findSecondHandFinishPoint()
        }

    var minuteHandColor = MINUTE_HAND_DEFAULT_COLOR
        set(value) {
            field = value
            minuteHandPaint.color = value
        }
    var minuteHandWidth = MINUTE_HAND_DEFAULT_WIDTH
        set(value) {
            field = value
            minuteHandPaint.strokeWidth = MAX_HAND_WIDTH * (value /HUNDRED_PERCENT)
        }
    var minuteHandLength = MINUTE_HAND_DEFAULT_LENGTH
        set(value) {
            field = value
            findMinuteHandFinishPoint()
        }

    var hourHandColor = HOUR_HAND_DEFAULT_COLOR
        set(value) {
            field = value
            hourHandPaint.color = value
        }
    var hourHandWidth = HOUR_HAND_DEFAULT_WIDTH
        set(value) {
            field = value
            hourHandPaint.strokeWidth = MAX_HAND_WIDTH * (value / HUNDRED_PERCENT)
        }
    var hourHandLength = HOUR_HAND_DEFAULT_LENGTH
        set(value) {
            field = value
            findHourHandFinishPoint()
        }

    var timeIndicatorsCoordinates = ArrayList<Pair<PointF, PointF>>()

    private val secondHandFinishPoint = PointF()
    private val minuteHandFinishPoint = PointF()
    private val hourHandFinishPoint = PointF()

    private var seconds = timer.seconds
    private var minutes = timer.minutes
    private var hours = timer.hours

    private var center = PointF(0f, 0f)
    private var radius = 0f

    private var secondHandPaint = Paint()
    private var minuteHandPaint = Paint()
    private var hourHandPaint = Paint()
    private var circlePaint = Paint()
    private var timeIndicatorPaint = Paint()


    constructor(context: Context, attributeSet: AttributeSet?, defStyleAttr: Int) : this(
        context,
        attributeSet,
        defStyleAttr,
        R.style.DefaultMyCustomClockStyle
    )

    constructor(context: Context, attributeSet: AttributeSet?) : this(
        context,
        attributeSet,
        R.attr.myCustomClockStyle
    )

    constructor(context: Context) : this(context, null)

    init {
        if (attributeSet != null) {
            initAttributes(attributeSet, defStyleAttr, defStyleRes)
        }
        initPaint()
    }

    private fun initPaint() {
        secondHandPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        secondHandPaint.color = secondHandColor
        secondHandPaint.style = Paint.Style.STROKE
        secondHandPaint.strokeWidth = secondHandWidth / HUNDRED_PERCENT * MAX_HAND_WIDTH


        minuteHandPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = minuteHandColor
            style = Paint.Style.STROKE
            strokeWidth = minuteHandWidth / HUNDRED_PERCENT * MAX_HAND_WIDTH
        }

        hourHandPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = hourHandColor
            style = Paint.Style.STROKE
            strokeWidth = hourHandWidth / HUNDRED_PERCENT * MAX_HAND_WIDTH
        }

        circlePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = CIRCLE_COLOR
            style = Paint.Style.STROKE
            strokeWidth = CIRCLE_WIDTH
        }

        timeIndicatorPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = CIRCLE_COLOR
            style = Paint.Style.STROKE
            strokeWidth = TIME_INDICATOR_WIDTH
        }
    }

    private fun initAttributes(
        attributeSet: AttributeSet,
        defStyleAttr: Int,
        defStyleRes: Int
    ) {
        val typedArray = context.obtainStyledAttributes(
            attributeSet,
            R.styleable.MyCustomClockVIew,
            defStyleAttr,
            defStyleRes
        )
        secondHandColor =
            typedArray.getColor(
                R.styleable.MyCustomClockVIew_secondHandColor,
                SECOND_HAND_DEFAULT_COLOR
            )
        minuteHandColor =
            typedArray.getColor(
                R.styleable.MyCustomClockVIew_minuteHandColor,
                MINUTE_HAND_DEFAULT_COLOR
            )
        hourHandColor = typedArray.getColor(
            R.styleable.MyCustomClockVIew_hourHandColor,
            HOUR_HAND_DEFAULT_COLOR
        )

        secondHandWidth = typedArray.getInt(
            R.styleable.MyCustomClockVIew_secondHandWidth,
            SECOND_HAND_DEFAULT_WIDTH
        )
        minuteHandWidth = typedArray.getColor(
            R.styleable.MyCustomClockVIew_minuteHandWidth,
            MINUTE_HAND_DEFAULT_WIDTH
        )
        hourHandWidth = typedArray.getColor(
            R.styleable.MyCustomClockVIew_hourHandWidth,
            HOUR_HAND_DEFAULT_WIDTH
        )

        secondHandLength = typedArray.getInt(
            R.styleable.MyCustomClockVIew_secondHandLength,
            SECOND_HAND_DEFAULT_LENGTH
        )
        minuteHandLength = typedArray.getColor(
            R.styleable.MyCustomClockVIew_minuteHandLength,
            MINUTE_HAND_DEFAULT_LENGTH
        )
        hourHandLength = typedArray.getColor(
            R.styleable.MyCustomClockVIew_hourHandLength,
            HOUR_HAND_DEFAULT_LENGTH
        )

        typedArray.recycle()
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        val safeWidth = w - paddingLeft - paddingRight
        val safeHeight = h - paddingTop - paddingBottom
        val safeRadius = min(safeHeight, safeWidth) / 2f

        radius = safeRadius * PADDING_FROM_MAX_RADIUS
        center.x = paddingLeft + safeWidth / 2f
        center.y = paddingTop + safeHeight / 2f

        computeTimeIndicators(12)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (radius <= 0) return
        drawCirce(canvas)
        drawTimeIndicators(canvas)
        drawHourHand(canvas)
        drawMinuteHand(canvas)
        drawSecondHand(canvas)
    }

    private fun drawSecondHand(canvas: Canvas?) {
        canvas?.drawLine(
            center.x,
            center.y,
            secondHandFinishPoint.x,
            secondHandFinishPoint.y,
            secondHandPaint
        )
    }

    private fun drawMinuteHand(canvas: Canvas?) {
        canvas?.drawLine(
            center.x,
            center.y,
            minuteHandFinishPoint.x,
            minuteHandFinishPoint.y,
            minuteHandPaint
        )

    }

    private fun drawHourHand(canvas: Canvas?) {
        canvas?.drawLine(
            center.x,
            center.y,
            hourHandFinishPoint.x,
            hourHandFinishPoint.y,
            hourHandPaint
        )

    }

    private fun drawCirce(canvas: Canvas?) {
        canvas?.drawPoint(center.x, center.y, circlePaint)
        canvas?.drawCircle(center.x, center.y, radius, circlePaint)
    }

    private fun drawTimeIndicators(canvas: Canvas?) {
        for (pairCoordinates in timeIndicatorsCoordinates) {
            canvas?.drawLine(
                pairCoordinates.first.x,
                pairCoordinates.first.y,
                pairCoordinates.second.x,
                pairCoordinates.second.y,
                timeIndicatorPaint
            )
        }
    }

    private fun findSecondHandFinishPoint() {
        Log.i("seconds", seconds.toString())
        val cosAngle = cos(Math.toRadians(seconds * DEGREES_PER_SECOND - STANDARD_ANGEL_TO_ZERO)).toFloat()
        val sinAngle = sin(Math.toRadians(seconds * DEGREES_PER_SECOND - STANDARD_ANGEL_TO_ZERO)).toFloat()
        secondHandFinishPoint.x = center.x + (secondHandLength / HUNDRED_PERCENT * radius) * cosAngle
        secondHandFinishPoint.y = center.y + (secondHandLength / HUNDRED_PERCENT * radius) * sinAngle
    }

    private fun findMinuteHandFinishPoint() {
        val cosAngle = cos(Math.toRadians(minutes * DEGREES_PER_MINUTE - STANDARD_ANGEL_TO_ZERO)).toFloat()
        val sinAngle = sin(Math.toRadians(minutes * DEGREES_PER_MINUTE - STANDARD_ANGEL_TO_ZERO)).toFloat()
        minuteHandFinishPoint.x = center.x + (minuteHandLength / HUNDRED_PERCENT * radius) * cosAngle
        minuteHandFinishPoint.y = center.y + (minuteHandLength / HUNDRED_PERCENT * radius) * sinAngle
    }

    private fun findHourHandFinishPoint() {
        val cosAngle = cos(Math.toRadians(hours * DEGREES_PER_HOUR - STANDARD_ANGEL_TO_ZERO)).toFloat()
        val sinAngle = sin(Math.toRadians(hours * DEGREES_PER_HOUR - STANDARD_ANGEL_TO_ZERO)).toFloat()
        hourHandFinishPoint.x = center.x + (hourHandLength / HUNDRED_PERCENT * radius) * cosAngle
        hourHandFinishPoint.y = center.y + (hourHandLength / HUNDRED_PERCENT * radius) * sinAngle
    }

    private fun computeTimeIndicators(countOfIndicator: Int) {
        val angle = 360f / countOfIndicator
        for (indicator in 0 until countOfIndicator) {
            val start = PointF()
            val finish = PointF()
            val cosAngle = cos(Math.toRadians(indicator * angle - STANDARD_ANGEL_TO_ZERO)).toFloat()
            val sinAngle = sin(Math.toRadians(indicator * angle - STANDARD_ANGEL_TO_ZERO)).toFloat()
            start.x = center.x + (0.9f * radius) * cosAngle
            start.y = center.y + (0.9f * radius) * sinAngle
            finish.x = center.x + radius * cosAngle
            finish.y = center.y + radius * sinAngle
            timeIndicatorsCoordinates.add(Pair(start, finish))
        }
    }

    fun updateTimer() {
        seconds = timer.seconds
        minutes = timer.minutes
        hours = timer.hours

        findSecondHandFinishPoint()
        findMinuteHandFinishPoint()
        findHourHandFinishPoint()

        invalidate()
    }


    companion object {
        const val SECOND_HAND_DEFAULT_COLOR = Color.RED
        const val MINUTE_HAND_DEFAULT_COLOR = Color.GREEN
        const val HOUR_HAND_DEFAULT_COLOR = Color.BLUE

        const val CIRCLE_COLOR = Color.BLACK

        const val CIRCLE_WIDTH = 20f
        const val TIME_INDICATOR_WIDTH = 4f

        const val MAX_HAND_WIDTH = 50f

        const val STANDARD_ANGEL_TO_ZERO = 90.0

        const val PADDING_FROM_MAX_RADIUS = 0.9f

        const val HUNDRED_PERCENT = 100f

        const val DEGREES_PER_SECOND = 6f
        const val DEGREES_PER_MINUTE = 6f
        const val DEGREES_PER_HOUR = 30f


        const val SECOND_HAND_DEFAULT_WIDTH = 10
        const val MINUTE_HAND_DEFAULT_WIDTH = 20
        const val HOUR_HAND_DEFAULT_WIDTH = 40

        const val SECOND_HAND_DEFAULT_LENGTH = 20
        const val MINUTE_HAND_DEFAULT_LENGTH = 40
        const val HOUR_HAND_DEFAULT_LENGTH = 80
    }
}