package com.justcode.hxl.recycleviewsummary;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import com.recycleview.smartrefresh.layout.SmartRefreshLayout;
import com.recycleview.smartrefresh.layout.api.RefreshLayout;
import com.recycleview.smartrefresh.layout.listener.OnLoadMoreListener;
import com.recycleview.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.sax.TemplatesHandler;

public class ZhidingyiRecycleActivity extends AppCompatActivity {
    SmartRefreshLayout smartRefreshLayout;
    RecyclerView recyclerView;
    List<Integer> list = new ArrayList<>();
    MyAdapter adapter ;
    Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhidingyi_recycle);

        smartRefreshLayout = findViewById(R.id.refreshlayout);
        recyclerView = findViewById(R.id.recycleview);

        for (int i = 1 ;i<21;i++){
            list.add(i);
        }

        adapter = new MyAdapter(list,this);
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

        smartRefreshLayout.setRefreshHeader(new ZhidingyiHeader(LayoutInflater.from(this).inflate(R.layout.zhidingyiloading, null, false)));

        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull final RefreshLayout refreshLayout) {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        list.clear();
                        for (int i = 100;i<121;i++){
                            list.add(i);
                        }
                        adapter.update(list);
                        smartRefreshLayout.finishRefresh();
                    }
                },2000);
            }
        });
        smartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull final RefreshLayout refreshLayout) {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        for (int i = 21;i<41;i++){
                            list.add(i);
                        }
                        adapter.update(list);
                        smartRefreshLayout.finishLoadMore();
                    }
                },2000);
            }
        });


    }
}
