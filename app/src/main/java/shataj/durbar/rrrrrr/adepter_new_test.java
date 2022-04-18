package shataj.durbar.rrrrrr;

import android.content.Context;
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


public class adepter_new_test extends RecyclerView.Adapter<adepter_new_test.itemtitle> {

List<main>postList=new ArrayList<>();
int vt1=1;
int vt2=2;
Context context;

RecyclerView.RecycledViewPool recycledViewPool=new RecyclerView.RecycledViewPool();

    public adepter_new_test(List<main> main) {
        this.postList = main;
    }



    @NonNull
    @Override
    public itemtitle onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
     View  view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cattitle,parent,false);
      context=parent.getContext();
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



}

