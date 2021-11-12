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
 * 描    述：绘制点
 * 修订历史：
 * ================================================
 */
class Practice1DrawPointView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet,
    defStyleRes: Int = 0
) : View(context, attributeSet, defStyleRes) {

    private val paint = Paint()

    @SuppressLint("Range")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint.strokeWidth = 20f //点的大小
        paint.strokeCap = Paint.Cap.ROUND       //圆头
        canvas?.drawPoint(100f, 100f, paint)

        paint.strokeCap = Paint.Cap.BUTT        //平头
        canvas?.drawPoint(200f, 200f, paint)

        paint.strokeCap = Paint.Cap.SQUARE      //方头
        canvas?.drawPoint(300f, 300f, paint)

        paint.strokeCap = Paint.Cap.ROUND
        paint.strokeWidth = 100f
        val pts = floatArrayOf(0f, 0f, 400f, 400f, 600f, 600f, 600f, 400f, 400f, 600f, 600f)
        canvas?.drawPoints(pts, 2, 8, paint)  //批量花点 offset:跳过数组前几个 count:拢共绘制几个点
    }
}