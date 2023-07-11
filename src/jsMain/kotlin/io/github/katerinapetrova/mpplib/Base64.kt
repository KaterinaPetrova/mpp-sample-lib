package io.github.katerinapetrova.mpplib

actual object Base64Factory {
    actual fun createEncoder(): Base64Encoder = JsBase64Encoder
}

object JsBase64Encoder : Base64Encoder {
    override fun encode(src: ByteArray): ByteArray {
        println("Input: $src")
        val binString = src.decodeToString()
        return Base64.encode(binString).encodeToByteArray()
    }
}