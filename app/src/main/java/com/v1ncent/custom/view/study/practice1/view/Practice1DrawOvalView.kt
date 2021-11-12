package com.v1ncent.custom.view.study.practice1.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

/**
 * ================================================
 * 作    者：v1ncent
 * 版    本：1.0.0
 * 创建日期：2021/11/11
 * 描    述：绘制椭圆 (其实就是绘制矩形的内切圆)
 * 修订历史：
 * ================================================
 */
class Practice1DrawOvalView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet,
    defStyleRes: Int = 0
) : View(context, attributeSet, defStyleRes) {

    private val paint = Paint()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawOval(100f, 150f, 400f, 400f, paint)

        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 20f
        canvas?.drawOval(400f, 450f, 500f, 500f, paint)


        canvas?.drawOval(RectF(600f, 450f, 500f, 500f), paint)
    }
}