package com.v1ncent.custom.view.study.practice1.view

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View

/**
 * ================================================
 * 作    者：v1ncent
 * 版    本：1.0.0
 * 创建日期：2021/11/11
 * 描    述：绘制颜色：一般用于在绘制之前设置底色，或者在绘制之后绘制蒙版
 * 修订历史：
 * ================================================
 */
class Practice1DrawColorView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet,
    defStyleRes: Int = 0
) : View(context, attributeSet, defStyleRes) {

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
//        canvas?.drawColor(Color.GREEN)
//        canvas?.drawColor(Color.parseColor("#88880000"))
//        canvas?.drawRGB(100,100,100)
        canvas?.drawARGB(100, 200, 150, 100)
    }
}