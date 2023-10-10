package io.github.katerinapetrova.mpplib

interface Base64Encoder {
    fun encode(src: ByteArray): ByteArray
    fun encodeToString(src: ByteArray): String {
        val encoded = encode(src)
        return buildString(encoded.size) {
            encoded.forEach { append(it.toInt().toChar()) }
        }
    }
}

expect object Base64Factory {
    fun createEncoder(): Base64Encoder
}