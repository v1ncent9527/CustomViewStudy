package com.v1ncent.custom.view.study.practice1.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View

/**
 * ================================================
 * 作    者：v1ncent
 * 版    本：1.0.0
 * 创建日期：2021/11/11
 * 描    述：绘制矩形
 * 修订历史：
 * ================================================
 */
class Practice1DrawRectView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet,
    defStyleRes: Int = 0
) : View(context, attributeSet, defStyleRes) {

    private val paint = Paint()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawRect(100f, 100f, 400f, 400f, paint)

        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 20f
        canvas?.drawRect(400f, 400f, 500f, 500f, paint)


        canvas?.drawRect(Rect(600, 400, 500, 500),paint)
    }
}