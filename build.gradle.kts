plugins {
    kotlin("jvm") version "2.0.21"
}

group = "com.csakitheone"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    implementation("net.objecthunter:exp4j:0.4.8")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}