/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package dev.icerock.moko.core

import platform.Foundation.NSDate
import platform.Foundation.timeIntervalSince1970

actual fun getCurrentMilliSeconds(): Long = (NSDate().timeIntervalSince1970 * 1000.0).toLong()
