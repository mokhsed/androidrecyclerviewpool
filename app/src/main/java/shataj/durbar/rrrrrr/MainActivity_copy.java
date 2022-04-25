package shataj.durbar.rrrrrr;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActivity_copy extends AppCompatActivity {

    RequestQueue requestQueue;

    List<childitem>postList;
    List<main>mainList;
    main main;
    RecyclerView RecyclerViewmain;
    adepter_new adepter;
    LinearLayoutManager linearLayoutManager;
    ConcatAdapter concatAdapter;
    childitem post;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerViewmain=findViewById(R.id.main);
    requestQueue= Volley.newRequestQueue(this);
      //  main=new main();
       // postList=new ArrayList<>();
patchdata();

       // linearLayoutManager=new LinearLayoutManager(MainActivity.this);
        //adepter=new adepter_new(loadDataislamic(),MainActivity.this);
        //adepter.notifyDataSetChanged();
        //RecyclerViewmain.setLayoutManager(linearLayoutManager);
        // concatAdapter=new ConcatAdapter(adepter);
        //RecyclerViewmain.setAdapter(adepter);


    }




    private void patchdata() {
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest("http://serabd.xyz/Boigor/test.json", new com.android.volley.Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                mainList=new ArrayList<>();
                postList=new ArrayList<>();

                Log.d("catid",response.toString());
                Iterator keys = response.keys();
                while (keys.hasNext()) {
                    main = new main();
                    String currentDynamicKey = (String) keys.next();
                    main.setCurrentDynamicKey(currentDynamicKey);
                    try {
                        Log.d("testddd",currentDynamicKey);
                        JSONArray jsonArray=response.getJSONArray(currentDynamicKey);
                        for(int i=0;jsonArray.length()>i;i++){
                          post=new childitem();
                        JSONObject jsonObject=jsonArray.getJSONObject(i);
                        post.setId(jsonObject.getString("id"));
                        post.setTitle(jsonObject.getString("title"));
                        String id=jsonObject.getString("id");
                        String title=jsonObject.getString("title");
                        post=new childitem(id,title);
                        postList.add(post);
                        Log.d("ddddd",String.valueOf(postList.size()));

                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                   main.setPostList(postList);
                    mainList.add(main);
                    saveDatamain(mainList);
                    loadDatamain();

                            }

            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue.add(jsonObjectRequest);


    }




    private List<main> loadDatamain() {
        SharedPreferences sharedPreferences = getSharedPreferences("islamic", 0);
        // creating a variable for gson.
        Gson gson = new Gson();
        // below line is to get to string present from our
        // shared prefs if not present setting it as null.
        String json = sharedPreferences.getString("courses", null);

        // below line is to get the type of our array list.
        Type type = new TypeToken<ArrayList<main>>() {}.getType();

        // in below line we are getting data from gson
        // and saving it to our array list
        mainList = gson.fromJson(json, type);
//        Log.d("chhhh",String.valueOf(itemList.size()));
        // checking below if the array list is empty or not
        if (mainList == null) {
            // if the array list is empty
            // creating a new array list.
            mainList = new ArrayList<>();

        }

        return mainList;
    }






    private void saveDatamain(List<main>itl) {
        // method for saving the data in array list.
        // creating a variable for storing data in
        // shared preferences.
        SharedPreferences sharedPreferences =getSharedPreferences("islamic", 0);

        // creating a variable for editor to
        // store data in shared preferences.
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // creating a new variable for gson.
        Gson gson = new Gson();

        // getting data from gson and storing it in a string.
        String json = gson.toJson(itl);

        // below line is to save data in shared
        // prefs in the form of string.
        editor.putString("courses", json);

        // below line is to apply changes
        // and save data in shared prefs.
        editor.apply();
        // after saving data we are displaying a toast message.
        // Toast.makeText(getActivity(), "Saved Array List to Shared preferences.", Toast.LENGTH_SHORT).show();
      setadepter();

    }

    private void setadepter() {
        linearLayoutManager=new LinearLayoutManager(MainActivity_copy.this);
        adepter=new adepter_new(loadDatamain());
        adepter.notifyDataSetChanged();
        RecyclerViewmain.setLayoutManager(linearLayoutManager);
        // concatAdapter=new ConcatAdapter(adepter);
        RecyclerViewmain.setAdapter(adepter);
        RecyclerViewmain.setHasFixedSize(true);

    }


}


