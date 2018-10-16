package com.lee.hippotally.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import cn.bmob.v3.Bmob
import cn.bmob.v3.exception.BmobException
import cn.bmob.v3.listener.SaveListener
import com.lee.hippotally.R
import com.lee.hippotally.bean.User
import com.lee.hippotally.const.Const

/**
 * 注册页面Activity
 */
class RegisterActivity : AppCompatActivity(),View.OnClickListener{

    private lateinit var etUserName :EditText
    private lateinit var etPassWord :EditText
    private lateinit var btnSubmit:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Bmob.initialize(this, Const.BMOB_APP_ID)

       etUserName= findViewById(R.id.et_username)
        etPassWord=findViewById(R.id.et_password)
        btnSubmit=findViewById(R.id.btn_submit)
        btnSubmit.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
      var  user:User=User()
        user.userName=etUserName.text.toString()
        user.passWord=etPassWord.text.toString()
        var saveListener:SaveListener<String>
        user.save(object : SaveListener<String>(){
            override fun done(p0: String?, p1: BmobException?) {
                 Toast.makeText(this@RegisterActivity,p0,Toast.LENGTH_LONG)
            }
        })
    }

}
