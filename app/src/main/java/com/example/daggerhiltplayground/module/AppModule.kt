package com.example.daggerhiltplayground.module

import android.content.Context
import com.example.daggerhiltplayground.Engine
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

/*
    @Module -> Anotasi untuk memberitahu Hilt bahwa AppModule merupakan module dependency
    @InstallIn(SingletonComponent::class) :
        Scope/cakupan untuk dependency
         - SingletonComponent -> Dependency akan hidup selama aplikasinya berjalan
         - ActivityComponent  -> Dependency akan hidup selama activity tertentu hidup
*/

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // @Singleton -> Membuat object Engine hanya sekali selama aplikasi berjalan
    // @Provides  -> Menandakan ini adalah module yang siap untuk diinject ke kelas2 yg membutuhkan
    // @Named     -> Sebagai pembeda terhadap module yang menggunakan object yang sama (String)
    // @ApplicationContext  -> Menginject context

    @Singleton // Sesuaikan dengan scope dalam anotasi @InstallIn
    @Provides
    fun provideEngine(
        @ApplicationContext context: Context,
        @Named("owner") owner: String, // Inject di dalam inject
    ): Engine {
        return Engine(context, "Superjet", owner)
    }

    @Singleton
    @Provides
    @Named("owner")
    fun provideOwner() = "Hendra Pratik Aditama"

    @Singleton
    @Provides
    @Named("string")
    fun provideString(): String = "Ini adalah string pertama yang akan diinject"

    @Singleton
    @Provides
    @Named("string2")
    fun provideString2(): String = "Ini adalah string kedua yang akan diinject"

}