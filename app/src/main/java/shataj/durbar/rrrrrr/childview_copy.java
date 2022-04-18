package shataj.durbar.rrrrrr;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class childview_copy extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<childitem>postList=new ArrayList<>();
    int vt1=1;
    int vt2=2;
    Context context;

    public childview_copy(List<childitem>postList) {
        this.postList = postList;
    }




    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;

        view= LayoutInflater.from(parent.getContext()).inflate(R.layout.chilitem,parent,false);
        return  new child(view);

    }



    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int p) {
        childitem post=postList.get(p);

        Log.d("pmpmpm",String.valueOf(postList.size()));

        child child = (child) holder;
        child.id.setText(post.id);
        child.title.setText(post.title);
    }


    @Override
    public int getItemCount() {
        return postList.size();
    }

    class itemtitle extends RecyclerView.ViewHolder{

        TextView catid;
        public itemtitle(@NonNull View itemView) {
            super(itemView);
            catid=itemView.findViewById(R.id.catname);
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



}

