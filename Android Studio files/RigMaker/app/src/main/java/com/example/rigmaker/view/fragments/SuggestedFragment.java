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
import com.example.rigmaker.databinding.FragmentSuggestedBinding;
import com.example.rigmaker.model.Rig;
import com.example.rigmaker.view.adapters.RigAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
//shows the list of rigs in the suggested category
public class SuggestedFragment extends Fragment {

    private FragmentSuggestedBinding binding;
    //gets the firebase instance
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("rig_data");
    //list to store rigdata after recieving it from firebase
    ArrayList<Rig> rigdata = new ArrayList<>();
    //filter the rig data to store the list of suggested rigs
    ArrayList<Rig> suggestedRigData = new ArrayList<>();

    public SuggestedFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSuggestedBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        myRef.child("builds").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //add all elements to the rigData array.
                for (DataSnapshot valueRes : snapshot.getChildren()){
                    Rig rig = valueRes.getValue(Rig.class);
                    rigdata.add(rig);
                }
                //check for suggested data among the rig data and add it to suggested rig Data
                for (Rig i : rigdata){
                    if (i.getSuggested()){
                        suggestedRigData.add(i);
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
                                           NavHostFragment.findNavController(SuggestedFragment.this).navigate(R.id.action_suggestedFragment_to_homeFragment);

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

                binding.rvSuggested.setLayoutManager(new LinearLayoutManager(getContext()));
                binding.rvSuggested.setAdapter(new RigAdapter(suggestedRigData,mListener));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}