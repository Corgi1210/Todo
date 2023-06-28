package com.example.toddoo


import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.toddoo.databinding.ActivityListBinding


class ListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListBinding
    private lateinit var todayList: ArrayList<Todo>
    private lateinit var todayAdapter: TodayAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        todayList = ArrayList()
        todayAdapter = TodayAdapter(todayList)
        todoListItem()
        binding.recycle.layoutManager = LinearLayoutManager(this)
        binding.recycle.setHasFixedSize(true)
        binding.recycle.adapter = todayAdapter



        fun showPopupMenu(view: View) {
            val popupMenu = PopupMenu(this, view)
            popupMenu.inflate(R.menu.menu)

            popupMenu.setOnMenuItemClickListener { item: MenuItem ->
                when (item.itemId) {
                    R.id.option_1 -> {
                        val intent =  Intent (this, ResultActivity::class.java)
                        startActivity(intent)
                        startActivityForResult(intent, 1)
                        true
                    }
                    R.id.option_2 -> {
                        true
                    }
                    R.id.option_3 -> {
                        // 处理选项 3 的操作
                        true
                    }
                    R.id.option_4 -> {
                        // 处理选项 4 的操作
                        true
                    }
                    else -> false
                }

            }

            popupMenu.show()
        }
        binding.Cr.setOnClickListener { view ->
            showPopupMenu(view)
        }

    }

    private fun todoListItem() {
        todayList.add(Todo("今天 要載胖子"))
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        data?.extras?.let {
            if (requestCode == 1 && resultCode == Activity.RESULT_OK)
            todayList.add(Todo("${it.getString("todo")}"))
        }


    }
}











