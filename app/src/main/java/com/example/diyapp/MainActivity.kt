package com.example.diyapp


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /** 버튼 클릭시 레이아웃 변경 */
    override fun onClick(v: View?) {
        when(v?.id)
        {
            R.id.buttonCurrent->{
                var tView = findViewById<TextView>(R.id.buttonCurrent)
                tView.setText("짠")
            }
            R.id.buttonABC->{
                val intent = Intent(this, SubActivity::class.java)
                startActivity(intent)
            }
            R.id.buttonColor->{
                val intent = Intent(this, SubActivity::class.java)
                startActivity(intent)
            }
            R.id.buttonCategory->{
                val intent = Intent(this, SubActivity::class.java)
                startActivity(intent)
            }
        }
    }
}