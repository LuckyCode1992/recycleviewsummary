package com.justcode.hxl.recycleviewsummary

import android.content.Context
import android.util.AttributeSet
import android.view.View
import com.recycleview.smartrefresh.layout.api.RefreshHeader
import com.recycleview.smartrefresh.layout.api.RefreshLayout
import com.recycleview.smartrefresh.layout.internal.InternalAbstract
import android.view.animation.LinearInterpolator
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.zhidingyiloading.view.*


class ZhidingyiHeader: InternalAbstract, RefreshHeader{
    constructor(wrapper: View) : super(wrapper)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)


    override fun onStartAnimator(refreshLayout: RefreshLayout, height: Int, maxDragHeight: Int) {
        super.onStartAnimator(refreshLayout, height, maxDragHeight)
        val animation = AnimationUtils.loadAnimation(context, R.anim.animation)
        val lin = LinearInterpolator()//设置动画匀速运动
        animation.interpolator = lin
        view.zidingyixiaoguo.startAnimation(animation)

    }

    override fun onFinish(refreshLayout: RefreshLayout, success: Boolean): Int {
        return super.onFinish(refreshLayout, success)
        view.zidingyixiaoguo.clearAnimation()
    }





}