package com.github.arhont375

import org.junit.jupiter.api.Test
import org.testcontainers.containers.GenericContainer
import java.util.concurrent.TimeUnit

abstract class GenericTestAbstract {
    abstract fun getRedisContainer(): GenericContainer<*>;

    fun doJob() {
        TimeUnit.MILLISECONDS.sleep(100)
    }

    @Test
    fun startRedisAndWait() {
        getRedisContainer().getHost()
        doJob()
    }

    @Test
    fun startRedisAndWait2() {
        getRedisContainer().getHost()
        doJob()
    }

    @Test
    fun startRedisAndWait3() {
        getRedisContainer().getHost()
        doJob()
    }

    @Test
    fun startRedisAndWait4() {
        getRedisContainer().getHost()
        doJob()
    }

    @Test
    fun startRedisAndWait5() {
        getRedisContainer().getHost()
        doJob()
    }

    @Test
    fun startRedisAndWait6() {
        getRedisContainer().getHost()
        doJob()
    }
}
