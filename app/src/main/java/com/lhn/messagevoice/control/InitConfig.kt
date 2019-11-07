package com.baidu.tts.sample.control

import com.baidu.tts.client.SpeechSynthesizerListener
import com.baidu.tts.client.TtsMode

/**
 * 合成引擎的初始化参数
 *
 *
 * Created by fujiayi on 2017/9/13.
 */

class InitConfig {
    /**
     * appId appKey 和 secretKey。注意如果需要离线合成功能,请在您申请的应用中填写包名。
     * 本demo的包名是com.baidu.tts.sample，定义在build.gradle中。
     */
    lateinit var appId: String

    lateinit var appKey: String

    lateinit var secretKey: String

    /**
     * 纯在线或者离在线融合
     */
    lateinit var ttsMode: TtsMode


    /**
     * 初始化的其它参数，用于setParam
     */
    lateinit var params: Map<String, String>

    /**
     * 合成引擎的回调
     */
    lateinit var listener: SpeechSynthesizerListener

    private constructor() {

    }

    constructor(appId: String, appKey: String, secretKey: String, ttsMode: TtsMode,
                params: Map<String, String>, listener: SpeechSynthesizerListener) {
        this.appId = appId
        this.appKey = appKey
        this.secretKey = secretKey
        this.ttsMode = ttsMode
        this.params = params
        this.listener = listener
    }
}
