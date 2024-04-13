package com.example.livedata_aac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    lateinit var textView: TextView
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = MainViewModel()

        textView = findViewById(R.id.textView)
        button = findViewById(R.id.button)

        // 옵저버 객체를 만들어준다.
        val nameObserver = Observer<String> {

            name-> textView.text = name

        }

        // LifecycleOwner가 들어갈 인수에 this(Activity)를 넣었다.
        // Observer패턴을 따르기 때문에 한번 observe를 해놓으면 별도로 값을 계속 초기화 해주지 않아도 된다.
        mainViewModel._name.observe(this,nameObserver)

        button.setOnClickListener {

            mainViewModel.setName()

        }

    }

}