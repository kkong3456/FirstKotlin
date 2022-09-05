package com.example.firstkotlin

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
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
    lateinit var retrofitService: RetrofitService

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.insta_feed_fragment,container,false)
    }

    fun postLike(post_id:Int){
        Log.d("xxx","postLike execute ${post_id}")
        retrofitService.postLike(post_id).enqueue(object:Callback<Any>{

            override fun onResponse(call: Call<Any>, response: Response<Any>) {
                Toast.makeText(activity,"좋아요",Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<Any>, t: Throwable) {
                Toast.makeText(activity,"좋아요 실패",Toast.LENGTH_SHORT).show()
            }
        })
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val feedListView=view.findViewById<RecyclerView>(R.id.feed_list)

        val retrofit= Retrofit.Builder()
            .baseUrl("http://mellowcode.org")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofitService=retrofit.create(RetrofitService::class.java)
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
                        Glide.with(activity!!),
                        this@InstaFeedFragment,
                        activity as (InstaMainActivity)
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
    val glide:RequestManager,
    val instaFeedFragment: InstaFeedFragment,
    val activity: InstaMainActivity
):RecyclerView.Adapter<PostRecyclerViewAdapter.ViewHolder>(){

    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val ownerImg:ImageView
        var ownerUsername: TextView
        val postImg:ImageView
        val postContent:TextView

        val postLayer:ImageView
        val postHeart:ImageView

        init{
            ownerImg=itemView.findViewById(R.id.owner_img)
            ownerUsername=itemView.findViewById(R.id.owner_username)
            postImg=itemView.findViewById(R.id.post_img)
            postContent=itemView.findViewById(R.id.post_content)

            postLayer=itemView.findViewById<ImageView>(R.id.post_layer)
            postHeart=itemView.findViewById<ImageView>(R.id.post_heart)

            postImg.setOnClickListener {
               instaFeedFragment.postLike(postList.get(adapterPosition).id)
               Thread{
                   activity.runOnUiThread {
                       postLayer.visibility=VISIBLE
                       postHeart.visibility=VISIBLE
                   }

                       Thread.sleep(2000)
                   activity.runOnUiThread {
                       postLayer.visibility= INVISIBLE
                       postHeart.visibility= INVISIBLE
                   }
               }.start()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.insta_feed_post_item,parent,false))
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