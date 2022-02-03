package com.github.arhont375

import org.junit.jupiter.api.Nested
import org.testcontainers.containers.GenericContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.utility.DockerImageName

class AppTest {
    @Container
    @JvmField
    val redis: GenericContainer<*> =
        GenericContainer<Nothing>(DockerImageName.parse("redis:5.0.3-alpine")).withExposedPorts(6379)

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
