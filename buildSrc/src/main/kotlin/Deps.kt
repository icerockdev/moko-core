object Deps {
    object Plugins {
        const val android =
            "com.android.tools.build:gradle:${Versions.Plugins.android}"
        const val kotlin =
            "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.Plugins.kotlin}"
        const val androidExtensions =
            "org.jetbrains.kotlin:kotlin-android-extensions:${Versions.Plugins.androidExtensions}"
    }

    object Libs {
        object Android {
            const val kotlinStdLib =
                "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
            const val appCompat =
                "androidx.appcompat:appcompat:${Versions.Libs.Android.appCompat}"
        }

        object MultiPlatform {
            val kotlinStdLib = MultiPlatformLibrary(
                android = Android.kotlinStdLib,
                common = "org.jetbrains.kotlin:kotlin-stdlib-common:${Versions.kotlin}"
            )
            val mokoCore = MultiPlatformLibrary(
                common = "dev.icerock.moko:core:${Versions.Libs.MultiPlatform.mokoCore}",
                iosX64 = "dev.icerock.moko:core-iosx64:${Versions.Libs.MultiPlatform.mokoCore}",
                iosArm64 = "dev.icerock.moko:core-iosarm64:${Versions.Libs.MultiPlatform.mokoCore}"
            )
        }
    }

    val plugins: Map<String, String> = mapOf(
        "com.android.application" to Plugins.android,
        "com.android.library" to Plugins.android,
        "org.jetbrains.kotlin.multiplatform" to Plugins.kotlin,
        "kotlin-kapt" to Plugins.kotlin,
        "kotlin-android" to Plugins.kotlin,
        "kotlin-android-extensions" to Plugins.androidExtensions
    )
}