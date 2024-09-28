plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "spa.lyh.cn.picturepicker"
    compileSdk = 35

    defaultConfig {
        applicationId = "spa.lyh.cn.picturepicker"
        minSdk = 24
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation (libs.androidx.appcompat)
    implementation (libs.material)
    implementation (libs.androidx.constraintlayout)
    implementation ("io.github.lucksiege:pictureselector:v3.11.2")
    implementation ("io.github.lucksiege:ucrop:v3.11.2")
    implementation ("io.github.lucksiege:camerax:v3.11.2")
    implementation ("io.github.liyuhaolol:Permission:1.2.6")
    implementation ("io.github.liyuhaolol:glideutils:1.2.0")
}