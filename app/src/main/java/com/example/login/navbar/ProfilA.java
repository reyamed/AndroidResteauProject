package com.example.login.navbar;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.login.R;

import java.util.ArrayList;


public class ProfilA extends Fragment {

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

    public ProfilA() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static ProfilA newInstance(String param1, String param2) {
        ProfilA fragment = new ProfilA();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profil_a, container, false);
        recyclerViewP = view.findViewById(R.id.rvOrders);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewP.setLayoutManager(manager);
        restaurants = new ArrayList<>();

        RestaurantModel restaurant1 = new RestaurantModel(R.drawable.r1,"Frerot","Bouvlavrd m6 , 106 , Oujda" , "★★★☆☆");
        RestaurantModel restaurant2 = new RestaurantModel(R.drawable.r2,"Bigup","Bouvlavrd lala salma , 56 , Oujda" , "★★★☆☆");
        RestaurantModel restaurant3 = new RestaurantModel(R.drawable.r3,"EL FIl","Bouvlavrd tarik ibnou ziad , 556 , Oujda" , "★★★☆☆");
        RestaurantModel restaurant4 = new RestaurantModel(R.drawable.r4,"Mistral","Bouvlavrd HASSAN II , 45 , Oujda" , "★★★☆☆");

        restaurants.add(restaurant1);
        restaurants.add(restaurant2);
        restaurants.add(restaurant3);
        restaurants.add(restaurant4);

        recyclerViewP.setAdapter(new RestaurantAdapter(getContext(), restaurants));
        return view;
    }
}