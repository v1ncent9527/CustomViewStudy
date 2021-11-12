package com.v1ncent.custom.view.study

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewStub
import androidx.fragment.app.Fragment

/**
 * ================================================
 * 作    者：v1ncent
 * 版    本：1.0.0
 * 创建日期：2021/11/11
 * 描    述：
 * 修订历史：
 * ================================================
 */
class PageFragment(private val pageModel: PageModel) : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_page, container, false)
        view.findViewById<ViewStub>(R.id.viewStub).apply {
            layoutResource = pageModel.practiceLayoutRes
            inflate()
        }

        return view
    }
}