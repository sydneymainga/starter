package co.ke.binary.chama.di.modules;


import javax.inject.Named;
import javax.inject.Singleton;

import co.ke.binary.chama.BuildConfig;
import co.ke.binary.chama.data.Config;
import co.ke.binary.chama.data.api.HeaderInterceptor;
import co.ke.binary.chama.data.services.UsersService;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Richie on 10/22/2018.
 */
@Module
public class NetworkModule {

    public static final String BASE_URL = "base_url";

    @Provides
    @Named(BASE_URL)
    String provideBaseUrl() {
        return Config.BASE_URL;
    }

    @Provides
    @Singleton
    HeaderInterceptor provideHeaderInterceptor() {
        return new HeaderInterceptor();
    }

    @Provides
    @Singleton
    HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        if (BuildConfig.DEBUG) {
            // development build
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            // production build
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        }
        return loggingInterceptor;
    }

    @Provides
    @Singleton
    OkHttpClient provideHttpClient(HeaderInterceptor headerInterceptor,
                                   HttpLoggingInterceptor httpInterceptor) {
        return new OkHttpClient.Builder().addInterceptor(headerInterceptor)
                .addInterceptor(httpInterceptor)
                .build();
    }

    @Provides
    @Singleton
    Converter.Factory provideGsonConverterFactory() {
        return GsonConverterFactory.create();
    }

    @Provides
    @Singleton
    CallAdapter.Factory provideRxJavaAdapterFactory() {
        return RxJava2CallAdapterFactory.create();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(@Named(BASE_URL) String baseUrl, Converter.Factory converterFactory,
                             CallAdapter.Factory callAdapterFactory, OkHttpClient client) {
        return new Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(converterFactory)
                .addCallAdapterFactory(callAdapterFactory)
                .client(client)
                .build();
    }

    @Provides
    @Singleton
    UsersService providesTopStories(Retrofit retrofit) {
        return retrofit.create(UsersService.class);
    }

}