package com.example.mykotlin

import android.util.Log
import androidx.annotation.MainThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import java.util.concurrent.atomic.AtomicBoolean

/**
 * 重写LiveData实现观察者模式，用来传递消息，更新UI
 * */
class SingleLiveEvent<T> : MutableLiveData<T?>() {
    private val mPending = AtomicBoolean(false)

    override fun observe(owner: LifecycleOwner, observer: Observer<in T?>) {
        if (hasActiveObservers()){
            Log.w(
                TAG,
                "Multiple observers registered but only one will be notified of changes."
            )
        }

        super.observe(owner, Observer { t: T? ->
            if (mPending.compareAndSet(true,false)){
                observer.onChanged(t)
            }
        })
    }

    @MainThread
    override fun setValue(t: T?) {
        mPending.set(true)
        super.setValue(t)
    }

    @MainThread
    fun call(){
        value = null
    }

    companion object{
        private const val TAG = "SingleLiveEvent"
    }
}