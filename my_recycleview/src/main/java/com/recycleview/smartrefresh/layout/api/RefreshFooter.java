package com.recycleview.smartrefresh.layout.api;

/**
 * 刷新底部
 * Created by hxl 2018/7/30
 */
public interface RefreshFooter extends RefreshInternal {

    /**
     * 设置数据全部加载完成，将不能再次触发加载功能
     * @param noMoreData 是否有更多数据
     * @return true 支持全部加载完成的状态显示 false 不支持
     */
    boolean setNoMoreData(boolean noMoreData);
}
