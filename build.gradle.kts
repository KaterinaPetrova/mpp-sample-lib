plugins {
    kotlin("multiplatform") version "1.8.20"
    id("convention.publication")
}

group = "io.github.katerinapetrova"
version = "1.0.2"

repositories {
    mavenCentral()
}

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
    }

    ios()

    js(IR) {
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
        targetHierarchy.default()

        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val jvmMain by getting
        val jvmTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
            }
        }
        val jsMain by getting
        val jsTest by getting {
            dependencies {
                implementation(kotlin("test-js"))
                implementation(npm("base-64", "1.0.0"))
            }
        }
        val iosMain by getting
        val iosTest by getting
    }
}