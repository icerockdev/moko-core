/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package dev.icerock.moko.core

import platform.darwin.DISPATCH_TIME_NOW
import platform.darwin.dispatch_after
import platform.darwin.dispatch_get_main_queue
import platform.darwin.dispatch_time

actual class Timer actual constructor(
    actual val intervalMilliSeconds: Long,
    private val block: () -> Boolean
) {
    private val runQueue = dispatch_get_main_queue()
    private var currentTimerRun: Long = Long.MIN_VALUE

    actual fun start() {
        scheduleDispatch(currentTimerRun)
    }

    actual fun stop() {
        // up run & current runned block not execute
        currentTimerRun++
        if (currentTimerRun == Long.MAX_VALUE) {
            currentTimerRun = Long.MIN_VALUE
        }
    }

    private fun scheduleDispatch(run: Long) {
        dispatch_after(
            dispatch_time(DISPATCH_TIME_NOW, intervalMilliSeconds * NSEC_PER_MILLISEC),
            runQueue
        ) {
            if (currentTimerRun != run) return@dispatch_after

            if (block()) {
                scheduleDispatch(run)
            }
        }
    }

    private companion object {
        const val NSEC_PER_MILLISEC = 1000000
    }
}
