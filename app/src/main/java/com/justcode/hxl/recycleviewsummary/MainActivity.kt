package com.justcode.hxl.recycleviewsummary

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.recycleview.smartrefresh.layout.SmartRefreshLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nor_recycle.setOnClickListener({
            startActivity(Intent(this,NormalRecycleActivity::class.java))
        })
        zidingyi_recycle.setOnClickListener({
            startActivity(Intent(this,ZhidingyiRecycleActivity::class.java))
        })
        daicehua_recycle.setOnClickListener({
            startActivity(Intent(this,DaicehuaRecycleActivity::class.java))
        })


    }
}
