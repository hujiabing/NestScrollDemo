package com.jiabing.nestscrolldemo.model

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 *
 * @ClassName:      FeedBean
 * @Description:
 * @作者:         hujiabing
 * @日期:     2021/6/9 3:58 下午
 */
data class FeedBean(val title:String, val imageUrl:String){
    override fun toString(): String {
        return "FeedBean(title='$title', imageUrl='$imageUrl')"
    }
}
