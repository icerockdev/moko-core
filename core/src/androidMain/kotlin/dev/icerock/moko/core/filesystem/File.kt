/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package dev.icerock.moko.core.filesystem

import android.util.Base64
import android.webkit.MimeTypeMap

actual fun File.getFileName(): String {
    return java.io.File(this.path).name
}

actual fun File.toBase64(): String {
    val file = java.io.File(this.path)

    return Base64.encodeToString(file.readBytes(), Base64.DEFAULT)
}

actual fun File.getMimeType(): String? {
    val file = java.io.File(this.path)
    return MimeTypeMap.getSingleton().getMimeTypeFromExtension(file.extension)
}
