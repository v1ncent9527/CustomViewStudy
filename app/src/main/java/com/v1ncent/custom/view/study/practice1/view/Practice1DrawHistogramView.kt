package com.v1ncent.custom.view.study.practice1.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

/**
 * ================================================
 * 作    者：v1ncent
 * 版    本：1.0.0
 * 创建日期：2021/11/11
 * 描    述：绘制柱状图
 * 修订历史：
 * ================================================
 */
class Practice1DrawHistogramView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet,
    defStyleRes: Int = 0
) : View(context, attributeSet, defStyleRes) {

    private val paint = Paint()
    private val screenWidth = resources.displayMetrics.widthPixels
    private val screenHeight = resources.displayMetrics.heightPixels

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawARGB(125, 125, 125, 125)

        paint.color = Color.WHITE
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 4f
        canvas?.drawPath(Path().apply {
            moveTo(200f, 600f)
            rLineTo(0f, (screenHeight / 4).toFloat())
            rLineTo((screenWidth - 400).toFloat(), 0f)
        }, paint)

        for (i in 1..7) {
            canvas?.drawPath(
                Path().apply {
                    moveTo(200f, (650 + screenHeight / 4 / 7 * (7 - i)).toFloat())
                    rLineTo(20f, 0f)
                },
                paint.apply {
                    color = Color.WHITE
                }
            )

        }

        for (i in 1..7) {
            canvas?.drawText(
                "$i%",
                70f,
                (650 + screenHeight / 4 / 7 * (7 - i)).toFloat()
                        + paint.measureText("$i%") / 2,
                paint.apply {
                    style = Paint.Style.FILL
                    color = Color.MAGENTA
                    textSize = 58f
                })

            canvas?.drawText(
                "$i%",
                (250 + (screenWidth - 400) / 7 * (7 - i)).toFloat()
                        +paint.measureText("$i%") / 2,
                (680 + screenHeight / 4).toFloat(),
                paint.apply {
                    style = Paint.Style.FILL
                    color = Color.MAGENTA
                    textSize = 58f
                })

            canvas?.drawRoundRect(
                (250 + (screenWidth - 400) / 7 * (i - 1)).toFloat(),
                (650 + screenHeight / 4 / 7 * (7 - i)).toFloat(),
                ((250 + (screenWidth - 400) / 7 * i) - 50).toFloat(),
                (600 + screenHeight / 4).toFloat(),
                50f, 5f,
                paint.apply {
                    color = Color.GREEN
                }
            )
        }



        canvas?.drawText(
            "直方图",
            (screenWidth / 2 - 100).toFloat()
                    - paint.measureText("直方图") / 2,
            (screenHeight / 2 + 300).toFloat(),
            paint.apply {
                paint.style = Paint.Style.FILL
                textSize = 108f
            })
    }


}