package com.justcode.hxl.recycleviewsummary

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.LinearLayoutManager
import com.recycleview.smartrefresh.layout.footer.ClassicsFooter
import com.recycleview.smartrefresh.layout.header.ClassicsHeader
import com.recycleview.smartrefresh.layout.listener.OnRefreshListener
import kotlinx.android.synthetic.main.activity_normal_recycle.*

class NormalRecycleActivity : AppCompatActivity() {
    var list: MutableList<Int> = ArrayList()
    var adapter: MyAdapter? = null
    var handler =Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_normal_recycle)

        for (i in 1..20) {
            list.add(i)
        }

        adapter = MyAdapter(list, this)
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL //加上这句 就可以设置方向
        recycleview.setLayoutManager(layoutManager)
        recycleview.adapter = adapter

        refreshlayout.setRefreshHeader(ClassicsHeader(this))
        refreshlayout.setRefreshFooter(ClassicsFooter(this))

        refreshlayout.setOnRefreshListener {
            handler.postDelayed({
                list.clear()
                for (i in 100..120){
                    list.add(i)
                }
                adapter?.update(list)
                it.finishRefresh()

            },2000)

        }
        refreshlayout.setOnLoadMoreListener {
            handler.postDelayed({

                for (i in list[list.size-1]..list[list.size-1]+20){
                    list.add(i)
                }
                adapter?.update(list)
                it.finishLoadMore()

            },2000)
        }
    }


}
