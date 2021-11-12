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
 * 描    述：绘制路径
 *          有两类方法：1，直接描述路径 2，辅助的设置和计算
 * 修订历史：
 * ================================================
 */
class Practice1DrawPathView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet,
    defStyleRes: Int = 0
) : View(context, attributeSet, defStyleRes) {

    private val paint = Paint()

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint.color = Color.RED

        canvas?.drawPath(Path().apply {
            addArc(200f, 200f, 400f, 400f, -225f, 225f)
            arcTo(400f, 200f, 600f, 400f, -180f, 225f, false)
            lineTo(400f, 542f)
        }, paint)


        //1，直接描述路径 可以分为 添加子图形 + 画线
        paint.color = Color.BLACK
        canvas?.drawPath(Path().apply {
            addCircle(200f, 800f, 200f, Path.Direction.CCW) //dir:圆路径的方法 CW:顺时针 CCW:逆时针
        }, paint)

        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 10f
        canvas?.drawPath(Path().apply {
            addCircle(600f, 800f, 200f, Path.Direction.CCW) //dir:圆路径的方法 CW:顺时针 CCW:逆时针
            lineTo(800f, 1000f) //lineTo：绝对坐标
            rLineTo(100f, 100f)  //rLineTo:相对坐标（相对于当前位置）
        }, paint)

        canvas?.drawPath(Path().apply {
            moveTo(1000f, 1000f)  //改变当前点的位置，从而间接的设置起点
            rQuadTo(100f, 100f, 200f, 200f)
        }, paint)

        canvas?.drawPath(Path().apply {
            moveTo(100f, 1500f)  //改变当前点的位置，从而间接的设置起点
            rLineTo(0f, -400f)
            rLineTo(400f, 400f)
            rLineTo(0f, -400f)
            moveTo(600f, 1500f)
            rLineTo(0f, -400f)
            rLineTo(200f, 100f)
            rLineTo(-200f, 100f)
            rLineTo(200f, 100f)
            rLineTo(-200f, 100f)
        }, paint)

        canvas?.drawPath(Path().apply {
            moveTo(100f, 1500f)
            rLineTo(0f, -400f)
            rLineTo(400f, 400f)
            rLineTo(0f, -400f)
            moveTo(600f, 1500f)
            rLineTo(0f, -400f)
            rLineTo(200f, 100f)
            rLineTo(-200f, 100f)
            rLineTo(200f, 100f)
            rLineTo(-200f, 100f)
        }, paint)

        canvas?.drawPath(Path().apply {
            moveTo(100f, 1600f)
            rLineTo(100f, 0f)

            //forceMoveTo:是否要抬笔绘制 还是 直接拖笔绘制
            arcTo(200f, 1600f, 400f, 1800f, -90f, 90f, true)
            close() //将当前子视图封闭 （当前位置->当前子视图的起点绘制一条直线 与loneTo(起点)等价）
        }, paint)

        //2，辅助的设置和计算
        paint.style = Paint.Style.FILL
        canvas?.drawPath(Path().apply {
            //FillType :
            // EVEN_ODD->奇偶原则（射线相交数为偶数则外部，不涂色）
            // WINDING->非0环绕数原则（顺时针+1 逆时针-1 若为0则外部，不涂色）
            fillType = Path.FillType.EVEN_ODD
            moveTo(400f, 1900f)
            addCircle(200f, 2000f, 100f, Path.Direction.CW) //dir:圆路径的方法 CW:顺时针 CCW:逆时针
            addCircle(300f, 2000f, 100f, Path.Direction.CCW)
        }, paint)

        canvas?.drawPath(Path().apply {
            //FillType :
            // EVEN_ODD->奇偶原则（射线相交数为偶数则外部，不涂色）
            // WINDING->非0环绕数原则（顺时针+1 逆时针-1 若为0则外部，不涂色）
            fillType = Path.FillType.WINDING
            moveTo(400f, 1900f)
            addCircle(500f, 2000f, 100f, Path.Direction.CW) //dir:圆路径的方法 CW:顺时针 CCW:逆时针
            addCircle(600f, 2000f, 100f, Path.Direction.CW)
        }, paint)
//        canvas?.drawPath(Path().apply {
//            //FillType :
//            // EVEN_ODD->奇偶原则（射线相交数为偶数则外部，不涂色）
//            // WINDING->非0环绕数原则（顺时针+1 逆时针-1 若为0则外部，不涂色）
//            fillType = Path.FillType.INVERSE_EVEN_ODD
//            moveTo(400f, 1900f)
//            addCircle(900f, 2000f, 100f, Path.Direction.CW) //dir:圆路径的方法 CW:顺时针 CCW:逆时针
//            addCircle(1000f, 2000f, 100f, Path.Direction.CW)
//        }, paint)
    }
}