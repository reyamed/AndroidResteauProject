package com.example.login.navbar;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.example.login.R;
import com.example.login.RestauProfil;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;





import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ReachercheRes#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ReachercheRes extends Fragment implements RecyclerViewInterface {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    public RecyclerView recyclerViewP;
    public RestaurantAdapter restaurantAdapter;
    public ArrayList<RestaurantModel> restaurants;
    DatabaseReference database ;


    public ReachercheRes() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ReachercheRes.
     */
    // TODO: Rename and change types and number of parameters
    public static ReachercheRes newInstance(String param1, String param2) {
        ReachercheRes fragment = new ReachercheRes();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_reacherche_res, container, false);
        recyclerViewP=view.findViewById(R.id.rvRestaurants);
        database = FirebaseDatabase.getInstance().getReference("Restaurants");
        recyclerViewP.setHasFixedSize(true);
        recyclerViewP.setLayoutManager(new LinearLayoutManager(getContext()));

        restaurants = new ArrayList<>();
        restaurantAdapter = new RestaurantAdapter(getContext(),restaurants ,this);
        recyclerViewP.setAdapter(restaurantAdapter);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                   RestaurantModel restaurant = dataSnapshot.getValue(RestaurantModel.class) ;
                   restaurants.add(restaurant);
                }
                restaurantAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return view;
    }

    @Override
    public void onItemClick(int position) {
        Intent i = new Intent(getContext(), RestauProfil.class);
        i.putExtra("restaurantId",position+1);
        startActivity(i);
    }

}