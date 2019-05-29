package shivuassignment.deeksha.com.retrofitdemo.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroClient {
    private static final String BASE_URL="https://api.learn2crack.com";

    private static Retrofit getRetrofitInstance()
    {
        return new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build(); //builder is a pattern
    }

    public static RequestInterface getApi()
    {
        return getRetrofitInstance().create(RequestInterface.class);
    }
}
