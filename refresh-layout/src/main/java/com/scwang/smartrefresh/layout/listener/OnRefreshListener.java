package com.scwang.smartrefresh.layout.listener;

import android.support.annotation.NonNull;

import com.scwang.smartrefresh.layout.api.RefreshLayout;

/**
 * 刷新监听器
 * Created by hxl 2018/7/30
 */

public interface OnRefreshListener {
    void onRefresh(@NonNull RefreshLayout refreshLayout);
}
