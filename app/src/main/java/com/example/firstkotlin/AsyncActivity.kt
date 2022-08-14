package com.example.firstkotlin

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import android.widget.TextView
import androidx.loader.content.AsyncTaskLoader

class AsyncActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async)

        val backgroundAsyncTask=BackgroundAsyncTask(
            findViewById(R.id.progressBar),
            findViewById(R.id.progressBarText)
        )
        findViewById<TextView>(R.id.start).setOnClickListener{
            backgroundAsyncTask.execute()
        }
        findViewById<TextView>(R.id.stop).setOnClickListener{
            backgroundAsyncTask.cancel(true)
        }
        findViewById<TextView>(R.id.shot).setOnClickListener{
            Log.d("testt","SHOT!!")
        }
    }
}

class BackgroundAsyncTask(
    val progressBar: ProgressBar,
    val progressText: TextView
): AsyncTask<Int, Int, Int>() {
    //세가지 인자는 params,progress,result이며 정수형이다.
    //params : doInBackground에서 사용할 타입
    //progress : onProgressUpdate에서 사용할 타입
    //result : onPostExecute에서 사용할 타입

    var percent:Int=0
    override fun doInBackground(vararg params: Int?): Int {
        while(isCancelled==false){
            percent++
            Thread.sleep(100)

//            Log.d("testt",""+percent)
            if(percent>100) break
            else{
                publishProgress(percent) //onProgressUpdate에 value값에 전달됨
            }
        }
        return percent
    }

    //Async 동작이 실행되기전
    override fun onPreExecute() {
        percent=0
        progressBar.setProgress(percent)

    }
    // 동작 완료이후
    override fun onPostExecute(result: Int?) {
        progressText.text="작업이 완료되었습니다."
    }

    override fun onProgressUpdate(vararg values: Int?) {
//        Log.d("testt","진행중 : ${values[0]}")
        progressBar.setProgress(values[0]?:0)
        progressText.text="퍼센터 : ${values[0]}"
        super.onProgressUpdate(*values)
    }

    override fun onCancelled() {
        progressBar.setProgress(0)
        progressText.text="작업이 취소되었습니다."
    }

}