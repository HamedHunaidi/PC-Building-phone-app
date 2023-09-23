package com.example.rigmaker.view.fragments;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.example.rigmaker.R;
import com.example.rigmaker.databinding.FragmentCreateRigBinding;
import com.example.rigmaker.model.Case;
import com.example.rigmaker.model.Cpu;
import com.example.rigmaker.model.CpuCooler;
import com.example.rigmaker.model.Gpu;
import com.example.rigmaker.model.Monitor;
import com.example.rigmaker.model.Motherboard;
import com.example.rigmaker.model.PowerSupply;
import com.example.rigmaker.model.Ram;
import com.example.rigmaker.model.Rig;
import com.example.rigmaker.model.Storage;
import com.example.rigmaker.view.activities.MainActivity;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//fragment to create the rig from a database of elements
public class CreateRigFragment extends Fragment {

    private FragmentCreateRigBinding binding;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("rig_data");

    List<Case> caseList;
    List<CpuCooler> cpuCoolerList;
    List<Cpu> cpuList;
    List<Gpu> gpuList;
    List<Monitor> monitorList;
    List<Motherboard> motherboardList;
    List<PowerSupply> powerSupplyList;
    List<Ram> ramList;
    List<Storage> storageList;
    String rigName = "";
    String author = "";
    boolean ready_for_suggested = false;
    boolean ready_for_community = false;
    Case rigCase;
    CpuCooler rigCpuCooler;
    Cpu rigCpu;
    Gpu rigGpu;
    Monitor rigMonitor;
    Motherboard rigMotherboard;
    PowerSupply rigPowerSupply;
    Ram rigRam;
    Storage rigStorage;


