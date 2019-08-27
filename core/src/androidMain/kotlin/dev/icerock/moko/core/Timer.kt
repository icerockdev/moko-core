/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package dev.icerock.moko.core

import android.os.Handler
import android.os.Looper

actual class Timer actual constructor(
    actual val intervalMilliSeconds: Long,
    block: () -> Boolean
) {

    private val handler = Handler(Looper.getMainLooper())
    private val runnable = object : Runnable {
        override fun run() {
            if (block()) {
                handler.postDelayed(this, intervalMilliSeconds)
            }
        }
    }

    actual fun start() {
        handler.postDelayed(runnable, intervalMilliSeconds)
    }

    actual fun stop() {
        handler.removeCallbacks(runnable)
    }
}
