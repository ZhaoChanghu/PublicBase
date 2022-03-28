package com.example.mykotlin

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.mybase.base.ActivityBase
import com.example.mykotlin.databinding.ActivityMainBinding

@SuppressLint("SetTextI18n")
class MainActivity : ActivityBase<ActivityMainBinding,MainViewModel>(
    R.layout.activity_main,
    MainViewModel()
) {

    val ok =  MutableLiveData<String>()


    override fun initData() {
        //这里需要单独为xml与ViewModel进行绑定
        mDataBind.viewModel = mViewModel
        mViewModel.myText.set(mViewModel.str)

        mViewModel.LOGIN_OK.observe(this){
           // mDataBind.tv.text = it;
        }
        mViewModel.LOGIN_OK1.observe(this){
            mDataBind.tv.text = it;
        }

        ok.postValue("我有变化")
        ok.observe(this){
            Toast.makeText(this,it,Toast.LENGTH_SHORT).show()
        }
    }

}