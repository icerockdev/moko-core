plugins {
    `kotlin-dsl`
}

repositories {
    mavenLocal()
    jcenter()
    google()
}

dependencies {
    implementation("dev.icerock:mobile-multiplatform:0.1.0")
}

kotlinDslPluginOptions {
    experimentalWarning.set(false)
}
