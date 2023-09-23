package com.example.rigmaker.view.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.example.rigmaker.databinding.ActivityRigDetailsBinding;
import com.example.rigmaker.model.Rig;
import com.example.rigmaker.view.adapters.RigAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
//shows the rigdetails on the click of the button
public class RigDetailsActivity extends AppCompatActivity {

    private ActivityRigDetailsBinding binding;
    ArrayList<Rig> rigdata = new ArrayList<>();
    Rig rig=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityRigDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // firebase reference
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("rig_data");

        String str= getIntent().getStringExtra("rigname");
        binding.rigName.setText(str);

        myRef.child("builds").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // get all values from firebase
                for (DataSnapshot valueRes : snapshot.getChildren()){
                    Rig rig = valueRes.getValue(Rig.class);
                    rigdata.add(rig);
                }
                // gets the individual rig
                for (Rig i : rigdata){
                    if (i.getName().equals(str)){
                        rig=i;
                    }
                }


                //CPU
                binding.txtData.append("CPU:");
                binding.txtData.append("\n");
                binding.txtData.append(" Brand: ");
                binding.txtData.append(rig.getCpu().getBrandName()+".");
                binding.txtData.append("\n");
                binding.txtData.append(" Model: ");
                binding.txtData.append(rig.getCpu().getModelName()+".");
                binding.txtData.append("\n");
                binding.txtData.append(" Clock Speed: ");
                binding.txtData.append(rig.getCpu().getClockSpeed()+".");
                binding.txtData.append("\n");
                binding.txtData.append(" Cores: ");
                binding.txtData.append(rig.getCpu().getNumberOfCores()+".");
                binding.txtData.append("\n");
                binding.txtData.append(" Socket: ");
                binding.txtData.append(rig.getCpu().getSocket()+".");
                binding.txtData.append("\n");
                binding.txtData.append(" Price: $"+String.valueOf(rig.getCpu().getPrice())+".");
                binding.txtData.append("\n");

                //CPU Cooler
                binding.txtData.append("\n"+"CPU Cooler:");
                binding.txtData.append("\n");
                binding.txtData.append(" Brand: ");
                binding.txtData.append(rig.getCpuCooler().getBrandName()+".");
                binding.txtData.append("\n");
                binding.txtData.append(" Model: ");
                binding.txtData.append(rig.getCpuCooler().getModelName()+".");
                binding.txtData.append("\n");
                binding.txtData.append(" Clearance: ");
                binding.txtData.append(String.valueOf(rig.getCpuCooler().getClearance())+"mm.");
                binding.txtData.append("\n");
                binding.txtData.append(" Price: $"+String.valueOf(rig.getCpuCooler().getPrice())+".");
                binding.txtData.append("\n");


                //GPU
                binding.txtData.append("\n"+"Gpu:");
                binding.txtData.append("\n");
                binding.txtData.append(" Brand: ");
                binding.txtData.append(rig.getGpu().getBrandName()+".");
                binding.txtData.append("\n");
                binding.txtData.append(" Model: ");
                binding.txtData.append(rig.getGpu().getModelName()+".");
                binding.txtData.append("\n");
                binding.txtData.append(" Speed: ");
                binding.txtData.append(rig.getGpu().getSpeed()+".");
                binding.txtData.append("\n");
                binding.txtData.append(" Vram: ");
                binding.txtData.append(rig.getGpu().getVram()+".");
                binding.txtData.append("\n");
                binding.txtData.append(" Clearance: ");
                binding.txtData.append(String.valueOf(rig.getGpu().getClearance())+"mm.");
                binding.txtData.append("\n");
                binding.txtData.append(" Price: $"+String.valueOf(rig.getGpu().getPrice())+".");
                binding.txtData.append("\n");

                //Motherbaord
                binding.txtData.append("\n"+"Motherboard:");
                binding.txtData.append("\n");
                binding.txtData.append(" Brand: ");
                binding.txtData.append(rig.getMotherbaord().getBrandName()+".");
                binding.txtData.append("\n");
                binding.txtData.append(" Model: ");
                binding.txtData.append(rig.getMotherbaord().getModelName()+".");
                binding.txtData.append("\n");
                binding.txtData.append(" Socket: ");
                binding.txtData.append(rig.getMotherbaord().getSocket()+".");
                binding.txtData.append("\n");
                binding.txtData.append(" Form Factor: ");
                binding.txtData.append(rig.getMotherbaord().getFormFactor()+".");
                binding.txtData.append("\n");
                binding.txtData.append(" Price: $"+String.valueOf(rig.getMotherbaord().getPrice())+".");
                binding.txtData.append("\n");

