package com.v1ncent.custom.view.study.practice1.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

/**
 * ================================================
 * 作    者：v1ncent
 * 版    本：1.0.0
 * 创建日期：2021/11/11
 * 描    述：绘制圆角矩形
 * 修订历史：
 * ================================================
 */
class Practice1DrawRoundRectView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet,
    defStyleRes: Int = 0
) : View(context, attributeSet, defStyleRes) {

    private val paint = Paint()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 10f
        paint.color = Color.RED
        canvas?.drawRect(100f, 100f, 400f, 400f, paint)

        //rx : 圆角的横向半径  ry : 圆角的纵向半径
        paint.style = Paint.Style.FILL
        paint.color = Color.BLACK
        canvas?.drawRoundRect(100f, 100f, 400f, 400f, 200f, 300f, paint)

        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 20f
        canvas?.drawRoundRect(RectF(100f, 600f, 400f, 900f), 50f, 50f, paint)
    }
}