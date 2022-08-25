package com.example.firstkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE

class RoomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        //기본적으로 데이터베이스 작업은 메인 쓰레드에서 할수 없다.
        //이유는, 데이터베이스 작업을 하는 동안 사용자가 기다려야 하기 때문
        //해결책은 쓰레드를 이용하거나 비동기 async를 이용한다
        val database=Room.databaseBuilder(
            applicationContext,
            UserDatabase::class.java,
            "user-database"
        ).allowMainThreadQueries().build() //메인쓰레드를 사용했다. 편의상

        findViewById<TextView>(R.id.save).setOnClickListener {
            val userProfile=UserProfile("길동","홍")
            database.userProfileDao().insert(userProfile)
        }

        findViewById<TextView>(R.id.load).setOnClickListener {
            val userProfiles:List<UserProfile> = database.userProfileDao().getAll()

            userProfiles.forEach{
                Log.d("xxx","id is ${it.id} and name is ${it.firstName}")
            }
        }

        findViewById<TextView>(R.id.delete).setOnClickListener{
            database.userProfileDao().delete(1)

        }
    }
}

//DataBase 라고 생각하면 될 듯
@Database(entities = [UserProfile::class], version = 1)
abstract class UserDatabase:RoomDatabase(){
    abstract fun userProfileDao():UserProfileDao
}

//Data Accecss Object, 테이블의 테이터 조작
@Dao
interface UserProfileDao{
    @Insert(onConflict=REPLACE)
    fun insert(userProfile:UserProfile)

    @Query("DELETE FROM userprofile WHERE id=:userId")
    fun delete(userId:Int)

    @Query("SELECT * FROM userprofile")
    fun getAll():List<UserProfile>
}

//테이블로 생각하면 될 듯
@Entity
class UserProfile(
    @PrimaryKey(autoGenerate = true) val id:Int,

    @ColumnInfo(name="last_name")
    val lastName:String,
    @ColumnInfo(name="first_name")
    val firstName:String,
){
    constructor(lastName:String,firstName: String):this( 0,lastName,firstName)
}