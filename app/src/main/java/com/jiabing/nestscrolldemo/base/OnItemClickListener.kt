package com.jiabing.nestscrolldemo.base

import android.view.View

interface OnItemClickListener<T> {
    fun onItemClick(item: T, view: View, position: Int)
}