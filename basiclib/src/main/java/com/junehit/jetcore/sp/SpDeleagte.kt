package com.junehit.jetcore.sp

import com.tencent.mmkv.MMKV
import java.lang.IllegalArgumentException
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 *Created by june
 *on 2020/9/8
 */
class SpDeleagte<T>(private val key : String, private val defaultValue : T) : ReadWriteProperty<Any?, T> {

    companion object {
        val mmkv = MMKV.defaultMMKV()
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return getMMkvValue(key, defaultValue);
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        setMMkvValue(key, value)
    }

    private fun <T> getMMkvValue(key: String, defaultValue: T) :  T {
        val res : Any = when(defaultValue) {
            is String -> mmkv.decodeString(key, defaultValue)
            is Int -> mmkv.decodeInt(key, defaultValue)
            is Long ->  mmkv.decodeLong(key, defaultValue)
            is Boolean ->  mmkv.decodeBool(key, defaultValue)
            is Float ->  mmkv.decodeFloat(key, defaultValue)
            is Double ->  mmkv.decodeDouble(key, defaultValue)
            else -> {
                throw IllegalArgumentException("un support encode value")
            }
        }
        return res as T
    }

    private fun <T> setMMkvValue(key: String, value: T) {
        when(value) {
            is String -> mmkv.encode(key, value)
            is Int -> mmkv.encode(key, value)
            is Long ->  mmkv.encode(key, value)
            is Boolean ->  mmkv.encode(key, value)
            is Float ->  mmkv.encode(key, value)
            is Double ->  mmkv.encode(key, value)
            else -> {
                throw IllegalArgumentException("un support encode value")
            }
        }
    }
}