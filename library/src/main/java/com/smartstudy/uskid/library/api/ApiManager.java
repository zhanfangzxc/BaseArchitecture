package com.smartstudy.uskid.library.api;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

/**
 * @author 赵珊珊
 * @date 2017/12/6
 */
public class ApiManager {


    public static final String BASE_URL = "http://tao.ddjchn.com/";


    private static final Charset UTF8 = Charset.forName("UTF-8");

    public static final String KEY = "vqllqcsJZrfw7o3SgAlMmGGPupK2YLhM";

    private static Api mApi;

    public static Api getApiService() {
        if (mApi == null) {
            mApi = buildRetrofit().create(Api.class);
        }
        return mApi;
    }

    private static Retrofit buildRetrofit() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new StethoInterceptor())
                .addInterceptor(logging)
                //设置超时时间
                .connectTimeout(10 * 1000, TimeUnit.SECONDS)
                .readTimeout(10 * 1000, TimeUnit.SECONDS)
                .build();
        ExclusionStrategy exclusionStrategy = new ExclusionStrategy() {
            @Override
            public boolean shouldSkipField(FieldAttributes fieldAttributes) {
                return false;
            }

            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                return clazz == Field.class || clazz == Method.class;
            }
        };

        Gson gson = new GsonBuilder()
                .disableHtmlEscaping()
                .addSerializationExclusionStrategy(exclusionStrategy)
                .addDeserializationExclusionStrategy(exclusionStrategy)
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(new QualifiedTypeConverterFactory(ApiErrorGsonConverterFactory.create(gson),
                        new StringConverter()))
                .addCallAdapterFactory(RxErrorHandlingCallAdapterFactory.create())
                .build();
        return retrofit;
    }

}
