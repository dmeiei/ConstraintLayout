package kr.ac.hallym.constraintlayout_test

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import android.widget.Toast


//리스트 뷰 연결 코드 건들이지 X

class ExpandableListViewAdapter internal constructor(
    private val context: Context,
    private val chapterList : List<String>,
    private val topicList: HashMap<String, List<String>>
    ): BaseExpandableListAdapter() {

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        return this.topicList[this.chapterList[groupPosition]]!![childPosition]
    }

    override fun getChildId(groupPositionp0: Int, childPosition: Int): Long {

        return childPosition.toLong()
    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        var convertView = convertView
        val topicTitle = getChild(groupPosition, childPosition) as String

        if (convertView == null){

            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.topics_list, null)
        }

        val topicTv = convertView!!.findViewById<TextView>(R.id.topics_tv)
        topicTv.setText(topicTitle)

        return convertView
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return this.topicList[this.chapterList[groupPosition]]!!.size
    }

    override fun getGroup(groupPosition: Int): Any {
        return chapterList[groupPosition]
    }

    override fun getGroupCount(): Int {

        return chapterList.size
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup?): View {
        var convertView = convertView
        val chapterTitle = getGroup(groupPosition) as String

        if (convertView == null){

            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.chapter_list, null)
        }

        val chapterTv = convertView!!.findViewById<TextView>(R.id.chapter_tv)
        chapterTv.setText(chapterTitle)

        return convertView
    }


    override fun hasStableIds(): Boolean {
        return false
    }


    override fun isChildSelectable(p0: Int, p1: Int): Boolean {
        return true
    }

}
