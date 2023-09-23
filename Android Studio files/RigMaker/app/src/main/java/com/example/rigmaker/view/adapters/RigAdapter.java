package com.example.rigmaker.view.adapters;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rigmaker.databinding.LayoutRigDataBinding;
import com.example.rigmaker.model.Rig;
import com.example.rigmaker.view.activities.RigDetailsActivity;

import java.util.ArrayList;

public class RigAdapter extends RecyclerView.Adapter<RigAdapter.MyViewHolder> {

    public ArrayList<Rig> rigList;
    OnDeleteClickedListener onDeleteClickedListener;

    public RigAdapter(ArrayList<Rig> rigList,OnDeleteClickedListener onDeleteClickedListener) {
        this.rigList = rigList;
        this.onDeleteClickedListener = onDeleteClickedListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutRigDataBinding.inflate((LayoutInflater.from(parent.getContext())),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Rig rigItem = rigList.get(position);
        holder.layoutRigDataBinding.tvRigName.setText(rigItem.getName());
        holder.layoutRigDataBinding.tvCreatedName.setText(rigItem.getBuildAuthor());
        holder.layoutRigDataBinding.tvPrice.setText("$"+rigItem.getPrice());
        holder.layoutRigDataBinding.tvCpu.setText(rigItem.getCpu().getBrandName());
        holder.layoutRigDataBinding.tvCpuCooler.setText(rigItem.getCpuCooler().getBrandName());
        holder.layoutRigDataBinding.tvGpu.setText(rigItem.getGpu().getBrandName());
        holder.layoutRigDataBinding.tvMotherboard.setText(rigItem.getMotherbaord().getBrandName());
        holder.layoutRigDataBinding.tvPowerSupply.setText(rigItem.getPowerSupply().getBrandName());
        holder.layoutRigDataBinding.tvRam.setText(rigItem.getRam().getBrandName());
        holder.layoutRigDataBinding.tvStorage.setText(rigItem.getStorgage().getBrandName());
        holder.layoutRigDataBinding.tvCase.setText(rigItem.getStorgage().getBrandName());
        holder.layoutRigDataBinding.tvMonitor.setText(rigItem.getMonitor().getBrandName());
       holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent rigDetailIntent= new Intent((holder.itemView.getContext()), RigDetailsActivity.class);
               rigDetailIntent.putExtra("rigname",rigItem.getName());
               holder.itemView.getContext().startActivity(rigDetailIntent);
           }
       });

       holder.layoutRigDataBinding.ivDelete.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               onDeleteClickedListener.onItemClicked(rigItem,position);
           }
       });


    }

    @Override
    public int getItemCount() {
        return rigList==null ? 0 : rigList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        LayoutRigDataBinding layoutRigDataBinding;

        public MyViewHolder(LayoutRigDataBinding layoutRigDataBinding) {
            super(layoutRigDataBinding.getRoot());
            this.layoutRigDataBinding = layoutRigDataBinding;

        }
    }

    public interface OnDeleteClickedListener{
        void onItemClicked(Rig rig,int position);
    }

}
