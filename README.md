# DaggerHiltPlayground

<pre>
build.gradle(:app)
  Dependency :
    // Dagger Hilt
    implementation "com.google.dagger:hilt-android:2.41"
    kapt "com.google.dagger:hilt-android-compiler:2.41"

    // Moshi
    implementation 'com.squareup.moshi:moshi-kotlin:1.13.0'

    // Retrofit with Moshi converter
    implementation 'com.squareup.retrofit2:converter-moshi:2.9.0'
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'

  Plugins :
    id 'kotlin-kapt'
    id 'dagger.hilt.android.plugin'

build.gradle(project)
    buildscript {
        dependencies {
            classpath 'com.google.dagger:hilt-android-gradle-plugin:2.41'
        }
    }
</pre>
