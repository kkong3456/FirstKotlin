package com.example.firstkotlin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewTestActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_test)

        val userList:MutableList<DataVo> = mutableListOf(
            DataVo("공석훈","kkong","성북구",1000,"xxx1.png"),
            DataVo("안은실","ahn","서귀포시",15000,"xxx2.png"),
            DataVo("공하은","khe","동대문구",20000,"xxx3.png")
        )

        val recyclerTestView=findViewById<RecyclerView>(R.id.recyclerTestView)
        recyclerTestView.adapter=CustomAdapter(this,userList, LayoutInflater.from(this))

        recyclerTestView.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
    }
}

class CustomAdapter(
    val context: Context,
    val userList:MutableList<DataVo>,
    val inflater:LayoutInflater
):RecyclerView.Adapter<CustomAdapter.itemViewHolder>(){
    inner class itemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val userPhoto = itemView.findViewById<ImageView>(R.id.userImg)
        val userName = itemView.findViewById<TextView>(R.id.userNameTxt)
        val userPay=itemView.findViewById<TextView>(R.id.payTxt)
        val userAddress:TextView=itemView.findViewById(R.id.addressTxt)

        init{
            itemView.setOnClickListener{
                val position:Int=adapterPosition
                val user=userList.get(position)
                Log.d("xxx","${user.name}은 ${user.address}에 잘 살고 있습니다.")
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemViewHolder {
        val view=inflater.inflate(R.layout.address_item,parent,false)
        return itemViewHolder(view)
    }

    override fun onBindViewHolder(holder: itemViewHolder, position: Int) {
        holder.userPhoto.setImageDrawable(context.resources.getDrawable(R.drawable.khe_works1))
        holder.userName.text=userList.get(position).name
        holder.userPay.text=userList.get(position).pay.toString()
        holder.userAddress.text=userList.get(position).address
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}

class DataVo(val name:String, val valid:String, val address:String, val pay:Int, val photo:String)