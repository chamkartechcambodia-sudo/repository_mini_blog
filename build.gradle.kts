// Top-level build file. Declare plugins here with `apply false`, then apply them
// in each module's build.gradle.kts.
//
// NOTE: AGP 9 ships built-in Kotlin (KGP 2.2.10), so there is NO
// `org.jetbrains.kotlin.android` plugin to declare here.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.ksp) apply false
}
