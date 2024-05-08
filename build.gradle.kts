plugins {
    kotlin("jvm") version "1.9.23"
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
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(11)
}