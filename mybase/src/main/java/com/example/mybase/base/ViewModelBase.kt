package com.example.mybase.base

import androidx.lifecycle.ViewModel

/**
 *  作者:zch
 *  时间:2022/3/25 10:55
 *  描述:所有ViewModel的基类
 */
abstract class ViewModelBase<M: ModelBase>(
    val mModel: M
): ViewModel()