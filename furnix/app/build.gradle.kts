plugins {
    id("com.android.application")
    id("com.google.gms.google-services") version "4.3.10" apply false
}

android {
    namespace = "com.google.ar.core.examples.java.furnix"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.google.ar.core.examples.java.furnix"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }
    tasks.withType<JavaCompile> {
        options.compilerArgs.add("-Xlint:deprecation")
    }

    buildTypes {
            getByName("release") {
                isMinifyEnabled = false
                proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    implementation("com.google.ar:core:1.38.0")
    implementation("de.javagl:obj:0.2.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
}
