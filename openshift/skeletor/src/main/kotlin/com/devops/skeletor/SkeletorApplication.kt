package com.devops.skeletor

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class SkeletorApplication

fun main(args: Array<String>) {
    SpringApplication.run(SkeletorApplication::class.java, *args)
}
