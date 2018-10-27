pluginManagement {
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id == "com.github.kukuhyoniatmoko.buildconfigkotlin") {
                useModule("com.github.kukuhyoniatmoko:buildconfigkotlin:1.0.5")
            }
        }
    }
}

includeBuild("../plugin")

rootProject.name = "consumer"
