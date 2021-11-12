package com.v1ncent.custom.view.study.practice1.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.util.Log
import android.view.View
import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.cos
import kotlin.math.sin

/**
 * ================================================
 * 作    者：v1ncent
 * 版    本：1.0.0
 * 创建日期：2021/11/11
 * 描    述：绘制饼状图
 * 修订历史：
 * ================================================
 */
class Practice1DrawPieChartView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet,
    defStyleRes: Int = 0
) : View(context, attributeSet, defStyleRes) {
    private val RADIUS = 300f
    private val INTERVAL_ANGLE = 2
    private val DEVIATION_LENGTH = 30
    private val SLANT_LINE_LENGTH = 30
    private val STRAIGHT_LINE_LENGTH = 50
    private val TEXT_INTERVAL = 15
    private val TEXT_SIZE = 38f

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val paint = Paint().apply {
            style = Paint.Style.FILL
            isAntiAlias = true
        }
        val linePaint = Paint().apply {
            style = Paint.Style.FILL
            isAntiAlias = true
            color = Color.WHITE
            strokeWidth = 3f
        }
        val textPaint = Paint().apply {
            style = Paint.Style.FILL
            isAntiAlias = true
            color = Color.RED
            textSize = TEXT_SIZE
        }
        val dataList = mutableListOf<DataBean>().apply {
            add(DataBean(Color.YELLOW, 100, "Marshmallow", true))
            add(DataBean(Color.LTGRAY, 200, "Froyo"))
            add(DataBean(Color.GREEN, 50, "Gingerbread"))
            add(DataBean(Color.BLUE, 10, "Ice Cream Sandwich"))
            add(DataBean(Color.CYAN, 30, "Jelly Bean"))
            add(DataBean(Color.DKGRAY, 200, "KitKat"))
            add(DataBean(Color.RED, 150, "Lollipop", true))
        }

        canvas!!.drawColor(Color.GRAY)

        val midWidth = width / 2
        val midHeight = height / 2
        Log.e("midWidth","$midWidth - $midHeight")
        var startArc = BigDecimal.valueOf(0)
        val totalArc = 360 - dataList.size * INTERVAL_ANGLE

        val rectF =
            RectF(midWidth - RADIUS, midHeight - RADIUS, midWidth + RADIUS, midHeight + RADIUS)

        dataList.forEach {
            //这部分扇形绘制的弧度
            val sweepAngle: BigDecimal =
                BigDecimal.valueOf(totalArc.toDouble()).multiply(it.getPercentage())
            //这部分扇形绘制的弧度中心，用于扇形的偏移与指示线的绘制
            val midSweepAngle: Int =
                startArc.add(sweepAngle.divide(BigDecimal.valueOf(2))).toInt()

            //中心点坐标，为这部分图形的中心点
            val centerX: Int
            val centerY: Int
            if (it.isDeviation) {
                centerX =
                    (midWidth + DEVIATION_LENGTH * cos(midSweepAngle * (Math.PI / 180))).toInt()
                centerY =
                    (midHeight + DEVIATION_LENGTH * sin(midSweepAngle * (Math.PI / 180))).toInt()
            } else {
                centerX = midWidth
                centerY = midHeight
            }

            //扇形部分绘制
            paint.color = it.color
            //判断是绘制普通
            if (!it.isDeviation) {
                canvas.drawArc(rectF, startArc.toFloat(), sweepAngle.toFloat(), true, paint)
            } else {
                //绘制偏移的扇形
                val deviationRectF = RectF(
                    centerX - RADIUS, centerY - RADIUS,
                    centerX + RADIUS, centerY + RADIUS
                )
                canvas.drawArc(
                    deviationRectF,
                    startArc.toFloat(),
                    sweepAngle.toFloat(),
                    true,
                    paint
                )
            }
            startArc = startArc.add(sweepAngle).add(BigDecimal.valueOf(INTERVAL_ANGLE.toLong()))

            //指示线斜线部分绘制
            val lineStartX = (centerX + RADIUS * cos(midSweepAngle * (Math.PI / 180))).toInt()
            val lineStartY = (centerY + RADIUS * sin(midSweepAngle * (Math.PI / 180))).toInt()
            val lineEndX =
                (centerX + (RADIUS + SLANT_LINE_LENGTH) * cos(midSweepAngle * (Math.PI / 180))).toInt()
            val lineEndY =
                (centerY + (RADIUS + SLANT_LINE_LENGTH) * sin(midSweepAngle * (Math.PI / 180))).toInt()
            canvas.drawLine(
                lineStartX.toFloat(),
                lineStartY.toFloat(), lineEndX.toFloat(), lineEndY.toFloat(), linePaint
            )

            //指示线直线部分绘制
            textPaint.color = it.color
            if (midSweepAngle in 91..269) {
                canvas.drawLine(
                    lineEndX.toFloat(),
                    lineEndY.toFloat(), (lineEndX - STRAIGHT_LINE_LENGTH).toFloat(),
                    lineEndY.toFloat(), linePaint
                )
            } else {
                canvas.drawLine(
                    lineEndX.toFloat(),
                    lineEndY.toFloat(), (lineEndX + STRAIGHT_LINE_LENGTH).toFloat(),
                    lineEndY.toFloat(), linePaint
                )
            }

            //文字部分绘制
            val text: String = it.title
            if (midSweepAngle in 91..269) {
                canvas.drawText(
                    text,
                    lineEndX - textPaint.measureText(text) - TEXT_INTERVAL - STRAIGHT_LINE_LENGTH,
                    lineEndY - (textPaint.ascent() + textPaint.descent()) / 2,
                    textPaint
                )
            } else {
                canvas.drawText(
                    text, (lineEndX + TEXT_INTERVAL + STRAIGHT_LINE_LENGTH).toFloat(),
                    lineEndY - (textPaint.ascent() + textPaint.descent()) / 2, textPaint
                )
            }
        }
    }

    data class DataBean(
        val color: Int,
        val dataNum: Int,
        val title: String,
        val isDeviation: Boolean = false
    ) {

        fun getPercentage(): BigDecimal = BigDecimal.valueOf(dataNum.toDouble()).divide(
            BigDecimal.valueOf(750), 4, RoundingMode.DOWN
        )
    }
}