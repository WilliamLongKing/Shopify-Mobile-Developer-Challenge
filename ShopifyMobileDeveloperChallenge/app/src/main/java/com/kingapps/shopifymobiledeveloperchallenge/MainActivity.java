package com.kingapps.shopifymobiledeveloperchallenge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
//import com.google.gson.annotations.Expose;
//import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.OkHttpClient;


public class MainActivity extends AppCompatActivity {

    private RequestQueue mQueue;
    public ArrayList<Collect> collectArrayList = new ArrayList<>();

    // To do: Get IDs through an API call instead
    Map<String, String> COLLECTION_INFO = new HashMap<String, String>() {{
       put("Aerodynamic collection", "68424466488");
       put("Awesome collection", "68424499256");
       put("Durable collection", "68424532024");
       put("Enormous collection", "68424564792");
       put("Ergonomic collection", "68424597560");
       put("Fantastic collection", "68424630328");
       put("Gorgeous collection", "68424663096");
       put("Heavy Duty collection", "68424695864");
       put("Incredible collection", "68424728632");
       put("Intelligent collection", "68424761400");
       put("Lightweight collection", "68424794168");
       put("Mediocre collection", "68424794168");
       put("Practical collection", "68424859704");
       put("Rustic collection", "68424892472");
       put("Sleek collection", "68424925240");
       put("Small collection", "68424990776");
       put("Synergistic collection", "68425023544");

    }};

    private ArrayList<String> mData = new ArrayList<>();
    OkHttpClient client = new OkHttpClient();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();

        mQueue = Volley.newRequestQueue(this);
        //jsonParse("https://shopicruit.myshopify.com/admin/collects.json?collection_id=68424466488&page=1&access_token=c32313df0d0ef512ca64d5b336a0d7c6");

    }

    //RecyclerView
    private void initData() {
        for (String collection : COLLECTION_INFO.keySet()) {
            mData.add(collection);
        }
        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        CollectsRecyclerViewAdapter adapter = new CollectsRecyclerViewAdapter(mData, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


// Testing with OkHttp: worked well but didn't give me the response as a POJO. I switched to Volley,
// although GSON likely woould have been good to use here. (url was hardcoded for testing purposes,
// would use URL manipulation next time

//    private List<Collect> getCollect(String id) {
//        String url = "https://shopicruit.myshopify.com/admin/collects.json?collection_id=" + id + "&page=1&access_token=c32313df0d0ef512ca64d5b336a0d7c6";
//
//        Request request = new Request.Builder()
//                .url(url)
//                .build();
//
//        client.newCall(request).enqueue(new okhttp3.Callback() {
//            @Override
//            public void onFailure(okhttp3.Call call, IOException e) {
//                e.printStackTrace();
//            }
//
//            @Override
//            public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {
//                if (response.isSuccessful()) {
//                    ResponseBody result = response.body();
//
//
//                }
//
//            }
//        });
//
//    }


// Methods from using a JSON to POJO converter that I did not use
//    @SerializedName("collects")
//    @Expose
//    private List<Collect> collects = null;
//
//    public List<Collect> getCollects() {
//        return collects;
//    }
//
//    public void setCollects(List<Collect> collects) {
//        this.collects = collects;
//    }
//
//    @SerializedName("products")
//    @Expose
//    private List<Product> products = null;
//
//    public List<Product> getProducts() {
//        return products;
//    }
//
//    public void setProducts(List<Product> products) {
//        this.products = products;
//    }

}

// Attempt at using Retrofit (this one for testing purposes)
// MY EXPLANATION ON HOW RETROFIT WORKS
    /* These methods get the body of the call's response using retrofit
    1. We create a service using retrofit, depending on what we need
    2. We use the service to receive the call object (dependent on id parameter)
    3. We execute the call to get the response and return the body (POJO)*/


//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://shopicruit.myshopify.com/admin/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        ShopifyCollectService shopifyCollectService = retrofit.create(ShopifyCollectService.class);
//        Call<List<Collect>> call = shopifyCollectService.listCollect();
//        call.enqueue(new Callback<List<Collect>>() {
//            @Override
//            public void onResponse(Call<List<Collect>> call, Response<List<Collect>> response) {
//                if(!response.isSuccessful()) {
//                    Log.d("ERROR", Integer.toString(response.code()));
//                    return;
//                }
//
//                List<Collect> collectList = response.body();
//                Log.d("SUCCESS", collectList.get(0).getCreatedAt());
//            }
//
//            @Override
//            public void onFailure(Call<List<Collect>> call, Throwable t) {
//                Log.d("ERROR", t.getMessage());
//            }
//        });
//        try {
//            Log.d("ERROR", getCollectResponse("68424466488").get(0).getId().toString());
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.out.println("oh no");
//        }

//        OTHER RETROFIT STUFF (interfaces and methods, I made another interface in a separate file)
//Retrofit
// Interface classes get the specific API access point and can return the call list
// This depends on the id being passed in, which can change

//Collect was modified for debugging: refer to product for proper form
//    public interface ShopifyCollectService {
//        @GET("admin/collects.json?collection_id=68424466488&page=1&access_token=c32313df0d0ef512ca64d5b336a0d7c6")
//        Call<List<Collect>> listCollect();//@Query("collection_id") String collection_id,
////                                        @Query ("page") int page,
////                                        @Query("access_token") String at);//"c32313df0d0ef512ca64d5b336a0d7c6");
//    }

//public interface ShopifyProductService {
//    @GET("admin/products.json?ids={ids}&page=1&access_token=c32313df0d0ef512ca64d5b336a0d7c6")
//    Call<List<Product>> listProduct(@Path("ids") String product_ids);
//}


//    public List<Product> getProductResponse(String product_id) throws IOException {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://shopicruit.myshopify.com/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        ShopifyProductService service = retrofit.create(ShopifyProductService.class);
//        Call<List<Product>> listProduct = service.listProduct(product_id);
//        return listProduct.execute().body();

//    }

//    public List<Collect> getCollectResponse(String collection_id) throws IOException {
//        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://shopicruit.myshopify.com/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .client(httpClient.build())
//                .build();

        //Trying to debug
//        ShopifyCollectService service = retrofit.create(ShopifyCollectService.class);
//        Call<List<Collect>> listCollect = service.listCollect();//collection_id, 1,"c32313df0d0ef512ca64d5b336a0d7c6");
//        listCollect.enqueue(new Callback<List<Collect>>() {
//            @Override
//            public void onResponse(Call<List<Collect>> call, Response<List<Collect>> response) {
//                if(!response.isSuccessful()) {
//                    System.out.println(response.code());
//                    return;
//                }
//
//                List<Collect> result = response.body();
//                System.out.println("Hello this is what you want: " + result);
//            }
//
//            @Override
//            public void onFailure(Call<List<Collect>> call, Throwable t) {
//                System.out.println("you fail");
//            }
//        });
//        System.out.println(listCollect);
//        System.out.println(listCollect.isExecuted());
//
//        Response<List<Collect>> listResponse = listCollect.execute();
//        listCollect.cancel();
//        List<Collect> response = listResponse.body();
//        return response;

        /*ShopifyCollectService service = retrofit.create(ShopifyCollectService.class);
        Call<List<Collect>> listCollect = service.listCollect();//collection_id, 1,"c32313df0d0ef512ca64d5b336a0d7c6");
        Response<List<Collect>> listResponse = listCollect.execute();
        List<Collect> response = listResponse.body();
        return response;
        * */
//    }




