package com.smartstudy.uskid.library.utils

import android.content.Context
import android.net.ConnectivityManager

/**
 * @author 赵珊珊
 * @date 2017/12/6
 */
class NetUtil(private var applicationContext: Context) {

    /**
     * 网络是否可用
     */
    val isConnectedToInternet: Boolean?
        get() {

            val conManager = applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE)
                    as ConnectivityManager

            val ni = conManager.activeNetworkInfo
            return ni != null && ni.isConnected
        }
}