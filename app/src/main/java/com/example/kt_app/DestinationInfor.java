package com.example.kt_app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DestinationInfor extends AppCompatActivity {
    TextView txttitle;
    TextView txtinfor;
    ImageView txt_image;
    ImageButton favorite_btn;
    ImageButton back_btn;
    String url = "http://192.168.43.185:8080/db_dacs3/update_favorite.php";
    int id_destination;
    int id_favorite;
    ListView listView;
    ArrayList<resultsearch> arrayList;
    SearchAdapter adapter;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination_infor);

        if (getIntent().hasExtra("destination")){
            listView = findViewById(R.id.listfavorite);
            arrayList = new ArrayList<>();
            adapter = new SearchAdapter(DestinationInfor.this,R.layout.destination, arrayList);
            resultsearch resultsearch = (com.example.kt_app.resultsearch) getIntent().getSerializableExtra("destination");
            String infor = resultsearch.getInfor();
            String title = resultsearch.getDestination();
            String image = resultsearch.getImg();
            id_favorite = resultsearch.getRating();
            id_destination = resultsearch.getId();
            txttitle = findViewById(R.id.title_infor);
            txtinfor = findViewById(R.id.txtinfo);
            txt_image = findViewById(R.id.image_infor);
            txttitle.setText(title);
            txtinfor.setText(infor);
            Picasso.with(this).load(image).into(txt_image);
        }

        favorite_btn = findViewById(R.id.favorite_btn);
        if (id_favorite == 1 ){
            favorite_btn.setImageResource(R.drawable.fvr);
        }
        else {
            favorite_btn.setImageResource(R.drawable.favorite_btn);
        }
        favorite_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (id_favorite == 0){
                    favorite_btn.setImageResource(R.drawable.fvr);
                    id_favorite = id_favorite+1;
                    getdata(url);
                    Toast.makeText(DestinationInfor.this, "Bạn đã thêm yêu thích", Toast.LENGTH_SHORT).show();
                }
                else {
                    favorite_btn.setImageResource(R.drawable.favorite_btn);
                    id_favorite = id_favorite-1;
                    getdata(url);
                    Toast.makeText(DestinationInfor.this, "Bạn đã hủy yêu thích", Toast.LENGTH_SHORT).show();
                }
            }
        });
        back_btn = findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
    public void getdata(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        adapter.notifyDataSetChanged();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("i", String.valueOf(id_favorite));
                params.put("id", String.valueOf(id_destination));
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
}
