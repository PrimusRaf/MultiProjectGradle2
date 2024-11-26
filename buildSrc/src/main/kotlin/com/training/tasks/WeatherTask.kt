package com.training.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

abstract class WeatherTask : DefaultTask() {

    init {
        group = "weather"
        description = "Eine benutzerdefinierte Task, die etwas ausgibt."
    }

    @TaskAction
    fun runTask() {
        println("Hello from CustomTask!")
    }
}