    public CreateRigFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCreateRigBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.popup_insert_extra_data, null);
        EditText et_name_of_build = alertLayout.findViewById(R.id.et_name_of_build);
        SwitchMaterial switch_suggested_build = alertLayout.findViewById(R.id.switch_suggested_build);
        SwitchMaterial switch_community_build = alertLayout.findViewById(R.id.switch_community_build);
        EditText et_author = alertLayout.findViewById(R.id.et_author);
        Button btn_updateRig = alertLayout.findViewById(R.id.btn_update_rig_data);
        Button btn_cancel = alertLayout.findViewById(R.id.btn_cancel);


        AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
        alert.setTitle("Enter Data");
        alert.setView(alertLayout);
        alert.setCancelable(false);
        AlertDialog dialog = alert.create();
        btn_updateRig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(et_name_of_build.getText()) || !TextUtils.isEmpty(et_author.getText())) {
                    rigName = et_name_of_build.getText().toString();
                    author = et_author.getText().toString();
                    ready_for_suggested = switch_suggested_build.isChecked();
                    ready_for_community = switch_community_build.isChecked();
                    Log.d("PcArmy", "onViewCreated: " + "" + rigName + " " + author + " " + ready_for_suggested + ready_for_community);
                } else {
                    Toast.makeText(getContext(), "Data incomplete", Toast.LENGTH_SHORT).show();
                }
                dialog.dismiss();
            }
        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), MainActivity.class));
            }
        });


        dialog.show();


        myRef.child("data").child("caseData").addValueEventListener(new ValueEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                long value = snapshot.getChildrenCount();
                GenericTypeIndicator<List<Case>> genericTypeIndicator = new GenericTypeIndicator<List<Case>>() {
                };
                caseList = snapshot.getValue(genericTypeIndicator);
                ArrayList<String> spinnerCaseList = new ArrayList<String>();
                if (caseList != null) {
                    caseList.forEach(it -> {
                        spinnerCaseList.add(it.getBrandName() + it.getModelName());
                    });
                    ArrayAdapter<String> caseAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, spinnerCaseList);
                    binding.spCaseSelect.setAdapter(caseAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        myRef.child("data").child("cpuCoolerData").addValueEventListener(new ValueEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                long value = snapshot.getChildrenCount();
                GenericTypeIndicator<List<CpuCooler>> genericTypeIndicator = new GenericTypeIndicator<List<CpuCooler>>() {
                };
                cpuCoolerList = snapshot.getValue(genericTypeIndicator);
                ArrayList<String> cpuCoolerDataSpinnerList = new ArrayList<String>();
                if (cpuCoolerList != null) {
                    cpuCoolerList.forEach(it -> {
                        cpuCoolerDataSpinnerList.add(it.getBrandName() + it.getModelName());
                    });
                    ArrayAdapter<String> cpuCoolerAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, cpuCoolerDataSpinnerList);
                    binding.spCpuCoolerSelect.setAdapter(cpuCoolerAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        myRef.child("data").child("cpuData").addValueEventListener(new ValueEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                long value = snapshot.getChildrenCount();
                GenericTypeIndicator<List<Cpu>> genericTypeIndicator = new GenericTypeIndicator<List<Cpu>>() {
                };
                cpuList = snapshot.getValue(genericTypeIndicator);
                ArrayList<String> cpuSpinnerList = new ArrayList<String>();
                if (cpuList != null) {
                    cpuList.forEach(it -> {
                        cpuSpinnerList.add(it.getBrandName() + it.getModelName());
                    });
                    ArrayAdapter<String> cpuCoolerAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, cpuSpinnerList);
                    binding.spCpuSelect.setAdapter(cpuCoolerAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        myRef.child("data").child("gpuData").addValueEventListener(new ValueEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                long value = snapshot.getChildrenCount();
                GenericTypeIndicator<List<Gpu>> genericTypeIndicator = new GenericTypeIndicator<List<Gpu>>() {
                };
                gpuList = snapshot.getValue(genericTypeIndicator);
                ArrayList<String> gpuSpinnerList = new ArrayList<String>();
                if (gpuList != null) {
                    gpuList.forEach(it -> {
                        gpuSpinnerList.add(it.getBrandName() + it.getModelName());
                    });
                    ArrayAdapter<String> cpuCoolerAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, gpuSpinnerList);
                    binding.spGpuSelect.setAdapter(cpuCoolerAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        myRef.child("data").child("monitorData").addValueEventListener(new ValueEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                long value = snapshot.getChildrenCount();
                GenericTypeIndicator<List<Monitor>> genericTypeIndicator = new GenericTypeIndicator<List<Monitor>>() {
                };
                monitorList = snapshot.getValue(genericTypeIndicator);
                ArrayList<String> monitorSpinnerList = new ArrayList<String>();
                if (monitorList != null) {
                    monitorList.forEach(it -> {
                        monitorSpinnerList.add(it.getBrandName() + it.getModelName());
                    });
                    ArrayAdapter<String> cpuCoolerAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, monitorSpinnerList);
                    binding.spMonitorSelect.setAdapter(cpuCoolerAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        myRef.child("data").child("motherboardData").addValueEventListener(new ValueEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                long value = snapshot.getChildrenCount();
                GenericTypeIndicator<List<Motherboard>> genericTypeIndicator = new GenericTypeIndicator<List<Motherboard>>() {
                };
                motherboardList = snapshot.getValue(genericTypeIndicator);
                ArrayList<String> motherBoardSpinnerList = new ArrayList<String>();
                if (motherboardList != null) {
                    motherboardList.forEach(it -> {
                        motherBoardSpinnerList.add(it.getBrandName() + it.getModelName());
                    });
                    ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, motherBoardSpinnerList);
                    binding.spMotherboardSelect.setAdapter(spinnerAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        myRef.child("data").child("powerSupplyData").addValueEventListener(new ValueEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                long value = snapshot.getChildrenCount();
                GenericTypeIndicator<List<PowerSupply>> genericTypeIndicator = new GenericTypeIndicator<List<PowerSupply>>() {
                };
                powerSupplyList = snapshot.getValue(genericTypeIndicator);
                ArrayList<String> spinnerList = new ArrayList<String>();
                if (powerSupplyList != null) {
                    powerSupplyList.forEach(it -> {
                        spinnerList.add(it.getBrandName() + it.getModelName());
                    });
                    ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, spinnerList);
                    binding.spPowerSupplySelect.setAdapter(spinnerAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        myRef.child("data").child("ramData").addValueEventListener(new ValueEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                long value = snapshot.getChildrenCount();
                GenericTypeIndicator<List<Ram>> genericTypeIndicator = new GenericTypeIndicator<List<Ram>>() {
                };
                ramList = snapshot.getValue(genericTypeIndicator);
                ArrayList<String> spinnerList = new ArrayList<String>();
                if (ramList != null) {
                    ramList.forEach(it -> {
                        spinnerList.add(it.getBrandName() + it.getModelName());
                    });
                    ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, spinnerList);
                    binding.spRamSelect.setAdapter(spinnerAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        myRef.child("data").child("storageData").addValueEventListener(new ValueEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                long value = snapshot.getChildrenCount();
                GenericTypeIndicator<List<Storage>> genericTypeIndicator = new GenericTypeIndicator<List<Storage>>() {
                };
                storageList = snapshot.getValue(genericTypeIndicator);
                ArrayList<String> spinnerList = new ArrayList<String>();
                if (storageList != null) {
                    storageList.forEach(it -> {
                        spinnerList.add(it.getBrandName() + it.getModelName());
                    });
                    ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, spinnerList);
                    binding.spStorageSelect.setAdapter(spinnerAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        binding.btnCreateBuild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rigCpu = cpuList.get(binding.spCpuSelect.getSelectedItemPosition());
                rigCase = caseList.get(binding.spCaseSelect.getSelectedItemPosition());
                rigCpuCooler = cpuCoolerList.get(binding.spCpuCoolerSelect.getSelectedItemPosition());
                rigGpu = gpuList.get(binding.spGpuSelect.getSelectedItemPosition());
                rigMonitor = monitorList.get(binding.spMonitorSelect.getSelectedItemPosition());
                rigMotherboard = motherboardList.get(binding.spMotherboardSelect.getSelectedItemPosition());
                rigPowerSupply = powerSupplyList.get(binding.spPowerSupplySelect.getSelectedItemPosition());
                rigRam = ramList.get(binding.spRamSelect.getSelectedItemPosition());
                rigStorage = storageList.get(binding.spStorageSelect.getSelectedItemPosition());

                double rigPrice = rigCpu.getPrice()+
                        rigCase.getPrice()+
                        rigCpuCooler.getPrice()+
                        rigGpu.getPrice()+
                        rigMonitor.getPrice()+
                        rigMotherboard.getPrice()+
                        rigPowerSupply.getPrice()+
                        rigRam.getPrice()+
                        rigStorage.getPrice();


                Rig rig = new Rig(
                        rigName,
                        rigPrice,
                        "extreme",
                        cpuList.get(binding.spCpuSelect.getSelectedItemPosition()),
                        caseList.get(binding.spCaseSelect.getSelectedItemPosition()),
                        cpuCoolerList.get(binding.spCpuCoolerSelect.getSelectedItemPosition()),
                        gpuList.get(binding.spGpuSelect.getSelectedItemPosition()),
                        monitorList.get(binding.spMonitorSelect.getSelectedItemPosition()),
                        motherboardList.get(binding.spMotherboardSelect.getSelectedItemPosition()),
                        powerSupplyList.get(binding.spPowerSupplySelect.getSelectedItemPosition()),
                        ramList.get(binding.spRamSelect.getSelectedItemPosition()),
                        storageList.get(binding.spPowerSupplySelect.getSelectedItemPosition()),
                        ready_for_suggested,
                        ready_for_community,
                        author
                );
                if (rigName.length() == 0){

                }else{
                    Toast.makeText(getContext(), "Entered your choices successfully", Toast.LENGTH_SHORT).show();
                    DatabaseReference ref = myRef.child("builds").push();
                    ref.setValue(rig);
                    NavHostFragment.findNavController(CreateRigFragment.this).navigateUp();
                }

            }
        });


    }
}