package com.wjp.eventbusdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import org.greenrobot.eventbus.EventBus
import kotlin.concurrent.thread

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


    }

    fun postMsg(view: View) {
//        EventBus.getDefault().post("hello")
        EventBus.getDefault().post("hello")
    }

    fun postMsgFromSubThread(view: View) {
        thread {
            EventBus.getDefault().post("from sub thread")
        }
    }

    fun postCountOnMain(view: View) {
        EventBus.getDefault().post(0)
        thread {
            Thread.sleep(3000)
            EventBus.getDefault().post(0)
        }
    }

    fun postCountOnSubThread(view: View) {
        thread {
            EventBus.getDefault().post(0)
        }

    }



}
