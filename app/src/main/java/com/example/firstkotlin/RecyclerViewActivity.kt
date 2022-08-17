package com.example.firstkotlin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        val carList:MutableList<Car> = mutableListOf<Car>()

        for(i in 1..100){
            carList.add(Car(""+i+"번째 차",""+i+"번째 엔진"))
        }

        //어댑터 장착
        val recyclerView=findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter=RecyclerViewAdapter(carList,LayoutInflater.from(this),this)

        //리사이클러에 레이아웃 매니저 장착
        recyclerView.layoutManager=LinearLayoutManager(this, LinearLayoutManager.VERTICAL,true)
//        recyclerView.layoutManager=LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
//         recyclerView.layoutManager=GridLayoutManager(this,2)

    }
}

class RecyclerViewAdapter(
    var carList:MutableList<Car>,
    var inflater: LayoutInflater,
    val context: Context
): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){
    //내부 클래스로 뷰홀더 정의
    //뷰홀더는 xml의 객체를 id 로 가져와서 액티비티에서 사용할 수 있는 변수(객체)를 담는다
   inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val carImage:ImageView
        val nthCar:TextView
        val nthEngine: TextView

        init{
            carImage=itemView.findViewById<ImageView>(R.id.carImage)
            nthCar=itemView.findViewById<TextView>(R.id.nthCar)
            nthEngine= itemView.findViewById<TextView>(R.id.nthEngine)
            // 각 아이템의 리스너를 여기서 기술해야 함
            itemView.setOnClickListener{
                val position:Int=adapterPosition  //리사이클러 클래서 변수, 몇번째 아이템이 클리 되었는지 알려준다
                val car=carList.get(position) //inner 클래스 지시자를 붙여주여야 밖의 클래스 변수 carList를 사용할 수 있다.
                Log.d("xxx",""+car.nthCar)
            }
        }
    }

    //각각의 아이템 뷰를 리턴
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=inflater.inflate(R.layout.car_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.carImage.setImageDrawable(context.resources.getDrawable(R.drawable.khe_works1))
        holder.nthCar.text=carList.get(position).nthCar
        holder.nthEngine.text=carList.get(position).nthEngine
    }

    override fun getItemCount(): Int {
        return carList.size
    }
}