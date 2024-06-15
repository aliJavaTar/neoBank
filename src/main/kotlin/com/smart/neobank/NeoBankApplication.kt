package com.smart.neobank

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.smart.neobank.infrastructure"])
class NeoBankApplication

fun main() {
	runApplication<NeoBankApplication>()
}
