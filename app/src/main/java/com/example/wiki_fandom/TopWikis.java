package com.example.wiki_fandom;

import com.example.wiki_fandom.pojo.Wiki;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TopWikis {

    String BASE_URL = "https://community.fandom.com/api/v1/Wikis/";

    @GET("List?")
    Observable<Wiki> getWikis(@Query("expand") Integer expand , @Query("limit") Integer limit
                                 , @Query("batch") Integer batch);

}
