package com.example.mykotlin

import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.example.mybase.base.ViewModelBase

/**
 *  作者:zch
 *  时间:2022/3/25 11:29
 *  描述:ViewModel
 */
class MainViewModel: ViewModelBase<MainModel>(
    MainModel()
){

    var str = "我是一个文本框"
    var text = "我被点击了"

    var myShow = ObservableField<Boolean>(true) //是否显示清除用户名图标
    var myText: ObservableField<String> = ObservableField("") //用户名文本框数据绑定


    val LOGIN_OK = SingleLiveEvent<String>() //登录事件
    val LOGIN_OK1 =  MutableLiveData<String>()


    fun onClick(v: View){
        myText.set(if (myShow.get()!!) text else str)
        myShow.set(!myShow.get()!!)
        LOGIN_OK.postValue("被点击了")
        LOGIN_OK1.postValue("iiiii")
    }

}