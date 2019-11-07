package com.lhn.messagevoice

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.AccessibilityServiceInfo
import android.app.Service
import android.content.Context
import android.content.Intent
import android.content.pm.ServiceInfo
import android.os.IBinder
import android.view.accessibility.AccessibilityEvent

class MessageListen : AccessibilityService() {
    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        println("收到事件:$event")

    }

    override fun onInterrupt() {
        println("关闭服务")
    }

    override fun onServiceConnected() {
        println("启动服务")
        super.onServiceConnected()
        //设置serviceInfo
        serviceInfo.feedbackType = AccessibilityServiceInfo.FEEDBACK_AUDIBLE
        serviceInfo.eventTypes = AccessibilityEvent.TYPE_NOTIFICATION_STATE_CHANGED
        //加载设定的监听的包
        var pref = applicationContext.getSharedPreferences("listen", Context.MODE_PRIVATE)
        var sets = pref.getStringSet("packages", null)
        serviceInfo.packageNames = sets?.toTypedArray()
        serviceInfo.notificationTimeout = 1000


    }

}
