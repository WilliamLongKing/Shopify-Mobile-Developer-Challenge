package com.kingapps.shopifymobiledeveloperchallenge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CollectActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProductsRecyclerViewAdapter productsRecyclerViewAdapter;
    private ArrayList<Product> productArrayList;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        productArrayList = new ArrayList<>();
        requestQueue = Volley.newRequestQueue(this);
        //parseJSON();
    }

// My attempt at getting the JSON response into objects. I was able to establish contact with the
// API, but had trouble in adding Products to my arraylist.
//    private void parseJSON(String url) {
//        JsonObjectRequest request = new JsonObjectRequest(com.android.volley.Request.Method.GET, url,
//                null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                try {
//                    JSONArray jsonArray = response.getJSONArray("products");
//                    for (int i = 0; i < jsonArray.length(); i++) {
//                        JSONObject product = jsonArray.getJSONObject(i);
//
//                        String title = product.getString("title");
//                        String tags = product.getString("tags");
//                        int inventory = 0;
//                        //ArrayList<Product> = product.
//                        //for(Variant variant: )
////                        productArrayList.add(new Product(Integer.parseInt(id),
////                                Integer.parseInt(collectionId), Integer.parseInt(product_id), featured,
////                                createdAt, updatedAt, position, sort_value));
////                    }
//
//                    productsRecyclerViewAdapter = new ProductsRecyclerViewAdapter(CollectActivity.this, productArrayList);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                error.printStackTrace();
//            }
//        });
//
//        mQueue.add(request);
//    }
}
