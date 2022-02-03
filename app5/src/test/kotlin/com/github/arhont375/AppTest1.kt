package com.github.arhont375

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.testcontainers.containers.GenericContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.utility.DockerImageName

class AppTest1 {
    @Container
    @JvmField
    val redis: GenericContainer<*> =
        GenericContainer<Nothing>(DockerImageName.parse("redis:5.0.1-alpine"))
            .withExposedPorts(6379)

    @BeforeEach
    fun beforeEach() {
        redis.start()
    }

    @AfterEach
    fun afterEach() {
        redis.stop()
    }

    @Nested
    inner class InnerTest1 : GenericTestAbstract() {
        override fun getRedisContainer(): GenericContainer<*> {
            return redis
        }
    }

    @Nested
    inner class InnerTest2 : GenericTestAbstract() {
        override fun getRedisContainer(): GenericContainer<*> {
            return redis
        }
    }

    @Nested
    inner class InnerTest3 : GenericTestAbstract() {
        override fun getRedisContainer(): GenericContainer<*> {
            return redis
        }
    }
}
