import com.training.extensions.WeatherExtension
import com.training.plugins.WeatherPlugin
import com.training.tasks.WeatherTask

plugins {
    java
}

apply<WeatherPlugin>()

allprojects {
    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "java")

    group = "com.training"
    version = "1.0.0"

    dependencies {
        "testImplementation"("junit:junit:4.13.2")
    }
}

repositories {
    mavenCentral()
}

tasks.register<WeatherTask>("weatherTask")
// Aufgabe zum Erstellen des Fat JAR
tasks.register<Jar>("fatJar") {
    group = "build"
    description = "Erstellt ein Fat JAR mit allen Submodulen"

    destinationDirectory.set(layout.buildDirectory.dir("libs"))
    archiveBaseName.set("${project.name}-all")

    manifest {
        attributes(
            "Implementation-Title" to project.name,
            "Implementation-Version" to project.version,
            "Main-Class" to "com.training.app.TrainingsApp"
        )
    }

    // Füge alle Klassen und Ressourcen der Subprojekte hinzu
    subprojects.forEach { subproject ->
        if (subproject.plugins.hasPlugin("java")) {
            from(subproject.sourceSets.main.get().output)

            // Füge die Laufzeit-Abhängigkeiten der Subprojekte hinzu
            if (subproject.configurations.findByName("runtimeClasspath") != null) {
                from(subproject.configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
            }
        }
    }

    // Vermeidet Duplikate
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}
