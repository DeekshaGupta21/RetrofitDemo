package shivuassignment.deeksha.com.retrofitdemo.api;
import retrofit2.Call;
import retrofit2.http.GET;
import shivuassignment.deeksha.com.retrofitdemo.model.JSONResponse;

public interface RequestInterface {
    @GET("/android/jsonandroid")
    Call<JSONResponse> getJSON();
}
