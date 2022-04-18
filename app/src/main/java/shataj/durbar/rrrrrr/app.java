package shataj.durbar.rrrrrr;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface app {

//@FormUrlEncoded
    @GET
    Call<List<main>> getimage(@Url String url);


    }
