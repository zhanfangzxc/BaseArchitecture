package com.smartstudy.uskid.library.utils

import android.content.Context
import android.support.v4.app.Fragment
import android.view.View
import android.widget.Toast

/**
 * @author 赵珊珊
 * @date 2017/12/6
 */
fun Context.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    if (duration == Toast.LENGTH_SHORT) {
        Toast.makeText(this, message, duration).show()
    } else {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}

fun Fragment.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    activity?.toast(message, duration)
}

fun View.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    context.toast(message, duration)
}