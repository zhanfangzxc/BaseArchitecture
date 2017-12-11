//package com.smartstudy.uskid.library.base
//
//import android.os.Bundle
//import com.smartstudy.uskid.library.utils.setupActionBar
//
///**
// * @author 赵珊珊
// *
// * @date 2017/12/6
// */
//
//abstract class BaseActivity : LifecycleAppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(contentResId)
//        setupActionBar(toolbarId) {
//            setDisplayHomeAsUpEnabled(true)
//            setDisplayShowHomeEnabled(true)
//        }
//    }
//
//    /**
//     * 获取ContentView的ID
//     */
//    abstract val contentResId: Int
//
//    /**
//     * 获取toolbarId
//     */
//    abstract val toolbarId: Int
//
//}
