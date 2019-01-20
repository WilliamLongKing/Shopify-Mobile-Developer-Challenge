package com.kingapps.shopifymobiledeveloperchallenge;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ShopifyCollectService {
    @GET("admin/collects.json?collection_id=68424466488&page=1&access_token=c32313df0d0ef512ca64d5b336a0d7c6")
    Call<List<Collect>> listCollect();//@Query("collection_id") String collection_id,
//                                        @Query ("page") int page,
//                                        @Query("access_token") String at);//"c32313df0d0ef512ca64d5b336a0d7c6");
}
