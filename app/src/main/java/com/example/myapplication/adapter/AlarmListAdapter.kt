package com.example.myapplication.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.AlarmEntity
import com.example.myapplication.R
import com.example.myapplication.customview.LeftDeleteTouchCallback

/**
 * @author dongping.wang
 * @date 2022/11/8 11:43
 * @description
 */
class AlarmListAdapter : RecyclerView.Adapter<AlarmListAdapter.ViewHolder>() {

    companion object {
        private const val TAG = "AlarmListAdapter"
    }

    private var alarmList: List<AlarmEntity>? = null

    private val itemTouchCallback by lazy { LeftDeleteTouchCallback() }
    private val itemTouchHelper by lazy { ItemTouchHelper(itemTouchCallback) }

    fun setDatas(alarmList: List<AlarmEntity>) {
        this.alarmList = alarmList
        notifyDataSetChanged()
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        recyclerView.addRecyclerListener {
            itemTouchCallback.resetViewHolder(it)
        }

        itemTouchHelper.attachToRecyclerView(recyclerView)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_alarm_list, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return alarmList?.size ?: 0
    }


    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            itemTouchCallback.resetPreViewHolder()
        }
    }
}