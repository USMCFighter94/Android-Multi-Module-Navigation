plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(Deps.Sdk.compile)

    defaultConfig {
        minSdkVersion(Deps.Sdk.min)
        targetSdkVersion(Deps.Sdk.target)
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    sourceSets {
        getByName("main").java.srcDirs("src/main/kotlin")
    }
}

dependencies {
    implementation(project(Modules.core))
    implementation(Deps.appCompat)
    implementation(Deps.constraintLayout)
    implementation(Deps.coreKtx)
    kapt(Deps.Dagger.compiler)
    implementation(Deps.Dagger.core)
    kapt(Deps.Dagger.processor)
    implementation(Deps.epoxy)
    implementation(Deps.kotlin)
    implementation(Deps.material)
    implementation(Deps.recyclerView)
    implementation(Deps.RxJava.android)
    implementation(Deps.RxJava.core)
    implementation(Deps.RxJava.kotlin)
    implementation(Deps.timber)
}