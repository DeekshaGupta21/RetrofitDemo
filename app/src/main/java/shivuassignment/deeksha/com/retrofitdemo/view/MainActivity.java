package shivuassignment.deeksha.com.retrofitdemo.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.JsonWriter;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import shivuassignment.deeksha.com.retrofitdemo.R;
import shivuassignment.deeksha.com.retrofitdemo.adapters.DataAdapter;
import shivuassignment.deeksha.com.retrofitdemo.api.RequestInterface;
import shivuassignment.deeksha.com.retrofitdemo.api.RetroClient;
import shivuassignment.deeksha.com.retrofitdemo.model.AndroidVersion;
import shivuassignment.deeksha.com.retrofitdemo.model.JSONResponse;


public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private ArrayList<AndroidVersion> data;
    private DataAdapter adapter;

    private ArrayList<JSONResponse> jsonResponses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        getJSON();
    }
        private void getJSON() {
            RequestInterface requestInterface = RetroClient.getApi();
            Call<JSONResponse> call = requestInterface.getJSON();
            call.enqueue(new Callback<JSONResponse>() {
                @Override
                public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {
                    JSONResponse jsonResponses = response.body();
                    Log.d("AndroidList", jsonResponses.toString());
                    data = new ArrayList<>(Arrays.asList(jsonResponses.getAndroid()));
                    Log.d("AndroidVersion",data.toString());

                    adapter = new DataAdapter(data);
                    recyclerView.setAdapter(adapter);
                }

                @Override
                public void onFailure(Call<JSONResponse> call, Throwable t) {
                    Log.d("Error",t.getMessage());
                }
            });

        }


}































