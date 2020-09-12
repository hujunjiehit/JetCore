object Versions {
    const val applicationId = "com.coinbene.app"
    const val minSdk = 21
    const val targetSdk = 29
    const val compileSdk = 29
    const val buildToolsVersion = "29.0.3"
    const val versionCode = 1
    const val versionName = "1.0"

    internal const val kotlin = "1.3.72"
    internal const val androidx = "1.2.0"
    internal const val constraint_layout = "2.0.0"
    internal const val material = "1.2.0"
    internal const val androidx_ktx = "1.3.1"
    internal const val fragment_ktx = "1.2.5"
    internal const val lifecycle = "2.2.0"

    internal const val retrofit = "2.9.0"
    internal const val coroutines = "1.3.7"
    internal const val glide = "4.11.0"
    internal const val brvah = "3.0.4"
    internal const val qmui = "2.0.0-alpha10"
    internal const val material_dialogs = "3.3.0"
    internal const val loadsir = "1.3.8"
    internal const val logger = "2.2.0"
    internal const val mmkv = "1.2.2"
    internal const val utilcode = "1.29.0"
    internal const val hilt = "2.28-alpha"
}

object Deps {
    const val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    const val androidx = "androidx.appcompat:appcompat:${Versions.androidx}"
    const val constraint_layout = "androidx.constraintlayout:constraintlayout:${Versions.constraint_layout}"
    const val material = "com.google.android.material:material:${Versions.material}"

    //Android ktx 是一组Kotlin 扩展程序，属于 Jetpack 系列
    const val androidx_ktx = "androidx.core:core-ktx:${Versions.androidx_ktx}"
    const val fragment_ktx = "androidx.fragment:fragment-ktx:${Versions.fragment_ktx}"
    const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    const val lifecycle_viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val lifecycle_livedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"

    //RecyclerView第三方库
    const val brvah = "com.github.CymChad:BaseRecyclerViewAdapterHelper:${Versions.brvah}"

    //网络请求
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofit_convert_gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val okhhtp_log_interceptor = "com.squareup.okhttp3:logging-interceptor:4.7.2"

    //kotlin协程
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutines_android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"

    //图片加载
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glide_compile = "com.github.bumptech.glide:compiler:${Versions.glide}"

    // QMUI
    const val qmui = "com.qmuiteam:qmui:${Versions.qmui}"
    const val qmui_arch = "com.qmuiteam:arch:${Versions.qmui}"
    const val qmui_arch_compile = "com.qmuiteam:arch-compiler:${Versions.qmui}"

    //Material Dialogs
    const val material_dialogs = "com.afollestad.material-dialogs:core:${Versions.material_dialogs}"
    const val material_dialogs_lifecycle = "com.afollestad.material-dialogs:lifecycle:${Versions.material_dialogs}"

    const val loadsir = "com.kingja.loadsir:loadsir:${Versions.loadsir}"

    //logger
    const val logger = "com.orhanobut:logger:${Versions.logger}"

    const val mmkv = "com.tencent:mmkv-static:${Versions.mmkv}"

    const val utilcode = "com.blankj:utilcodex:${Versions.utilcode}"

    //依赖注入
    const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hilt_compile = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    const val hilt_lifecycle = "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha01"
    const val hilt_lifecycle_compile = "androidx.hilt:hilt-compiler:1.0.0-alpha01"
}