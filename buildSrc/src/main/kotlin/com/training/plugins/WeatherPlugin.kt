package com.training.plugins

import com.training.extensions.WeatherExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

class WeatherPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.extensions.create("weather", WeatherExtension::class.java)

        project.tasks.register("weatherTomorrow") {
            group = "Weather"
            description = "Prints tomorrow's weather forecast"
            doLast {
                val extension = project.extensions.findByType(WeatherExtension::class.java)
                println("Extension registered: $extension")
                println("Tomorrow the weather will be ${extension?.forecast}")
            }
        }
    }
}