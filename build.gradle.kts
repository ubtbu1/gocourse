// 项目级别的 build.gradle.kts 文件

plugins {
    // 应用插件时，使用 id() 函数，并指定版本
    id("com.android.application") version "8.6.1" apply false
    id("org.jetbrains.kotlin.android") version "1.8.21" apply false
    id("androidx.navigation.safeargs.kotlin") version "2.8.3" apply false
}

task<Delete>("clean") {
    delete(rootProject.buildDir)
}
