package com.example.rigmaker.view.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.rigmaker.R;
import com.example.rigmaker.databinding.FragmentCommunityBinding;
import com.example.rigmaker.model.Rig;
import com.example.rigmaker.view.adapters.RigAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//fragment to get the list of community fragment elements
public class CommunityFragment extends Fragment {

    private FragmentCommunityBinding binding;
    //get the firebase reference
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("rig_data");
    ArrayList<Rig> rigdata = new ArrayList<>();
    ArrayList<Rig> communityRigData = new ArrayList<>();

    public CommunityFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCommunityBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        myRef.child("builds").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //get all data from firebase and save to rigdata
                for (DataSnapshot valueRes : snapshot.getChildren()){
                    Rig rig = valueRes.getValue(Rig.class);
                    rigdata.add(rig);
                }
                //save the rigs that are community
                for (Rig i : rigdata){
                    if (i.getCommunity()){
                        communityRigData.add(i);
                    }
                }

                RigAdapter.OnDeleteClickedListener mListener =new RigAdapter.OnDeleteClickedListener() {
                    @Override
                    public void onItemClicked(Rig rig, int position) {
                        Query query= myRef.child("builds").orderByChild("name").equalTo(rig.getName());
                        query.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                for (DataSnapshot buildSnapshot: snapshot.getChildren()){
                                    buildSnapshot.getRef().removeValue();
                                    Handler handler = new Handler();
                                    Runnable runnable = new Runnable() {
                                        @Override
                                        public void run() {
                                            //Second fragment after 5 seconds appears
                                            NavHostFragment.findNavController(CommunityFragment.this).navigate(R.id.action_communityFragment_to_homeFragment);

                                        }
                                    };
                                    handler.postDelayed(runnable, 500);

                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {
                                Log.e("TAG", "onCancelled: "+error.toException() );
                            }
                        });
                    }
                };


                binding.rvCommunity.setLayoutManager(new LinearLayoutManager(getContext()));
                binding.rvCommunity.setAdapter(new RigAdapter(communityRigData,mListener));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
}