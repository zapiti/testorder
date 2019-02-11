package com.example.nathanranghel.exemploorder.Product

import android.graphics.drawable.Animatable
import android.os.Bundle
import android.support.graphics.drawable.AnimatedVectorDrawableCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.example.nathanranghel.exemploorder.R

import java.util.Objects

class ProductActivity : AppCompatActivity() {

    lateinit var gridLayoutManager: GridLayoutManager
    lateinit var simpleAdapter: SimpleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        // setSupportActionBar(toolbar);

        val recyclerView = findViewById<View>(R.id.recycler_view) as RecyclerView
        Objects.requireNonNull<RecyclerView.ItemAnimator>(recyclerView.itemAnimator).changeDuration = 700
        simpleAdapter = SimpleAdapter()
        recyclerView.adapter = simpleAdapter
        gridLayoutManager = GridLayoutManager(this, 1)
        recyclerView.layoutManager = gridLayoutManager
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.action_list_to_grid) {
            if (!(item.icon as Animatable).isRunning) {
                if (gridLayoutManager.spanCount == 1) {
                    item.icon = AnimatedVectorDrawableCompat.create(this,
                        R.drawable.avd_list_to_grid
                    )
                    gridLayoutManager.spanCount = 2
                } else {
                    item.icon = AnimatedVectorDrawableCompat.create(this,
                        R.drawable.avd_grid_to_list
                    )
                    gridLayoutManager.spanCount = 1
                }
                (item.icon as Animatable).start()
                simpleAdapter.notifyItemRangeChanged(0, simpleAdapter.itemCount)
            }
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}