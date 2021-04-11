package com.example.kt_app;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements IOnBackPressed{
    String url = "http://192.168.43.185:8080/db_dacs3/search.php";
    public String[] destination = new String[]{"Hà Nội", "Đà Nẵng", "Hồ Chí Minh"};
    String [] category = new String[]{"Ăn Uống", "Chụp Hình", "Dã Ngoại", "Mua Sắm", "Dạo Phố", "Tắm Biển" };
    public AutoCompleteTextView autoCompleteTextView;
    public AutoCompleteTextView autoCompleteTextView2;
    public Button search_btn;
    String txtcity, txtcategory;
    public HomeFragment() {
    }

    @SuppressLint("WrongViewCast")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentManager fragmentManager = getFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        autoCompleteTextView = view.findViewById(R.id.dtnt_edt);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.select_dialog_item,destination);
        autoCompleteTextView.setThreshold(1);
        autoCompleteTextView.setAdapter(adapter);

        autoCompleteTextView2 = view.findViewById(R.id.ctgr_edt);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getActivity(), android.R.layout.select_dialog_item,category);
        autoCompleteTextView2.setThreshold(1);
        autoCompleteTextView2.setAdapter(adapter1);

        search_btn = view.findViewById(R.id.search_btn);
        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 txtcity = autoCompleteTextView.getText().toString().trim();
                 txtcategory = autoCompleteTextView2.getText().toString().trim();
                if (txtcity.isEmpty()|| txtcategory.isEmpty()){
                    Toast.makeText(getActivity(), "Vui lòng nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                }
                else {
//                    search(url);
                    SearchFragment searchFragment = new SearchFragment();
                    searchFragment.city = autoCompleteTextView.getText().toString().trim();
                    searchFragment.category = autoCompleteTextView2.getText().toString().trim();
                    fragmentTransaction.add(R.id.main_frame, searchFragment);
                    fragmentTransaction.addToBackStack("result");
                    fragmentTransaction.commit();
                }

            }
        });
        return view;
    }

    @Override
    public boolean onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount()>0){
            getFragmentManager().popBackStack();
            return true;
        }
        return false;
    }
    /*public void search(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                }
            },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                }
            }
            )*//*{
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("city",txtcity);
                params.put("category",txtcategory);
                return super.getParams();
            }
        }*//*;
    }*/
}
