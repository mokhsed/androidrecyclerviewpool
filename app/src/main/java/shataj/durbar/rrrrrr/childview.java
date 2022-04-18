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


public class childview extends RecyclerView.Adapter<childview.child> {

    List<childitem>postList=new ArrayList<>();
    int vt1=1;
    int vt2=2;
    Context context;

    public childview(List<childitem>postList) {
        this.postList = postList;
    }


    @NonNull
    @Override
    public child onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.chilitem,parent,false);
        return new child(view);

    }

    @Override
    public void onBindViewHolder(@NonNull child holder, int position) {
childitem childitem=postList.get(position);
holder.id.setText(childitem.id);
holder.title.setText(childitem.title);

    }

    @Override
    public int getItemCount() {
        return postList.size();
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

