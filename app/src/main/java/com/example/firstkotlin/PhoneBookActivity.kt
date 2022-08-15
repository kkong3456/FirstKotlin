package com.example.firstkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import java.util.zip.Inflater

class PhoneBookActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_book)

        var phoneBookList:MutableList<PhoneBook> = mutableListOf<PhoneBook>()

        for(i in 0..40){
            phoneBookList.add(PhoneBook(""+i+"번째 사람","010-0000-000"+i))
        }

        var container:LinearLayoutCompat=findViewById(R.id.container)
        val inflater: LayoutInflater = LayoutInflater.from(this)

        phoneBookList.forEach{ phonebook->
            val phonebookItem=inflater.inflate(R.layout.phonebook_item,null)
            val image=phonebookItem.findViewById<ImageView>(R.id.image)
            val name=phonebookItem.findViewById<TextView>(R.id.name)
            val number=phonebookItem.findViewById<TextView>(R.id.number)



            image.setImageDrawable(resources.getDrawable(R.drawable.logo_kt))
            name.text=phonebook.name
            number.text=phonebook.number

            phonebookItem.setOnClickListener{
//                Log.d("kkong","ok")
                startActivity(
                    Intent(this,PhoneBookDetailActivity::class.java).apply{
                        this.putExtra("name",phonebook.name)
                        this.putExtra("number",phonebook.number)
                    }
                )
            }

            container.addView(phonebookItem)
        }
    }
}

class PhoneBook(val name:String,val number:String)