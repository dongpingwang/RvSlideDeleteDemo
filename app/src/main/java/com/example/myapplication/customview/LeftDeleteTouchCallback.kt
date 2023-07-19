package com.example.myapplication.customview

import android.animation.ValueAnimator
import android.graphics.Canvas
import android.view.View
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class LeftDeleteTouchCallback : ItemTouchHelper.Callback() {

    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int {
        return makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)
    }

    override fun isLongPressDragEnabled(): Boolean {
        return false
    }

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder,
    ): Boolean {
        return false
    }

    override fun getSwipeThreshold(viewHolder: RecyclerView.ViewHolder): Float {
        return Int.MAX_VALUE.toFloat()
    }

    override fun getSwipeEscapeVelocity(defaultValue: Float): Float {
        return Int.MAX_VALUE.toFloat()
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
    }

    /**
     * 上次交互的viewholder
     */
    private var preActionViewHolder: RecyclerView.ViewHolder? = null

    /**
     * 首次进入交互状态
     */
    private var firstInteract: Boolean = false

    /**
     * 当前ViewHolderScrollX
     */
    private var mCurrentScrollX: Int = 0

    override fun onChildDraw(
        c: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float,
        actionState: Int,
        isCurrentlyActive: Boolean,
    ) {
        val tvDelete = viewHolder.itemView.findViewById<View>(R.id.btn_delete)
        if (firstInteract) {
            //记录首次进入的scrollX, 用于后续根据偏移量设置itemView位置
            mCurrentScrollX = viewHolder.itemView.scrollX
            firstInteract = false
        }
        //偏移量允许介于tvDelete宽度和0之间
        val mDx = (mCurrentScrollX - dX.toInt()).coerceAtMost(tvDelete.width).coerceAtLeast(0)
        if (isCurrentlyActive) {
            viewHolder.itemView.scrollTo(mDx, 0)
        } else {
            //已经抬起手指
            if (firstInteract) return
            firstInteract = true
            //记录上次交互的preActionViewHolder
            viewHolder.itemView.scrollTo(if (mDx >= tvDelete.width / 2) tvDelete.width else 0, 0)
            preActionViewHolder = if (mDx >= (tvDelete.width / 2)) viewHolder else null
        }
    }

    override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int) {
        super.onSelectedChanged(viewHolder, actionState)
        viewHolder ?: return
        if (actionState != ItemTouchHelper.ACTION_STATE_SWIPE) return
        if (preActionViewHolder != viewHolder) {
            resetPreViewHolder()
        }
    }

    /**
     * smooth还原到开始状态
     */
    fun resetPreViewHolder() {
        val x = preActionViewHolder?.itemView?.scrollX ?: 0
        if (x == 0) return

        val animator = ValueAnimator.ofInt(x, 0)
        val animationView = preActionViewHolder
        animator.addUpdateListener {
            animationView?.itemView?.scrollTo(it.animatedValue as Int, 0)
        }
        animator.start()
    }

    fun resetViewHolder(viewHolder: RecyclerView.ViewHolder) {
        val x = preActionViewHolder?.itemView?.scrollX ?: 0
        if (x == 0) return

        if (preActionViewHolder != viewHolder) return
        viewHolder.itemView.scrollTo(0, 0)
    }
}