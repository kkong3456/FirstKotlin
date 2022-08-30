package com.example.firstkotlin

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.Serializable

class MellonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mellon)

        val retrofit= Retrofit.Builder()
            .baseUrl("http://mellowcode.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val retrofitService=retrofit.create(RetrofitService::class.java)
        retrofitService.getMelonItemList().enqueue(object:Callback<ArrayList<MelonItem>>{
            override fun onResponse(
                call: Call<ArrayList<MelonItem>>,
                response: Response<ArrayList<MelonItem>>
            ) {
                if(response.isSuccessful){
                    val melonItemList=response.body()
                        findViewById<RecyclerView>(R.id.melon_list_view).apply{
                            this.adapter=MelonItemRecyclerAdapter(
                                melonItemList!!,
                                LayoutInflater.from(this@MellonActivity),
                                Glide.with(this@MellonActivity),
                                this@MellonActivity
                            )
                    }
                }
            }

            override fun onFailure(call: Call<ArrayList<MelonItem>>, t: Throwable) {
                Log.d("xxx","통신실패")
            }
        })
    }
}

class MelonItemRecyclerAdapter(
    val melonItemList:ArrayList<MelonItem>,
    val inflater: LayoutInflater,
    val glide: RequestManager,
    val context: Context
):RecyclerView.Adapter<MelonItemRecyclerAdapter.ViewHolder>(){
    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val title: TextView
        val thumbnail:ImageView
        val play:ImageView

        init{
            title=itemView.findViewById<TextView>(R.id.title)
            thumbnail=itemView.findViewById<ImageView>(R.id.thumbnail)
            play=itemView.findViewById<ImageView>(R.id.play)

            play.setOnClickListener{
                val intent= Intent(context,MellonDetailActivity::class.java)
                intent.putExtra("melon_item_list",melonItemList as Serializable)
                intent.putExtra("position",adapterPosition)
                context.startActivity(intent)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=inflater.inflate(R.layout.melon_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text=melonItemList.get(position).title
        glide.load(melonItemList.get(position).thumbnail).centerCrop().into(holder.thumbnail)
    }

    override fun getItemCount(): Int {
        return melonItemList.size
    }
}