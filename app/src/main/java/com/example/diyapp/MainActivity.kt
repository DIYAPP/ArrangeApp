package com.example.diyapp

import android.app.Application
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

/** 정렬 방식을 변수로 구분 **/
class sortmethod: Application() {
    lateinit var context: Context
    init{method=0}
    companion object{
        var method = 0
    }
}

class MainActivity : AppCompatActivity(){

    lateinit var recycleAdapter: RecycleViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycleAdapter = RecycleViewAdapter(this);
        val data = recycleAdapter.getDataList();
        recycle_view.adapter = recycleAdapter;
        recycleAdapter.datas = data
        recycleAdapter.notifyDataSetChanged()


/*
        recycleAdapter.setOnItemClickListener(object : RecycleViewAdapter.OnItemClickListener{
            override fun onClick(v: View, data: recycleViewitem, pos : Int) {
                Intent(v.context, SubActivity::class.java).run {
                    putExtra("name", "name2")
                    startActivity(this)
                }
            }
        })
        */
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