package com.example.weatherdemo.di

import com.example.weatherdemo.BuildConfig
import com.example.weatherdemo.network.WeatherDetailsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor { apiKeyAsQuery(it) }
            .addInterceptor(loggingInterceptor)
            .build()
    } else {
        OkHttpClient
            .Builder()
            .addInterceptor { apiKeyAsQuery(it) }
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl("https://api.openweathermap.org/")
        .client(okHttpClient)
        .build()

    @Provides
    @Singleton
    fun provideWeatherDetailsApi(retrofit: Retrofit): WeatherDetailsApi =
        retrofit.create(WeatherDetailsApi::class.java)
}

private fun apiKeyAsQuery(chain: Interceptor.Chain) = chain.proceed(
    chain.request()
        .newBuilder()
        .url(chain.request().url.newBuilder().addQueryParameter("appid", BuildConfig.WEATHER_API_KEY).build())
        .build()
)

private fun apiKeyAsHeader(it: Interceptor.Chain) = it.proceed(
    it.request()
        .newBuilder()
        .addHeader("appid", BuildConfig.WEATHER_API_KEY)
        .build()
)