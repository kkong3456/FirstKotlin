package com.example.firstkotlin

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


class PermissionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permission)

        findViewById<TextView>(R.id.askPermission).setOnClickListener {
            var camerPermission=ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.CAMERA
            )
            //카메라 권한이 없는 경우
            if(camerPermission!= PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(android.Manifest.permission.CAMERA), //승인요청할 권한을 배열로...
                    1000,
                )
            }else{
                //있는 경우
                Log.d("xxx","카메라권한 있음")
            }
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode==1000){
            //우리가 보낸 권한 요청이 맞다면
            if(grantResults[0]==PackageManager.PERMISSION_GRANTED){ //승인요청 결과값은 배열로...
                Log.d("xxx","승인")
            }else{
                Log.d("xxx","승인거부")
            }
        }
    }
}