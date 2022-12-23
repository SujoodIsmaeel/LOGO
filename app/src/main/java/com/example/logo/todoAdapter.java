package com.example.logo;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class todoAdapter extends RecyclerView.Adapter<todoAdapter.ViewHolder> {
    //initialize variables

    private List<TodoData> dataList;
    private Activity context;

    AlertDialog.Builder builder;



    public todoAdapter(List<TodoData> dataList, Activity context) {
        this.dataList = dataList;
        this.context = context;
        notifyDataSetChanged();
    }

    @NonNull

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //initialize view
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.todolist,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull todoAdapter.ViewHolder holder, int position) {
        //int main data
        TodoData data=dataList.get(position);
        //set text in textview
        holder.textView.setText(data.getText());

        holder.btEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //init main data
                TodoData d=dataList.get(holder.getAdapterPosition());
                //get id
                int sID = d.getID();
                //get text
                String sText = d.getText();

                //create dialog
                Dialog dialog = new Dialog(context);
                // set content view

                dialog.setContentView(R.layout.todoupdate);

                //init width

                int width= WindowManager.LayoutParams.MATCH_PARENT;
                //int height

                int height=WindowManager.LayoutParams.WRAP_CONTENT;
                //set layout

                dialog.getWindow().setLayout(width,height);

                //show dialog

                dialog.show();


                EditText editText=dialog.findViewById(R.id.edit_text);
                Button btUpdate=dialog.findViewById(R.id.bt_update);


                editText.setText(sText);

                btUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        String uText=editText.getText().toString().trim();
                        TodoData data = new TodoData();
                        data.setText(uText);
                        dataList.set(holder.getAdapterPosition(),data);
                        notifyDataSetChanged();


                    }
                });




            }
        });

        holder.btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder= new AlertDialog.Builder(v.getContext());
                //Setting message manually and performing action on button click
                builder.setMessage("Are you sure you want to delete this task?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                TodoData d=dataList.get(holder.getAdapterPosition());
                                int position = holder.getAdapterPosition();
                                dataList.remove(position);
                                notifyItemRemoved(position);
                                notifyItemRangeChanged(position,dataList.size());
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //  Action for 'NO' Button
                                dialog.cancel();
                            }
                        });
                //Creating dialog box
                AlertDialog alert = builder.create();
                //Setting the title manually
                alert.setTitle("DeleteConfirmation");
                alert.show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //init varivles

        TextView textView;
        ImageView btEdit,btDelete;

        public ViewHolder(@NonNull  View itemView) {
            super(itemView);
            //Assign variable
            textView=itemView.findViewById(R.id.text_view);
            btEdit=itemView.findViewById(R.id.bt_edit);
            btDelete=itemView.findViewById(R.id.bt_delete);


        }
    }
}