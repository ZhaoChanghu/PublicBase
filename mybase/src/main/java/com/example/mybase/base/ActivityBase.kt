package com.example.mybase.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 *  作者:zch
 *  时间:2022/3/25 10:40
 *  描述:所有Activity的基类
 */
abstract class ActivityBase<V: ViewDataBinding,VM: ViewModel> (
    var layoutId: Int,
    var viewModel: VM
) : AppCompatActivity() {

    lateinit var mDataBind: V
    lateinit var mViewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mDataBind = DataBindingUtil.setContentView(this, layoutId)
        initViewModel()
        initData()
    }

    private fun initViewModel(){
        mViewModel = ViewModelProvider(this).get(viewModel::class.java)
    }
    open fun initData(){

    }
}