package com.example.firstkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class FragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        val fragmentManager=supportFragmentManager
        val fragmentFirst=FragmentFirst()

        //Transaction
        //작업의 관리 : 시작과 끝이 있다.
        //commit 의 종류
        //1. commit //2. commitAllowingStateLoss //3. commitNow //4. commitNowAllowingStateLoss
        //commit - commitAllowingStateLoss
        //AllowingStateLoss : onStop,lifecycle 혹은 OS에 의해서 앱이 상태 저장해야 할 수 있다.
        //commit : 저장시 IlegalStateException에러 발생
        //commitAllowingStateLoss : 저장시 일부 상태 손실이 있어도 예외발생안됨.

        //commit - commitNow
        //commit : 작업을 예약한다(메인쓰레드에 예약되어서, 실행된다)
        //commitNow : 바로 당장 실행된다.



//        val trans1=fragmentManager.beginTransaction()
//        trans1.replace(R.id.root,fragmentFirst)
//        trans1.commit()


        (findViewById<TextView>(R.id.add)).setOnClickListener{
            val transaction=fragmentManager.beginTransaction() //트랜잭션 시작

            //프래그먼트에 데이터를 전달하는 방법
            val bundle=Bundle()
            bundle.putString("key","메인 액티비티에서 프래그먼트로 데이터를 전달하였습니다.")
            fragmentFirst.arguments=bundle

            transaction.replace(R.id.root,fragmentFirst,"fragment_first_tag")
            transaction.commit() // 트랜잭션 끝.이분분이 없으면 트랜잭션이 실행되지 않느다.
        }
        (findViewById<TextView>(R.id.remove)).setOnClickListener{
            var trans=fragmentManager.beginTransaction()
            trans.remove(fragmentFirst)
            trans.commit()
        }

        (findViewById<TextView>(R.id.access_fragment)).setOnClickListener{
            //액티비티에서 프래그먼트 접근하기
            //1. XML에 있는 프래그먼트 찾는 방법
            //val fragmentFirst=supportFragmentManager.findFragmentById(R.id.fragment_first) as FragmentFirst
            //fragmentFirst.printTestLog()

            //2. XML이 없는, 코드로 작성된 프래그먼트 찾는 법, tag를 이용한다,tag를 단 객체를 먼저 실행시켜야 됨
            val fragmentFirst = supportFragmentManager.findFragmentByTag("fragment_first_tag") as FragmentFirst
            fragmentFirst.printTestLog()
        }
    }

    fun printTestLog(){
        Log.d("testt","프래그먼트에서 메인 액티비티의 메소드를 실행시켰습니다.")
    }
}