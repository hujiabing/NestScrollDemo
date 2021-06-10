package com.jiabing.nestscrolldemo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.jiabing.nestscrolldemo.BR
import com.jiabing.nestscrolldemo.R
import com.jiabing.nestscrolldemo.base.BaseRecyclerAdapter
import com.jiabing.nestscrolldemo.model.FeedBean


/**
 *
 * @ClassName:      MyAdapter
 * @Description:
 * @作者:         hujiabing
 * @日期:     2021/6/9 3:14 下午
 */
class MyAdapter : BaseRecyclerAdapter<FeedBean, MyAdapter.ViewHolder>() {

    override fun getViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val bind: ViewDataBinding =
            DataBindingUtil.inflate<ViewDataBinding>(
                LayoutInflater.from(getContext()),
                R.layout.item_home, parent, false
            )
        return ViewHolder(bind)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemData = getItemData(position)
        holder.bind(itemData)
    }

    class ViewHolder(var binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(bean: FeedBean) {
            binding.setVariable(BR.bean, bean)
            binding.executePendingBindings()
        }
    }
}