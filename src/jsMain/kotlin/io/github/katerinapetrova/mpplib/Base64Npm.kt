
package io.github.katerinapetrova.mpplib

@JsModule("base-64")
@JsNonModule
external object Base64 {
    fun encode(s: String): String
}