plugins {
    kotlin("jvm") version "2.2.21"
}

group = "itb"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
}

kotlin {
    jvmToolchain(23)
}

tasks.test {
    useJUnitPlatform()
}