//package com.smartstudy.uskid.library.base
//
//import android.arch.lifecycle.LifecycleOwner
//import android.arch.lifecycle.LifecycleRegistry
//import android.support.v7.app.AppCompatActivity
//
///**
// * @author 赵珊珊
// * @date 2017/12/6
// */
//open class LifecycleAppCompatActivity : AppCompatActivity(), LifecycleOwner {
//
//    private val registry = LifecycleRegistry(this)
//
//    override fun getLifecycle(): LifecycleRegistry = registry
//
//}