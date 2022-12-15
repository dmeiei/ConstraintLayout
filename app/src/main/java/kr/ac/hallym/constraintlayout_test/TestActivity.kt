package kr.ac.hallym.constraintlayout_test

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class TestActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)


        val next_page = findViewById<ImageButton>(R.id.next)
        val back_page = findViewById<ImageButton>(R.id.back)
        val pont1 = findViewById<ImageView>(R.id.pont1)
        val pont2 = findViewById<ImageView>(R.id.pont2)
        val pont3 = findViewById<ImageView>(R.id.pont3)

        //다음 페이지 넘기기
        next_page.setOnClickListener {
            if(pont1.visibility == View.VISIBLE){
                pont1.visibility = View.INVISIBLE
                pont2.visibility = View.VISIBLE
                pont3.visibility = View.INVISIBLE
            }
            else if(pont2.visibility == View.VISIBLE){
                pont1.visibility = View.INVISIBLE
                pont2.visibility = View.INVISIBLE
                pont3.visibility = View.VISIBLE
            }

        }

        //전 페이지로 돌아가기
        back_page.setOnClickListener {
            if(pont2.visibility == View.VISIBLE){
                pont2.visibility = View.INVISIBLE
                pont1.visibility = View.VISIBLE
                pont3.visibility = View.INVISIBLE
            }
            else if(pont3.visibility == View.VISIBLE){
                pont3.visibility = View.INVISIBLE
                pont1.visibility = View.INVISIBLE
                pont2.visibility = View.VISIBLE
            }
        }
    }
}