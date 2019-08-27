/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package dev.icerock.moko.core.filesystem

data class File(
    val name: String,
    val path: String
)

expect fun File.getFileName(): String
expect fun File.toBase64(): String
expect fun File.getMimeType(): String?
