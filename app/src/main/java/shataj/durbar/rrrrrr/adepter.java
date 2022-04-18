package shataj.durbar.rrrrrr;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;



public class adepter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

List<main>postList=new ArrayList<>();
int vt1=1;
int vt2=2;
Context context;

RecyclerView.RecycledViewPool recycledViewPool=new RecyclerView.RecycledViewPool();

    public adepter(List<main> main) {
        this.postList = main;
    }


    @Override
    public int getItemViewType(int position) {
        return postList.size();
}


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
          View view;
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cattitle,parent,false);
            return  new itemtitle(view);
    }



    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int p) {

        main modelmain=postList.get(p);
    itemtitle itemHolder = (itemtitle) holder;
    itemHolder.catid.setText(modelmain.getCurrentDynamicKey());

    Log.d("key",modelmain.getCurrentDynamicKey());
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(
                ((itemtitle) holder).childrecyclerview.getContext(),
                LinearLayoutManager.HORIZONTAL,
                false);

        layoutManager.setInitialPrefetchItemCount(postList.get(p).getPostList().size());
        childview childItemAdapter = new childview(postList.get(p).getPostList());

        ((itemtitle) holder).childrecyclerview.setLayoutManager(layoutManager);
        ((itemtitle) holder).childrecyclerview.setAdapter(childItemAdapter);
        ((itemtitle) holder).childrecyclerview.setRecycledViewPool(recycledViewPool);
}

    @Override
    public int getItemCount() {
        return postList.size();
    }

class itemtitle extends RecyclerView.ViewHolder{

TextView catid;
RecyclerView childrecyclerview;
    public itemtitle(@NonNull View itemView) {
        super(itemView);
        catid=itemView.findViewById(R.id.catname);
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



}

