package com.example.daggerhiltplayground.di

// @Module
// @InstallIn(ActivityComponent::class) // Module akan dijalankan di Activity lifecycle scope
object MainModule {

//    @ActivityScoped // Sesuaikan dengan scope dalam anotasi @InstallIn
//    @Provides
//    fun provideEngine(
//        @ApplicationContext context: Context,
//        @Named("owner") owner: String, // Inject di dalam inject. diambil dari AppModule
//    ): Engine {
//        return Engine(context, "Superjet", owner)
//    }

}