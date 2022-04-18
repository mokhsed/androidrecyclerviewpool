package shataj.durbar.rrrrrr;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class adepter_new extends RecyclerView.Adapter<adepter_new.itemtitle> {

    List<main>postList=new ArrayList<>();
    int vt1=1;
    int vt2=2;
    Context context;
childitem post;
List<childitem>childitemList;
RequestQueue requestQueue;
    RecyclerView.RecycledViewPool recycledViewPool=new RecyclerView.RecycledViewPool();

    public adepter_new(List<main> main) {
        this.postList = main;
    }



    @NonNull
    @Override
    public itemtitle onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View  view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cattitle,parent,false);
        context=parent.getContext();
        requestQueue= Volley.newRequestQueue(context);
        return new itemtitle(view);
    }

    @Override
    public void onBindViewHolder(@NonNull itemtitle holder, int position) {
        main mm=postList.get(position);
        holder.catname.setText(mm.getCurrentDynamicKey());


        LinearLayoutManager layoutManager
                = new LinearLayoutManager(holder.childrecyclerview.getContext(),
                LinearLayoutManager.HORIZONTAL,
                false);

        layoutManager.setInitialPrefetchItemCount(postList.get(position).getPostList().size());
        childview childItemAdapter = new childview(postList.get(position).getPostList());


        holder.childrecyclerview.setLayoutManager(layoutManager);
        holder.childrecyclerview.setAdapter(childItemAdapter);
        holder.childrecyclerview.setHasFixedSize(true);
        holder.childrecyclerview.setRecycledViewPool(recycledViewPool);
        patchdata();


    }

    @Override
    public int getItemCount() {
        return postList.size();
    }


    class itemtitle extends RecyclerView.ViewHolder{

        TextView catname;
        RecyclerView childrecyclerview;
        public itemtitle(@NonNull View itemView) {
            super(itemView);
            catname=itemView.findViewById(R.id.catname);
            childrecyclerview=itemView.findViewById(R.id.child_recyclerview);
            childrecyclerview.setNestedScrollingEnabled(false);
            //childrecyclerview.setLayoutManager(horizontalManager);
            childrecyclerview.setItemAnimator(new DefaultItemAnimator());

        }


    }
    class child extends RecyclerView.ViewHolder{

        TextView id;
        TextView title;
        public child(@NonNull View itemView) {
            super(itemView);
            id=itemView.findViewById(R.id.id);
            title=itemView.findViewById(R.id.title);

        }
    }

    private void patchdata() {
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest("http://serabd.xyz/Boigor/test.json", new com.android.volley.Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
             //   mainList=new ArrayList<>();
                childitemList=new ArrayList<>();

                Log.d("catid",response.toString());
                Iterator keys = response.keys();
                while (keys.hasNext()) {
               //     main = new main();
                    String ckey = (String) keys.next();
                 //   main.setCurrentDynamicKey(currentDynamicKey);
                    try {
                        Log.d("testddd",ckey);
                        JSONArray jsonArray=response.getJSONArray(ckey);
                        for(int i=0;jsonArray.length()>i;i++){
                            post=new childitem();
                            JSONObject jsonObject=jsonArray.getJSONObject(i);
                            post.setId(jsonObject.getString("id"));
                            post.setTitle(jsonObject.getString("title"));
                            String id=jsonObject.getString("id");
                            String title=jsonObject.getString("title");
                            post=new childitem(id,title);
                            childitemList.add(post);
                            Log.d("kkkk",String.valueOf(childitemList.size()));
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }



          //          main.setPostList(postList);
            //        mainList.add(main);
              //      saveDatamain(mainList);
                //    loadDatamain();

                }


                //}
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue.add(jsonObjectRequest);


    }





}

