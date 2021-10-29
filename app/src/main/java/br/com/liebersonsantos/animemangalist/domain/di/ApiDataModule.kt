package br.com.liebersonsantos.animemangalist.domain.di

import br.com.liebersonsantos.animemangalist.BuildConfig
import br.com.liebersonsantos.animemangalist.data.api.Api
import br.com.liebersonsantos.animemangalist.data.repository.Repository
import br.com.liebersonsantos.animemangalist.data.repository.RepositoryImpl
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by lieberson on 10/17/21.
 * @author lieberson.xsantos@gmail.com
 */
@Module
@InstallIn(SingletonComponent::class)
object ApiDataModule {

    @Singleton
    @Provides
    fun provideApi(): Api =
        Retrofit.Builder()
            .baseUrl(provideBaseUrl())
            .addConverterFactory(GsonConverterFactory.create(provideGson()))
            .client(provideClient())
            .build()
            .create(Api::class.java)

    @Singleton
    @Provides
    fun provideInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @Singleton
    @Provides
    fun provideClient(): OkHttpClient =
        OkHttpClient.Builder()
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(provideInterceptor())
            .build()

    @Singleton
    @Provides
    fun provideGson(): Gson = GsonBuilder().setLenient().create()

    @Singleton
    @Provides
    fun provideBaseUrl(): String = BuildConfig.BASE_URL

    @Singleton
    @Provides
    fun provideRepository(api: Api): Repository = RepositoryImpl(api)

}