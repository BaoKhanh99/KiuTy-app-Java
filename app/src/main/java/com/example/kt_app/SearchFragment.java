package com.example.kt_app;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {
    String url = "http://192.168.43.185:8080/db_dacs3/search.php";
    ListView listView;
    ArrayList<resultsearch> arrayList;
    SearchAdapter adapter;
    String city, category;

    public SearchFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        listView = view.findViewById(R.id.listdtnt);
        arrayList = new ArrayList<>();
        adapter = new SearchAdapter(getActivity(),R.layout.destination, arrayList);
        listView.setAdapter(adapter);
        getdata(url);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {

                Intent intent = new Intent(getActivity().getBaseContext(), DestinationInfor.class);
                intent.putExtra("destination",arrayList.get(position));
                startActivity(intent);

            }
        });
        return view ;
    }
    public void getdata(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (!response.trim().isEmpty()) {
                    try {
                        JSONObject object = new JSONObject(response);
                        JSONArray jsonArray = object.getJSONArray("search");
                        for (int i = 0; i < jsonArray.length(); i++){
                            final JSONObject object1 = jsonArray.getJSONObject(i);
                            arrayList.add(new resultsearch(
                                    object1.getInt("id"),
                                    object1.getString("destination"),
                                    object1.getString("infor"),
                                    object1.getString("city"),
                                    object1.getInt("rating"),
                                    object1.getString("img"),
                                    BigDecimal.valueOf(object1.getDouble("point")).floatValue(),
                                    object1.getString("comments")
                            ));
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    adapter.notifyDataSetChanged();

                }
                else Toast.makeText(getActivity(), "lỗi", Toast.LENGTH_SHORT).show();
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("city",city);
                params.put("category",category);
                return params;
            }
        };

        requestQueue.add(stringRequest);
    }

}

