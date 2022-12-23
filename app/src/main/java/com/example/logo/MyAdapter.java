package com.example.logo;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context mContext;
    String mstrAdv[],mstrDesc[];
    int mImagelogo[];
    public MyAdapter(Context context,String strAdv[],String strDesc[],int imagelogo[]){
        mContext=context;
        mstrAdv=strAdv;
        mstrDesc=strDesc;
        mImagelogo=imagelogo;

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.my_row_item,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mTextAdv.setText(mstrAdv[position]);
        holder.mTextDesc.setText(mstrDesc[position]);
        holder.mImageLogo.setImageResource(mImagelogo[position]);
    }

    @Override
    public int getItemCount() {
        return mstrAdv.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mTextAdv,mTextDesc;
        ImageView mImageLogo;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextAdv=itemView.findViewById(R.id.tvadv);
            mTextDesc=itemView.findViewById(R.id.tvdesc);
            mImageLogo=itemView.findViewById(R.id.imageLogo);
        }
    }
}
