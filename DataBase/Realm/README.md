# Android Realm

This is a simple example how to use realm in android.

### What is Realm?

Realm is another type of database in Android. But, what is very important, Realm doesn’t use SQLite. If you use ORMLite or ActiveAndroid or any other similar library, your data is stored in SQLite database, because these libraries give us only an overlay on SQLite. With Realm there is no SQLite at all. Thanks to that Realm is very fast and you are even allowed to write the data in UI thread (mostly).


### Prerequisites

* Android Studio version 1.5.1 or higher
* JDK version 7.0 or higher
* A recent version of the Android SDK
* Android API Level 9 or higher (Android 2.3 and above)

* **Notes** for more informations you can to acess realm documentation here [Realm-Documentation](https://realm.io/docs/java/latest)

### Installing

* **Step 1** - Add the class path dependency to the project level build.gradle file.

```
buildscript {
    
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:3.1.2'

        //Need for to use realm
        classpath "io.realm:realm-gradle-plugin:5.2.0"

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}
```

* **Step 2** - Apply the realm-android plugin to the top of the application level build.gradle file.

```
apply plugin: 'realm-android'
```


* **Step 3** - Need enabling realm mobile platform before your application can synchronize with the Realm Object Server, it has to be enabled in your build file. Add this to the application’s build.gradle:

```
realm {
    syncEnabled = true
}

```

* **Step 4** - Case you need to use data adapter, you can add line bellow in your depedencies:

```
implementation 'io.realm:android-adapters:2.1.1'

```

building...

## Authors

* **Vinícius Rodrigues Duarte** - 09/06/2018 - [My Github](https://github.com/viniciusrd)

See also the my list of [contributors](https://github.com/viniciusrd?tab=repositories).

