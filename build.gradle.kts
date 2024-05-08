plugins {
    kotlin("jvm") version "1.9.23"
    kotlin("plugin.jpa") version "1.5.31"
    id("com.github.johnrengelman.shadow") version "7.0.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Appium
    implementation("io.appium:java-client:7.6.0")
    implementation("org.seleniumhq.selenium:selenium-remote-driver:3.141.59")
    implementation("org.seleniumhq.selenium:selenium-support:3.141.59")


    // Testing
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.2")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")


}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(11)
}