package com.v1ncent.custom.view.study.practice1.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * ================================================
 * 作    者：v1ncent
 * 版    本：1.0.0
 * 创建日期：2021/11/11
 * 描    述：绘制线
 * 修订历史：
 * ================================================
 */
class Practice1DrawLineView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet,
    defStyleRes: Int = 0
) : View(context, attributeSet, defStyleRes) {

    private val paint = Paint()

    @SuppressLint("Range")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint.strokeWidth = 20f
        canvas?.drawLine(100f, 100f, 300f, 300f, paint)

        paint.style = Paint.Style.STROKE //由于直线是封闭的，所以设置style无效
        canvas?.drawLine(100f, 400f, 400f, 600f, paint)

        val pts =
            floatArrayOf(
                100f, 800f, 100f, 1200f, 100f, 800f, 500f, 1200f, 500f, 1200f, 500f, 800f,
                600f, 800f, 600f, 1200f, 600f, 800f, 800f, 900f, 800f, 900f, 600f,1000f, 600f,1000f, 800f,1100f, 800f,1100f, 600f,1200f
            )
        canvas?.drawLines(pts, paint)       //批量画线

    }
}