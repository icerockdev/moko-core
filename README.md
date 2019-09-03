![logo](http://via.placeholder.com/600x200)  
[![GitHub license](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](http://www.apache.org/licenses/LICENSE-2.0) [![Download](https://api.bintray.com/packages/icerockdev/moko/moko-core/images/download.svg) ](https://bintray.com/icerockdev/moko/moko-core/_latestVersion)

### The single library for Kotlin Multiplatform mobile development! 

This tool allows you to launch a project on iOS and Android using Kotlin Multiplatform without any technicals issues. The experience of 11+ completed projects approves it. 

## Table of Contents
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Set Up Locally](#setup-locally)
- [Contributing](#contributing)
- [Buy us a coffee](#donations)
- [License](#license)

# Features
- **Parcelize** in common code (special for Android target);
- **Timer** for recurrent/delayed operations;
- **getCurrentMilliSeconds** in common code;
- **Color** with convertation to platform side requirements (argb/rgba).

# Requirements
- Gradle version 5.4.1+
- Android API 21+
- iOS version 9.0+

# Installation
root build.gradle  
```groovy
allprojects {
    repositories {
        maven { url = "https://dl.bintray.com/icerockdev/moko" }
    }
}
```

project build.gradle
```groovy
dependencies {
    commonMainApi("dev.icerock.moko:core:0.1.0")
}
```

settings.gradle  
```groovy
enableFeaturePreview("GRADLE_METADATA")
```


# Usage
## Parcelize
Enable [kotlin android extensions](https://kotlinlang.org/docs/tutorials/android-plugin.html):
```groovy
apply plugin: 'kotlin-android-extensions'

androidExtensions {
    experimental = true
}
```

Mark common code classes with annotation `@Parcelize` just like in android code for automatically generated `Parcelable` implementation.
```kotlin
@Parcelize
data class User(
  val firstName: String,
  val lastName: String
) : Parcelable
```

## Timer
Create timer for repeating operation:
```kotlin
var iteration = 0
val timer = Timer(intervalMilliSeconds = 5000) {
    iteration++
    println("iteration $iteration")
    true // return true to repeat operation after interval
}

timer.start() // call block after intervalMilliSeconds

timer.stop() // manually stop repeating timer
```

Create timer for single run (delayed operation):
```kotlin
val timer = Timer(intervalMilliSeconds = 5000) {
    println("printed after 5 seconds")
    false
}

timer.start() // call block after intervalMilliSeconds
```

## Current milliseconds
```kotlin
val milliSeconds: Long = getCurrentMilliSeconds()
println("now $milliSeconds milliseconds")
```

## Color
```kotlin
val red = Color(
    red = 0xFF,
    green = 0x00,
    blue = 0x00,
    alpha = 0xFF
)

val rgba: Long = red.rgba
val argb: Long = red.argb // android compatible
```

# Set Up Locally
- clone project
- use `:core:publishToMavenLocal` gradle task in development process with sample project

# Contributing
All development (both new features and bug fixes) is performed in `develop` branch. This way `master` sources always contain sources of the most recently released version. Please send PRs with bug fixes to `develop` branch. Fixes to documentation in markdown files are an exception to this rule. They are updated directly in `master`.

The `develop` branch is pushed to `master` during release.

More detailed guide for contributers see in [contributing guide](CONTRIBUTING.md).

# License
        
    Copyright 2019 IceRock MAG Inc
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
       http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.