                //Power Supply
                binding.txtData.append("\n"+"Power Supply:");
                binding.txtData.append("\n");
                binding.txtData.append(" Brand: ");
                binding.txtData.append(rig.getPowerSupply().getBrandName()+".");
                binding.txtData.append("\n");
                binding.txtData.append(" Model: ");
                binding.txtData.append(rig.getPowerSupply().getModelName()+".");
                binding.txtData.append("\n");
                binding.txtData.append(" Form Factor: ");
                binding.txtData.append(rig.getPowerSupply().getFormFactor()+".");
                binding.txtData.append("\n");
                binding.txtData.append(" Rating: ");
                binding.txtData.append(rig.getPowerSupply().getRating()+".");
                binding.txtData.append("\n");
                binding.txtData.append(" Wattage: ");
                binding.txtData.append(rig.getPowerSupply().getWattage()+".");
                binding.txtData.append("\n");
                binding.txtData.append("\n");
                binding.txtData.append(" Price: $"+String.valueOf(rig.getPowerSupply().getPrice())+".");
                binding.txtData.append("\n");

                //Ram
                binding.txtData.append("\n"+"Ram:");
                binding.txtData.append("\n");
                binding.txtData.append(" Brand: ");
                binding.txtData.append(rig.getRam().getBrandName()+".");
                binding.txtData.append("\n");
                binding.txtData.append(" Model: ");
                binding.txtData.append(rig.getRam().getModelName()+".");
                binding.txtData.append("\n");
                binding.txtData.append(" Speed: ");
                binding.txtData.append(rig.getRam().getSpeed()+".");
                binding.txtData.append("\n");
                binding.txtData.append(" Size: ");
                binding.txtData.append(rig.getRam().getSize()+".");
                binding.txtData.append("\n");
                binding.txtData.append(" Price: $"+String.valueOf(rig.getRam().getPrice())+".");
                binding.txtData.append("\n");

                //Storage
                binding.txtData.append("\n"+"Storage:");
                binding.txtData.append("\n");
                binding.txtData.append(" Brand: ");
                binding.txtData.append(rig.getStorgage().getBrandName()+".");
                binding.txtData.append("\n");
                binding.txtData.append(" Model: ");
                binding.txtData.append(rig.getStorgage().getModelName()+".");
                binding.txtData.append("\n");
                binding.txtData.append(" Size: ");
                binding.txtData.append(rig.getStorgage().getSize()+".");
                binding.txtData.append("\n");
                binding.txtData.append(" Type: ");
                binding.txtData.append(rig.getStorgage().getType()+".");
                binding.txtData.append("\n");
                binding.txtData.append("\n");
                binding.txtData.append(" Price: $"+String.valueOf(rig.getStorgage().getPrice())+".");
                binding.txtData.append("\n");

                //Case
                binding.txtData.append("\n"+"Case:");
                binding.txtData.append("\n");
                binding.txtData.append(" Brand: ");
                binding.txtData.append(rig.getPcCase().getBrandName()+".");
                binding.txtData.append("\n");
                binding.txtData.append(" Model: ");
                binding.txtData.append(rig.getPcCase().getModelName()+".");
                binding.txtData.append("\n");
                binding.txtData.append(" Size: ");
                binding.txtData.append(rig.getPcCase().getFormFactor()+".");
                binding.txtData.append("\n");
                binding.txtData.append(" Motherboard Form Factor : ");
                binding.txtData.append(rig.getPcCase().getMotherboardFormFactor()+".");
                binding.txtData.append("\n");
                binding.txtData.append(" PSU Form Factor: ");
                binding.txtData.append(rig.getPcCase().getPsuFormFactor());
                binding.txtData.append("\n");
                binding.txtData.append(" CPU Cooler Clearance: ");
                binding.txtData.append(String.valueOf(rig.getPcCase().getCpuCoolerClearance())+"mm.");
                binding.txtData.append("\n");
                binding.txtData.append(" GPU Clearance: ");
                binding.txtData.append(String.valueOf(rig.getPcCase().getGpuClearance())+"mm.");
                binding.txtData.append("\n");
                binding.txtData.append(" Price: $"+String.valueOf(rig.getPcCase().getPrice())+".");
                binding.txtData.append("\n");

                //Monitor
                binding.txtData.append("\n"+"Monitor:");
                binding.txtData.append("\n");
                binding.txtData.append(" Brand: ");
                binding.txtData.append(rig.getMonitor().getBrandName()+".");
                binding.txtData.append("\n");
                binding.txtData.append(" Model: ");
                binding.txtData.append(rig.getMonitor().getModelName()+".");
                binding.txtData.append("\n");
                binding.txtData.append(" Panel: ");
                binding.txtData.append(rig.getMonitor().getPanel());
                binding.txtData.append("\n");
                binding.txtData.append(" Refresh Rate: ");
                binding.txtData.append(rig.getMonitor().getRefreshRate()+".");
                binding.txtData.append("\n");
                binding.txtData.append(" Reasolution: ");
                binding.txtData.append(rig.getMonitor().getResolution()+".");
                binding.txtData.append("\n");
                binding.txtData.append(" Screen Size: ");
                binding.txtData.append(rig.getMonitor().getScreenSize()+".");
                binding.txtData.append("\n");
                binding.txtData.append(" Price: $"+String.valueOf(rig.getMonitor().getPrice())+".");
                binding.txtData.append("\n");





                Toast.makeText(RigDetailsActivity.this, ""+rig.getBuildAuthor(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
}