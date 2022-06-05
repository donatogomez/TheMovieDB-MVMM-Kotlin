package io.donatogomez.themoviedb.data.di

import android.content.Context
import androidx.room.Room
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.donatogomez.themoviedb.data.local.TheMovieDBDao
import io.donatogomez.themoviedb.data.local.TheMovieDBDatabase
import io.donatogomez.themoviedb.data.remote.TheMovieDBAPI
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun providesOkHtttpClient(): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor { chain ->
            val request = chain.request()
            val originalUrl = request.url

            val newUrl = originalUrl.newBuilder().addQueryParameter(
                "api_key",
                "5596393b65cdc22024fa08592d45f833"
            ).build()
            val newHeaders =
                request.headers.newBuilder().add("Content-type: application/json").build()
            val newRequest = request.newBuilder().url(newUrl).headers(newHeaders).build()

            chain.proceed(newRequest)
        }.addInterceptor(
            HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT).apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        )
            .build()


    }

    @Provides
    fun providesMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @Provides
    fun providesRetrofit(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/")
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @Provides
    fun providesMovieAPI(retrofit: Retrofit): TheMovieDBAPI {
        return retrofit.create(TheMovieDBAPI::class.java)
    }

    @Provides
    fun providesMovieDatabase(@ApplicationContext context: Context): TheMovieDBDatabase {
        return Room.databaseBuilder(
            context,
            TheMovieDBDatabase::class.java, "themoviedb-database"
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun providesTheMovieDBDao(theMovieDBDatabase: TheMovieDBDatabase): TheMovieDBDao {
        return theMovieDBDatabase.theMovieDBDao()
    }
}