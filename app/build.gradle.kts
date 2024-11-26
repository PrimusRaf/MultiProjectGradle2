plugins {
    java
    kotlin("jvm")
}

group = "com.training"
version = "1.0.0"


repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":library"))
    implementation(project(":shared"))
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation(kotlin("stdlib-jdk8"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}