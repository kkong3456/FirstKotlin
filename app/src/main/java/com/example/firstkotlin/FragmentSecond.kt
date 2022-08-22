package com.example.firstkotlin

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class FragmentSecond : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //inflator : XML을 화면에 사용할 준비를 한다., XML을 뷰로 만들어 준다.
        //container : 프래그먼트에서 사용될 XML의 부모뷰
        //savedInstanceState : 개발자가 사용할 일은 없다.
        val view=inflater.inflate(R.layout.second_fragment,container,false)
        //attachToRoot : true면 지금 부모뷰에 attach, false면 나중에...attach

        (view.findViewById<TextView>(R.id.call_activity)).setOnClickListener{
            (activity as FragmentActivity).printTestLog()
        }
        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val data:String?=arguments?.getString("key")
        Log.d("testt","data is $data")
    }

    fun printTestLog(){
        Log.d("testt","메인 액티비티에서 프래그먼트 액티비티에 있는 메소드에 접근하여 실행시켰습니다..")
    }
}