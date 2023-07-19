package com.example.myapplication

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.AlarmListAdapter

/**
 * author: wdp
 * date: 2023/6/1
 * description:
 */
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var rv = findViewById<RecyclerView>(R.id.rv_list)
        rv.layoutManager = LinearLayoutManager(this)

        val adapter = AlarmListAdapter()
        rv.adapter = adapter

        val datas = listOf(AlarmEntity(), AlarmEntity(), AlarmEntity(), AlarmEntity(), AlarmEntity())
        adapter.setDatas(datas)

    }

}