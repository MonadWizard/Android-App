package com.example.recycleviewdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.Viewholder> {

    private List<MOdelClass> modelClassList;

    public Adapter(List<MOdelClass> modelClassList){
        this.modelClassList = modelClassList;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout,viewGroup,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder viewholder, int position) {
        int resource = modelClassList.get(position).getImage_resource();
        String title = modelClassList.get(position).getTitle();
        String body = modelClassList.get(position).getBody();
        viewholder.setData(resource,title,body);
    }

    @Override
    public int getItemCount() {
        return modelClassList.size();
    }








    class Viewholder extends  RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView title;
        private TextView body;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            imageView= itemView.findViewById(R.id.imageView);
            title = itemView.findViewById(R.id.txt_titel);
            body = itemView.findViewById(R.id.txt_body);

        }


        private void setData(int resource, String titleTxt, String bodyTxt){
            imageView.setImageResource(resource);
            title.setText(titleTxt);
            body.setText(bodyTxt);
        }









    }














}
