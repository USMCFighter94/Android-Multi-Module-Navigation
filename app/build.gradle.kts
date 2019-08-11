plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(Deps.Sdk.compile)

    defaultConfig {
        applicationId = "com.brevitz.navigationcomponenttest"
        minSdkVersion(Deps.Sdk.min)
        targetSdkVersion(Deps.Sdk.target)
        versionCode = Deps.versionCode
        versionName = Deps.versionName
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
        implementation(Deps.appCompat)
        implementation(Deps.cardView)
        implementation(Deps.constraintLayout)
        implementation(Deps.coreKtx)
        kapt(Deps.Dagger.compiler)
        implementation(Deps.Dagger.core)
        kapt(Deps.Dagger.processor)
        implementation(Deps.epoxy)
        implementation(Deps.Glide.core)
        kapt(Deps.Glide.compiler)
        implementation(Deps.kotlin)
        implementation(Deps.material)
        implementation(Deps.moshi)
        implementation(Deps.Navigation.fragment)
        implementation(Deps.Navigation.ui)
        implementation(Deps.loggingInterceptor)
        implementation(Deps.recyclerView)
        implementation(Deps.Retrofit.core)
        implementation(Deps.Retrofit.moshiConverter)
        implementation(Deps.Retrofit.rxJavaAdapter)
        implementation(Deps.rxBinding)
        implementation(Deps.RxJava.android)
        implementation(Deps.RxJava.core)
        implementation(Deps.RxJava.kotlin)
        implementation(Deps.timber)
    }
