package com.example.nathanranghel.exemploorder

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.BounceInterpolator
import android.widget.ImageView
import android.widget.LinearLayout
import com.example.nathanranghel.exemploorder.Product.SimpleAdapter
import java.util.*


/**
 * 作者 : andy
 * 日期 : 15/12/13 18:31
 * 邮箱 : andyxialm@gmail.com
 * 描述 : 测试界面
 */
class MainActivity : AppCompatActivity() {

    private var mExpandableLayout: ExpandableLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<View>(R.id.recycler_view2) as RecyclerView
        Objects.requireNonNull<RecyclerView.ItemAnimator>(recyclerView.itemAnimator).changeDuration = 700
        val simpleAdapter = SimpleAdapter()
        val gridLayoutManager = GridLayoutManager(this, 1)
        recyclerView.layoutManager = gridLayoutManager

        recyclerView.adapter = simpleAdapter
        val switcher = findViewById<ImageView>(R.id.switcher)
        mExpandableLayout = findViewById(R.id.expandableLayout) as ExpandableLayout
        mExpandableLayout!!.setSwitcher(switcher)
        mExpandableLayout!!.setExpandInterpolator(BounceInterpolator())
        mExpandableLayout!!.setCollapseInterpolator(AccelerateDecelerateInterpolator())
        mExpandableLayout!!.setExpandDuration(800)
        mExpandableLayout!!.setCollapseDuration(400)

        mExpandableLayout!!.setOnStateChangedListener(object : ExpandableLayout.OnStateChangedListener {
            override fun onPreExpand() {
                Log.d("ExpandableLayout", "onPreExpand")
            }

            override fun onPreCollapse() {
                Log.d("ExpandableLayout", "onPreCollapse")
            }

            override fun onExpanded() {
                Log.d("ExpandableLayout", "onExpanded")
            }

            override fun onCollapsed() {
                Log.d("ExpandableLayout", "onCollapsed")
            }
        })
        this.findViewById<LinearLayout>(R.id.btnTitle).setOnClickListener(View.OnClickListener { mExpandableLayout!!.toggle() })


    }
}