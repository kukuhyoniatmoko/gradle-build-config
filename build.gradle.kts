buildscript {
    var kotlinVersion: String by extra
    kotlinVersion = "1.2.30"

    repositories {
        gradlePluginPortal()
        jcenter()
    }
}

group = "com.github.kukuhyoniatmoko"
version = "1.0.2"

tasks.withType<Wrapper> {
    distributionType = Wrapper.DistributionType.ALL
}
