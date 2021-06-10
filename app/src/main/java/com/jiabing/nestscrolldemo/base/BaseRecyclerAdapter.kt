package com.jiabing.nestscrolldemo.base

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.jiabing.nestscrolldemo.R

/**
 *
 * @ClassName:      BaseRecyclerAdapter
 * @Description:
 * @作者:         hujiabing
 * @日期:     2021/6/9 10:08 上午
 */
abstract class BaseRecyclerAdapter<T, VH : RecyclerView.ViewHolder> : RecyclerView.Adapter<VH>() {

    var mData: MutableList<T> = arrayListOf()
        internal set
    lateinit var mLayoutInflater: LayoutInflater
    private var mOnItemClickListener: OnItemClickListener<T>? = null
    private lateinit var mContext: Context
    private lateinit var mParent: ViewGroup
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        mContext = parent.context
        mLayoutInflater = LayoutInflater.from(mContext)
        val baseViewHolder: VH = getViewHolder(parent, viewType)
        bindViewClickListener(baseViewHolder, viewType)
        return baseViewHolder
    }

    private fun bindViewClickListener(viewHolder: RecyclerView.ViewHolder, viewType: Int) {
        mOnItemClickListener?.let {
            viewHolder.itemView.setOnClickListener { v ->
                var position = viewHolder.adapterPosition
                if (position == RecyclerView.NO_POSITION) {
                    return@setOnClickListener
                }
                val itemData: T = getItemData(position)
                mOnItemClickListener?.onItemClick(itemData, v, position)
            }
        }
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener<T>) {
        mOnItemClickListener = onItemClickListener
    }

    fun inflateView(@LayoutRes resource: Int): View {
        return mLayoutInflater.inflate(resource, mParent, false)
    }

    fun getContext(): Context {
        return mContext
    }


    abstract fun getViewHolder(parent: ViewGroup, viewType: Int): VH

    fun getItemData(position: Int): T {
        return mData[position]
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    /**
     * 增加单条数据
     */
    fun addData(e: T?) {
        if (e != null) {//不为空
            mData.add(e)
            notifyItemInserted(this.mData.size)
        }
    }

    /**
     * 增加数据
     */
    fun addData(newData: List<T>?) {
        if (!newData.isNullOrEmpty()) {//不为空
            mData.addAll(newData)
            notifyItemRangeInserted(this.mData.size - newData.size, newData.size)
        }
    }

    /**
     * 替换数据
     */
    fun replaceData(list: List<T>?) {
        this.mData.clear()
        if (!list.isNullOrEmpty()) {//不为空
            mData.addAll(list)
        }
        notifyDataSetChanged()
    }

    fun getAdapterData(): MutableList<T> {
        return mData
    }


}