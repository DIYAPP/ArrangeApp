package com.example.diyapp

import android.app.Application
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_arrange.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    lateinit var recycleAdapter: ArrangeListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycleAdapter = ArrangeListAdapter(this);
        val data = recycleAdapter.getDataList();
        recycler_view.adapter = recycleAdapter;
        recycleAdapter.datas = data
        recycleAdapter.notifyDataSetChanged()

        recycler_view.addItemDecoration(ItemDecorator.Vertical(20))

        recycleAdapter.setOnItemClickListener(object : ArrangeListAdapter.OnItemClickListener{
            override fun onClick(v: View, data: arrangeViewitem, pos : Int) {
                Intent(this@MainActivity, AppList::class.java).apply{
                    /* intent로 정렬 방법을 넘겨준다 */
                    putExtra("arrangeName", data.name)
                }.run {
                    startActivity(this)
                }
            }
        })


    }

    /** 버튼 클릭시 레이아웃 변경 + 버튼 클릭시 정렬 방식 변경*/
    /*
    override fun onClick(v: View?) {
        when(v?.id)
        {
            R.id.buttonCurrent->{
                method = 0
                val intent = Intent(this, SubActivity::class.java)
                startActivity(intent)
                //var tView = findViewById<TextView>(R.id.buttonCurrent)
                //tView.setText("Your app")
            }
            R.id.buttonABC->{
                method = 1
                val intent = Intent(this, SubActivity::class.java)
                startActivity(intent)
            }
            R.id.buttonColor->{
                method = 2
                val intent = Intent(this, SubActivity::class.java)
                startActivity(intent)
            }
            R.id.buttonCategory->{
                method = 3
                val intent = Intent(this, SubActivity::class.java)
                startActivity(intent)
            }
        }
    }
    */
}