package com.example.firstkotlin

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class InstaFeedFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.insta_feed_fragment,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val feedListView=view.findViewById<RecyclerView>(R.id.feed_list)

        val retrofit= Retrofit.Builder()
            .baseUrl("http://mellowcode.org")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val retrofitService=retrofit.create(RetrofitService::class.java)
        retrofitService.getInstagramPosts().enqueue(object :Callback<ArrayList<InstaPost>>{
            override fun onResponse(
                call: Call<ArrayList<InstaPost>>,
                response: Response<ArrayList<InstaPost>>
            ) {
                if(response.isSuccessful){
                    val postList=response.body()

                    val postRecyclerView=view.findViewById<RecyclerView>(R.id.feed_list)
                    postRecyclerView.adapter=PostRecyclerViewAdapter(
                        postList!!,
                        LayoutInflater.from(activity),
                        Glide.with(activity!!)

                    )
                }
            }

            override fun onFailure(call: Call<ArrayList<InstaPost>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

    }
}

class PostRecyclerViewAdapter(
    val postList:ArrayList<InstaPost>,
    val inflater: LayoutInflater,
    val glide:RequestManager
):RecyclerView.Adapter<PostRecyclerViewAdapter.ViewHolder>(){

    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val ownerImg:ImageView
        var ownerUsername: TextView
        val postImg:ImageView
        val postContent:TextView

        init{
            ownerImg=itemView.findViewById(R.id.owner_img)
            ownerUsername=itemView.findViewById(R.id.owner_username)
            postImg=itemView.findViewById(R.id.post_img)
            postContent=itemView.findViewById(R.id.post_content)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.i   nsta_feed_post_item,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post=postList.get(position)
        holder.ownerUsername.text=post.owner_profile.username
        holder.postContent.text=post.content

        post.owner_profile.image?.let{
            glide.load(it).circleCrop().into(holder.ownerImg) //it => post.owner_profile.image
        }
        post.image?.let{
            glide.load(it).centerCrop().into(holder.postImg)
        }
    }

    override fun getItemCount(): Int {
        return postList.size
    }
}