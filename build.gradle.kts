plugins {
    kotlin("multiplatform").version("1.9.20-Beta2")
    id("convention.publication")
}

group = "io.github.katerinapetrova"
version = "1.0.2"

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
    }

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    js {
        browser {
            testTask {
                useKarma {
                    useChromeHeadless()
                    webpackConfig.cssSupport {
                        enabled.set(true)
                    }
                }
            }
        }
    }

    sourceSets {
        commonTest {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        jvmTest {
            dependencies {
                implementation(kotlin("test-junit"))
            }
        }
        jsTest {
            dependencies {
                implementation(kotlin("test-js"))
                implementation(npm("base-64", "1.0.0"))
            }
        }
    }
}