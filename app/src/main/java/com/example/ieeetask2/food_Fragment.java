package com.example.ieeetask2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link food_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class food_Fragment extends Fragment {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public food_Fragment() {

        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment food_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static food_Fragment newInstance(String param1, String param2) {
        food_Fragment fragment = new food_Fragment();
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
       View V= inflater.inflate(R.layout.fragment_food_, container, false);

        RecyclerView recyclerView =V.findViewById(R.id.rs);
        ArrayList<food> cats =new ArrayList<>();


        cats.add(new food(R.drawable.meal,"Meal"));
        cats.add(new food(R.drawable.pizza,"Pizza"));
        cats.add(new food(R.drawable.sand,"Sandwitch"));
        cats.add(new food(R.drawable.crepe,"Crepe"));
        RecyclerViewAdptar adptar =new RecyclerViewAdptar(cats);

        RecyclerView.LayoutManager lm;
        lm = new GridLayoutManager(getActivity(),2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(lm);
        recyclerView.setAdapter(adptar);

        return V;

    }
}