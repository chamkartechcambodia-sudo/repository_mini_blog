plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.ksp)
    // NOTE: No Kotlin plugin here. AGP 9 ships built-in Kotlin (KGP 2.2.10), so we do
    // NOT apply org.jetbrains.kotlin.android — applying it would conflict with AGP 9.
}

android {
    namespace = "com.example.miniblog"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.miniblog"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

// AGP 9 built-in Kotlin: configure Kotlin compiler options in this top-level `kotlin`
// block (the old `android { kotlinOptions { } }` block no longer exists). jvmTarget also
// defaults to compileOptions.targetCompatibility; we set it explicitly for clarity.
kotlin {
    compilerOptions {
        jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17
    }
}

dependencies {
    // --- AndroidX UI ---
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.recyclerview)

    // --- Lifecycle: ViewModel + LiveData (this course uses LiveData, NOT Flow) ---
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.kotlinx.coroutines.android)

    // --- Room: the local database = single source of truth (KSP2, no kapt) ---
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    ksp(libs.androidx.room.compiler)

    // --- Retrofit + Moshi (reflection adapter — no codegen / annotation processor) ---
    implementation(libs.retrofit)
    implementation(libs.converter.moshi)
    implementation(libs.moshi)
    implementation(libs.moshi.kotlin)

    // --- Glide: kept in the stack for a later image-loading lesson (basic use only — no
    //     Glide compiler, no @GlideModule). Not used by the current UI yet. ---
    implementation(libs.glide)
}
