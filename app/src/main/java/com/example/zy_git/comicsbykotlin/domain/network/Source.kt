package com.flying.xiaopo.poishuhui_kotlin.domain.network

/**
 * @author wupanjie
 */
interface Source<T> {

    /**
     * 访问网络
     */
    fun obtain(url:String): T
}