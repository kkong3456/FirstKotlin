package com.example.firstkotlin

import android.content.Intent
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat

class AddViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_view)

        var carList:MutableList<Car> = mutableListOf()

        for(i in 1..100){
            carList.add(Car(""+i+"번째 자동차",""+i+"번째 엔진"))
        }

        var container=findViewById<LinearLayoutCompat>(R.id.container)
        var inflater= LayoutInflater.from(this@AddViewActivity)

        //inflater를 반복적으로 사용하는 것은 비효율 적이다.
        carList.forEach{
            val carItemView=inflater.inflate(R.layout.car_item,null)
            var carImage=carItemView.findViewById<ImageView>(R.id.carImage)
            var nthCar=carItemView.findViewById<TextView>(R.id.nthCar)
            var nthEngin=carItemView.findViewById<TextView>(R.id.nthEngine)

            carImage.setImageDrawable(resources.getDrawable(R.drawable.khe_works1,this.theme))
            nthCar.text=it.nthCar
            nthEngin.text=it.nthEngine

            container.addView(carItemView)  //부모뷰안에 넣기
        }

    }
}

class Car(val nthCar:String,val nthEngine:String)