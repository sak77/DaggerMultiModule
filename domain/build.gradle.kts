plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}
apply("../android.common.gradle")

java {
    sourceCompatibility = JavaVersion.VERSION_1_7
    targetCompatibility = JavaVersion.VERSION_1_7
}

dependencies {
    implementation(Lib.kotlin)
    implementation(Lib.coroutines)
}