package com.wjp.eventbusdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    @Subscribe
    fun onEvent(str: String) {
        Toast.makeText(this, "MainActivity receive:$str", Toast.LENGTH_SHORT).show()
    }

    fun register(view: View) {
        EventBus.getDefault().register(this)
    }

    fun unRegister(view: View) {
        EventBus.getDefault().unregister(this)
    }

    fun toNext(view: View) {
        startActivity(Intent(this, Main2Activity::class.java))
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onIntEVent(int: Integer) {
        var count=0
        try {
            while (count < 10) {
                Log.d("wolf", "count:$count")
                count++
                Thread.sleep(1000)
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }


}

