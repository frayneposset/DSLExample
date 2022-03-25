plugins {
    kotlin("jvm") version "1.6.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    val kotlinVersion: String by project
    val kotestVersion: String by project
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.1")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.13.1")





    testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")
    testImplementation("io.kotest:kotest-assertions-core:$kotestVersion")
    testImplementation("io.mockk:mockk:1.12.3")


}

tasks.withType<Test> {
    useJUnitPlatform()
}
