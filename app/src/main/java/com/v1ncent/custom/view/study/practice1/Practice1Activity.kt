package com.v1ncent.custom.view.study.practice1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.v1ncent.custom.view.study.PageFragment
import com.v1ncent.custom.view.study.PageModel
import com.v1ncent.custom.view.study.R

/**
 * ================================================
 * 作    者：v1ncent
 * 版    本：1.0.0
 * 创建日期：2021/11/11
 * 描    述：
 * 修订历史：
 * ================================================
 */
class Practice1Activity : AppCompatActivity() {

    lateinit var tabLayout: TabLayout
    lateinit var pager: ViewPager

    val pageModels = mutableListOf<PageModel>().apply {
        add(PageModel("drawColor()", R.layout.practice1_draw_color_view))
        add(PageModel("drawCircle()", R.layout.practice1_draw_circle_view))
        add(PageModel("drawRect()", R.layout.practice1_draw_rect_view))
        add(PageModel("drawPoint()", R.layout.practice1_draw_point_view))
        add(PageModel("drawOval()", R.layout.practice1_draw_oval_view))
        add(PageModel("drawLine()", R.layout.practice1_draw_line_view))
        add(PageModel("drawRoundRect()", R.layout.practice1_draw_round_rect_view))
        add(PageModel("drawArc()", R.layout.practice1_draw_arc_view))
        add(PageModel("drawPath()", R.layout.practice1_draw_path_view))
        add(PageModel("drawBitmap()", R.layout.practice1_draw_bitmap_view))
        add(PageModel("drawText()", R.layout.practice1_draw_text_view))
        add(PageModel("drawHistogram()", R.layout.practice1_draw_histogram_view))
        add(PageModel("drawPieChart()", R.layout.practice1_draw_pie_chart_view))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice1)

        tabLayout = findViewById(R.id.tabLayout)
        pager = findViewById(R.id.pager)

        pager.adapter = object : FragmentPagerAdapter(supportFragmentManager) {
            override fun getItem(position: Int): Fragment {
                return PageFragment(pageModels[position])
            }

            override fun getCount(): Int {
                return pageModels.size
            }

            override fun getPageTitle(position: Int): CharSequence {
                return pageModels[position].titleRes
            }
        }
        tabLayout.setupWithViewPager(pager)
    }


}