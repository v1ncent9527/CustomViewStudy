package com.v1ncent.custom.view.study.practice1.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.v1ncent.custom.view.study.R


/**
 * ================================================
 * 作    者：v1ncent
 * 版    本：1.0.0
 * 创建日期：2021/11/11
 * 描    述：绘制Bitmap
 * 修订历史：
 * ================================================
 */
class Practice1DrawBitmapView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet,
    defStyleRes: Int = 0
) : View(context, attributeSet, defStyleRes) {

    private val paint = Paint()

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.new_world)

        canvas?.drawBitmap(bitmap, Matrix().apply {//矩阵
            //缩放
            scaleX = 0.5f
            scaleY = 0.5f
            //平移
            translationX = 100f
            //旋转
            rotation = 10f
            //倾斜
            setSkew(0.3f, 0.3f)
        }, paint.apply {
            //颜色滤镜
            colorFilter = ColorMatrixColorFilter(
                ColorMatrix(
                    floatArrayOf(
                        1f, 0f, 0f, 0f, 1f,
                        0f, 1f, 0f, 1f, 0f,
                        0f, 0f, 1f, 0f, 0f,
                        0f, 1f, 0f, 1f, 0f
                    )
                )
            )
        })
    }
}