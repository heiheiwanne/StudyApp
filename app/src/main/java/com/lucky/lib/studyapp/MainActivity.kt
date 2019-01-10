package com.lucky.lib.studyapp

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Example of a call to a native method
        sample_text.text = stringFromJNI()
        hello(this.localClassName)
    }

    private var handler:Handler = Handler {
        if (it.what == MESSAGE_KEY) {
            Log.e("xmq", it.obj as String?)
        }
        false
    }

    private fun hello(hello :String): Unit {
        val message = Message()
        message.what = MESSAGE_KEY
//        message.obj = hello
        handler.sendMessage(message)
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {
        const val MESSAGE_KEY = 0x101
        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}
