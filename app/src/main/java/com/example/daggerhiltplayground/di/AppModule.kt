package com.example.daggerhiltplayground.di

import android.content.Context
import com.example.daggerhiltplayground.Engine
import com.example.daggerhiltplayground.network.ApiService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
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

    @Singleton
    @Provides
    @Named("moshi")
    fun provideMoshi(): Moshi {
        return Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    }

    @Singleton
    @Provides
    @Named("retrofit")
    fun provideRetrofit(
        @Named("moshi") moshi: Moshi,
    ): Retrofit {
        return Retrofit.Builder().apply {
            baseUrl(ApiService.BASE_URL)
            addConverterFactory(MoshiConverterFactory.create(moshi))
        }.build()
    }

    @Singleton
    @Provides
    fun provideApi(
        @Named("retrofit") retrofit: Retrofit,
    ): ApiService {
        val rawgApiService: ApiService by lazy { retrofit.create(ApiService::class.java) }
        return rawgApiService
    }
}