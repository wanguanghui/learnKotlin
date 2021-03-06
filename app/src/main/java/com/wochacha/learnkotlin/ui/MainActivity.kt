package com.wochacha.learnkotlin.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.wochacha.learnkotlin.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_simple.setOnClickListener {
//            navigate<SimpleTestActivity>()
            startActivity(Intent(this, SimpleTestActivity::class.java))
        }

        btn_request.setOnClickListener {
            navigate<RequestAndShowActivity>()
        }
    }

    inline fun <reified T : Activity> Activity.navigate(bundle: Bundle? = null) {
        val intent = Intent(this, T::class.java)
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        startActivity(intent)
    }
}
