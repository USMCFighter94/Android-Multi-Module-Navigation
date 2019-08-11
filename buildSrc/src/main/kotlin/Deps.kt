object Deps {
    val appCompat = dependency("androidx.appcompat:appcompat", Versions.appCompat)
    val cardView = dependency("androidx.cardview:cardview", Versions.cardView)
    val constraintLayout = dependency("androidx.constraintlayout:constraintlayout", Versions.constraintLayout)
    val coreKtx = dependency("androidx.core:core-ktx", Versions.coreKtx)

    object Dagger : Group("com.google.dagger") {
        val compiler = withArtifact("dagger-compiler", Versions.dagger)
        val core = withArtifact("dagger", Versions.dagger)
        val processor = withArtifact("dagger-android-processor", Versions.dagger)
    }

    val epoxy = dependency("com.airbnb.android:epoxy", Versions.epoxy)

    object Glide : Group("com.github.bumptech.glide") {
        val compiler = withArtifact("compiler", Versions.glide)
        val core = withArtifact("glide", Versions.glide)
        val okHttp = withArtifact("okhttp3-integration", Versions.glide)
    }

    val kotlin = dependency("org.jetbrains.kotlin:kotlin-stdlib-jdk8", Versions.kotlin)
    val material = dependency("com.google.android.material:material", Versions.material)

    val moshi = dependency("com.squareup.moshi:moshi-kotlin", Versions.moshi)
    val moshiCodeGen = dependency("com.squareup.moshi:moshi-kotlin-codegen", Versions.moshi)

    object Navigation : Group("android.arch.navigation") {
        val fragment = withArtifact("navigation-fragment-ktx", Versions.navigation)
        val ui = withArtifact("navigation-ui-ktx", Versions.navigation)
    }

    val loggingInterceptor = dependency("com.squareup.okhttp3:logging-interceptor", Versions.okhttp)

    val recyclerView = dependency("androidx.recyclerview:recyclerview", Versions.recyclerView)

    object Retrofit : Group("com.squareup.retrofit2") {
        val core = withArtifact("retrofit", Versions.retrofit)
        val moshiConverter = withArtifact("converter-moshi", Versions.retrofit)
        val rxJavaAdapter = withArtifact("adapter-rxjava2", Versions.retrofit)
    }

    object RxJava : Group("io.reactivex.rxjava2") {
        val android = withArtifact("rxandroid", Versions.rxAndroid)
        val core = withArtifact("rxjava", Versions.rxJava)
        val kotlin = withArtifact("rxkotlin", Versions.rxKotlin)
    }

    val rxBinding = dependency("com.jakewharton.rxbinding2:rxbinding-kotlin", Versions.rxBinding)

    object Sdk {
        const val min = 23
        const val compile = 29
        const val target = 29
    }

    const val versionCode = 1
    const val versionName = "1.0.0"
    val timber = dependency("com.jakewharton.timber:timber", Versions.timber)
}

abstract class Group(val group: String) {
    fun withArtifact(artifact: String, version: String): String = "$group:$artifact:$version"
}

private fun dependency(path: String, version: String): String = "$path:$version"

object Versions {
    const val kotlin = "1.3.41"

    internal const val appCompat = "1.0.0"
    internal const val cardView = "1.0.0"
    internal const val constraintLayout = "2.0.0-beta2"
    internal const val coreKtx = "1.0.0"
    internal const val dagger = "2.22.1"
    internal const val epoxy = "3.5.1"
    internal const val glide = "4.9.0"
    internal const val material = "1.0.0"
    internal const val moshi = "1.8.0"
    internal const val navigation = "1.0.0-alpha06"
    internal const val okhttp = "3.14.1"
    internal const val recyclerView = "1.0.0"
    internal const val retrofit = "2.5.0"
    internal const val rxAndroid = "2.1.1"
    internal const val rxBinding = "2.2.0"
    internal const val rxJava = "2.2.8"
    internal const val rxKotlin = "2.3.0"
    internal const val timber = "4.7.1"
}

object Modules {
    const val core = ":core"
    const val home = ":home"
    const val subreddit = ":subreddit"
}
