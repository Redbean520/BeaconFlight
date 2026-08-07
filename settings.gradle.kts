pluginManagement {
    repositories {
        maven("https://maven.fabricmc.net/")
        maven("https://maven.kikugie.dev/releases")
        maven("https://maven.aliyun.com/repository/central")
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    id("dev.kikugie.stonecutter") version "0.9.7"
    // Auto-download JDKs for toolchains (JDK 17 for Forge 1.20.1, etc.)
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

stonecutter {
    centralScript = "build.gradle"
    kotlinController = true

    shared {
        // Fabric — each major version independent
        version("1.20.x-fabric", "1.20.1")    // 1.20.1–1.20.6 (intermediary 内部一致)
        version("1.21.1-fabric", "1.21.1")    // 1.21.1 (intermediary)
        version("1.21.11-fabric", "1.21.11")  // 1.21.11 (intermediary)
        version("26.1-fabric", "26.1")         // 26.1 (Mojang)
        version("26.2-fabric", "26.2")         // 26.2 (Mojang)

        // NeoForge — each major version independent
        version("1.21.1-neoforge", "1.21.1")
        version("1.21.11-neoforge", "1.21.11")
        version("26.1-neoforge", "26.1")
        version("26.2-neoforge", "26.2")

        // Forge (1.20.x)
        version("1.20.x-forge", "1.20.1")
    }

    create(rootProject)
}

rootProject.name = "beaconflight"
