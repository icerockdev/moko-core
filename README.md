[![GitHub license](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](http://www.apache.org/licenses/LICENSE-2.0)
[ ![Download](https://api.bintray.com/packages/icerockdev/moko/moko-core/images/download.svg) ](https://bintray.com/icerockdev/moko/moko-core/_latestVersion)

# Базовые компоненты для мультиплатформы
## Parcelize
Аннотация `Parcelize` и связанные с ней `interface Parcelable` и `annotation IgnoredOnParcel` доступны
 в `common` коде и для Android становятся android вариантами этих аннотаций, а для iOS просто заглушки.
 Это позволяет доменные модели в `common` коде пометить доступными для `Parcelize` плагина и спокойно
 перебрасывать через `putParcel` данные объекты между компонентами системы. Так как iOS не имеет таких
 заморочек с жизненным циклом - для него это никак не используется.

## ThreadLocal
Аннотация `ThreadLocal` нужна специально для iOS таргета, на те случаи когда нам нужно использовать
 какой-то объект Kotlin'а не на главном потоке - помечаем его `ThreadLocal` и тогда на каждом потоке
 будет свой инстанс этого объекта и никаких вылетов не будет (подробнее читать в https://github.com/JetBrains/kotlin-native/blob/master/CONCURRENCY.md)

## Timer
Мультиплатформенный таймер, используется следующим образом:
```kotlin
val everySecondTimer = Timer(1000) { // 1000ms = 1s
    if(shouldRepeat) return true
    else return false
}

everySecondTimer.start() // запустили таймер
everySecondTimer.stop() // остановили выполнение таймера
```
