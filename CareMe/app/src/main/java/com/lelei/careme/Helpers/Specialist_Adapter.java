package com.lelei.careme.Helpers;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lelei.careme.CareSeeker.Available_Doctors;
import com.lelei.careme.Models.Main_Specialisation;
import com.lelei.careme.R;

import java.util.ArrayList;

public class Specialist_Adapter extends RecyclerView.Adapter<Specialist_Adapter.ViewHolder> {

    private ArrayList<Main_Specialisation> main_specialisations;
    private Context context;
    private String specialtiy_type;

    public Specialist_Adapter(ArrayList<Main_Specialisation> main_specialisations, Context context) {
        this.main_specialisations = main_specialisations;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.speciality_item,parent,false);

        ViewHolder viewHolder=new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Main_Specialisation speciality_data=main_specialisations.get(viewHolder.getAdapterPosition());
                specialtiy_type=speciality_data.getSpecialisation_type();

                Intent intent=new Intent(view.getContext(), Available_Doctors.class);
                intent.putExtra("Speciality_type",specialtiy_type);
                intent.putExtra("flag",1+"");
                view.getContext().startActivity(intent);

            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.spec_image.setImageResource(main_specialisations.get(position).getSpecialisation_pic());
        holder.spec_text.setText(main_specialisations.get(position).getSpecialisation_type());

    }

    @Override
    public int getItemCount() {
        return main_specialisations.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView spec_image;
        TextView spec_text;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            spec_image=itemView.findViewById(R.id.imageView_doc);
            spec_text=itemView.findViewById(R.id.speciality_textview);

        }
    }
}