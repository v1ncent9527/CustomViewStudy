package com.v1ncent.custom.view.study.practice1.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * ================================================
 * 作    者：v1ncent
 * 版    本：1.0.0
 * 创建日期：2021/11/11
 * 描    述：绘制圆
 * 修订历史：
 * ================================================
 */
class Practice1DrawCircleView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet,
    defStyleRes: Int = 0
) : View(context, attributeSet, defStyleRes) {

    private val paint = Paint()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint.color = Color.RED     //设置颜色
        canvas?.drawCircle(100f, 100f, 100f, paint)

        paint.style = Paint.Style.STROKE //FILL(填充模式) STROKE（勾边模式）  FILL_AND_STROKE（既画线有填充）
        paint.strokeWidth = 20f
        paint.color = Color.YELLOW
        canvas?.drawCircle(250f, 100f, 90f, paint)


        paint.color = Color.CYAN
        paint.strokeWidth = 20f //STROKE FILL_AND_STROKE 模式下设置线条的宽度
        canvas?.drawCircle(400f, 400f, 200f, paint)

        paint.isAntiAlias = true    //抗锯齿
        canvas?.drawCircle(400f, 1000f, 400f, paint)
        paint.strokeWidth = 10f
        canvas?.drawCircle(350f, 350f, 40f, paint)
        canvas?.drawCircle(450f, 350f, 40f, paint)
        canvas?.drawCircle(400f, 500f, 40f, paint)
        canvas?.drawCircle(400f, 1200f, 40f, paint)

    }
}