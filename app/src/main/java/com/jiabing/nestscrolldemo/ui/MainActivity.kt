package com.jiabing.nestscrolldemo.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.jiabing.nestscrolldemo.R
import com.jiabing.nestscrolldemo.adapter.MyAdapter
import com.jiabing.nestscrolldemo.base.OnItemClickListener
import com.jiabing.nestscrolldemo.databinding.ActivityMainBinding
import com.jiabing.nestscrolldemo.model.FeedBean

class MainActivity : AppCompatActivity() {

    private lateinit var mDataBinding: ActivityMainBinding
    lateinit var adapter: MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mDataBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        mDataBinding.imageUrl =
            "https://www2.autoimg.cn/newsdfs/g26/M05/F8/5D/autohomecar__ChwFkF8NpR2AJe8FAARKH_Tw8YA732.jpg"

        adapter = MyAdapter()
        mDataBinding.rvList.adapter = adapter
        mDataBinding.rvList.layoutManager = LinearLayoutManager(this)
        adapter.setOnItemClickListener(object : OnItemClickListener<FeedBean> {
            override fun onItemClick(item: FeedBean, view: View, position: Int) {
                Log.e("======>", item.toString() + "====>" + position)
            }
        })
        var list = mutableListOf<FeedBean>(
            FeedBean(
                "11111111111",
                "https://www2.autoimg.cn/newsdfs/g26/M05/F8/5D/autohomecar__ChwFkF8NpR2AJe8FAARKH_Tw8YA732.jpg"
            ),
            FeedBean(
                "22222222222",
                "https://www2.autoimg.cn/newsdfs/g28/M02/AA/1A/autohomecar__ChsEfV8OsZyAQRTLAAaW05T7Q1I125.jpg"
            ),
            FeedBean(
                "33333333333",
                "https://img3.autoimg.cn/soudfs/g25/M07/0A/48/autohomecar__ChsEel8O4wWAKJmeAATUR2ZEZdY805.png"
            ),
            FeedBean(
                "11111111111",
                "https://www2.autoimg.cn/newsdfs/g26/M05/F8/5D/autohomecar__ChwFkF8NpR2AJe8FAARKH_Tw8YA732.jpg"
            ),
            FeedBean(
                "22222222222",
                "https://www2.autoimg.cn/newsdfs/g28/M02/AA/1A/autohomecar__ChsEfV8OsZyAQRTLAAaW05T7Q1I125.jpg"
            ),
            FeedBean(
                "33333333333",
                "https://img3.autoimg.cn/soudfs/g25/M07/0A/48/autohomecar__ChsEel8O4wWAKJmeAATUR2ZEZdY805.png"
            ),
            FeedBean(
                "11111111111",
                "https://www2.autoimg.cn/newsdfs/g26/M05/F8/5D/autohomecar__ChwFkF8NpR2AJe8FAARKH_Tw8YA732.jpg"
            ),
            FeedBean(
                "22222222222",
                "https://www2.autoimg.cn/newsdfs/g28/M02/AA/1A/autohomecar__ChsEfV8OsZyAQRTLAAaW05T7Q1I125.jpg"
            ),
            FeedBean(
                "33333333333",
                "https://img3.autoimg.cn/soudfs/g25/M07/0A/48/autohomecar__ChsEel8O4wWAKJmeAATUR2ZEZdY805.png"
            )
        )
        adapter.addData(list)
    }
}