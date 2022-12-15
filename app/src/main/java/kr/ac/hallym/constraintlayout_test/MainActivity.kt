package kr.ac.hallym.constraintlayout_test

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Debug
import android.view.View
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {

    private lateinit var listViewAdapter: ExpandableListViewAdapter
    private lateinit var chapterList: List<String>
    private lateinit var topicList: HashMap<String, List<String>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        showList()

        listViewAdapter = ExpandableListViewAdapter(this, chapterList, topicList)

        val eListView1 = findViewById<ExpandableListView>(R.id.eListView)
        eListView1.setAdapter(listViewAdapter)


        eListView1!!.setOnChildClickListener { _, _, i, i2, _ ->

            if(topicList[(chapterList as ArrayList<String>)[i]]!!.get(i2) == "글자 크기조절"){
                val intent1 = Intent(this,TestActivity::class.java)
                startActivity(intent1)
            }
            false
        }

    }

    private fun showList(){
        chapterList = ArrayList()
        topicList = HashMap()

        (chapterList as ArrayList<String>).add("휴대폰 설정")
        (chapterList as ArrayList<String>).add("휴대전화 정보")
        (chapterList as ArrayList<String>).add("통화 설정안내")
        (chapterList as ArrayList<String>).add("문자 설정안내")
        (chapterList as ArrayList<String>).add("카카오톡 사용방법")
        (chapterList as ArrayList<String>).add("유튜브 사용방법")

        val topic1 : MutableList<String> = ArrayList()
        topic1.add("소리설정(미디어)")
        topic1.add("휴대폰 밝기조절")
        topic1.add("글자 크기조절")
        topic1.add("비행기모드 설정")
        topic1.add("화면 자동꺼짐 시간설정")
        topic1.add("화면잠금 설정")
        topic1.add("화면잠금 해제방법")
        topic1.add("LTE 설정")
        topic1.add("블루투스 켜기")
        topic1.add("블루투스 연결")
        topic1.add("와이파이(WIFI)연결")

        val topic2 : MutableList<String> = ArrayList()
        topic2.add("내 전화번호")
        topic2.add("배터리 사용량")

        val topic3 : MutableList<String> = ArrayList()
        topic3.add("벨소리 설정")
        topic3.add("통화볼륨 설정")
        topic3.add("단축번호 등록")
        topic3.add("전화 차단 방법")
        topic3.add("전화 거는 방법")
        topic3.add("번호 저장 방법")
        topic3.add("번호 삭제 방법")

        val topic4 : MutableList<String> = ArrayList()
        topic4.add("문자 보내는 방법")
        topic4.add("글씨 크기 설정")
        topic4.add("스팸보관함 확인")

        val topic5 : MutableList<String> = ArrayList()
        topic5.add("메세지 보내는 방법")
        topic5.add("사진 보내는 방법")
        topic5.add("동영상 보내는 방법")
        topic5.add("보이스톡 하는 방법")
        topic5.add("메시지 전달 하는 방법")

        val topic6 : MutableList<String> = ArrayList()
        topic6.add("로그인 방법")
        topic6.add("회원가입 방법")
        topic6.add("영상 검색하는 방법")
        topic6.add("영상 크게 보는 방법")
        topic6.add("영상 공유하는 방법")


        topicList[chapterList[0]] = topic1
        topicList[chapterList[1]] = topic2
        topicList[chapterList[2]] = topic3
        topicList[chapterList[3]] = topic4
        topicList[chapterList[4]] = topic5
        topicList[chapterList[5]] = topic6

    }



}