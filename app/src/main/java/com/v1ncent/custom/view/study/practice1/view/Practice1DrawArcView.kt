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
 * 描    述：绘制弧形或扇形
 * 修订历史：
 * ================================================
 */
class Practice1DrawArcView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet,
    defStyleRes: Int = 0
) : View(context, attributeSet, defStyleRes) {

    private val paint = Paint()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        //left top right bottom 表示的是圆弧所在椭圆的坐标
        //startAngle:弧形的起始角度（X轴的正向（0度），顺时针为正角度，逆时针为负角度）
        //sweepAngle:弧形划过的角度 X轴的正向（0度），顺时针为正角度，逆时针为负角度）
        //userCenter：是否连接圆心
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 10f
        paint.color = Color.RED

        canvas?.drawOval(100f, 100f, 1200f, 800f, paint)

        val rectF = RectF(120f, 120f, 1180f, 780f)
        paint.color = Color.BLACK
        canvas?.drawArc(rectF, 100f, 60f, false, paint)
        paint.style = Paint.Style.FILL
        canvas?.drawArc(rectF, 0f, 100f, true, paint)
        canvas?.drawArc(rectF, -10f, -160f, false, paint)

    }
}