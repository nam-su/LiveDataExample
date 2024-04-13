package com.example.livedata_aac

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class MainViewModel : ViewModel() {

    var _name: MutableLiveData<String> = MutableLiveData<String>()

    fun setName() {

        val i: Int = Random.nextInt(3);
        var nameValue: String = ""

        when(i) {

            0 -> nameValue = "Sam"
            1 -> nameValue = "31"
            2 -> nameValue = "독서"

        }

        Log.d("뷰모델", "setName: $nameValue")
        _name.value = nameValue

    }

}