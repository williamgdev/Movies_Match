package com.mac.fireflies.wgt.moviematch;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mac.fireflies.wgt.moviematch.model.DatabaseUserUtil;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecentlyWatched extends Fragment {
    private RecyclerView recyclerView;
    //private Recently_Adapter recently_adapter;


    public RecentlyWatched() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_recently_watched, container, false);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (getContext(), android.R.layout.simple_list_item_1, new ArrayList<String>());
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://fblogin-8f810.firebaseio.com/");
        DatabaseUserUtil.getConnections(databaseReference, FirebaseAuth.getInstance().getCurrentUser(), adapter);
        //ListView listView = (ListView) v.findViewById(R.id.listViewRecent);
        //listView.setAdapter(adapter);
        List<String> connection = new ArrayList<>();
        connection.add("Pepe Mere");
        connection.add("https://developer.android.com/design/material/images/list_mail.png");
        connection.add("Pepe Mere5");
        connection.add("https://developer.android.com/design/material/images/list_mail.png");
        connection.add("Pepe Mere4");
        connection.add("https://developer.android.com/design/material/images/list_mail.png");
        connection.add("Pepe Mere3");
        connection.add("https://developer.android.com/design/material/images/list_mail.png");
        connection.add("Pepe Mere2");

        recyclerView=(RecyclerView)v.findViewById(R.id.recyclerView);
        //Recently_Adapter recently_adapter = new Recently_Adapter(getContext(), connection);
        RAdapter rAdapter = new RAdapter(getContext(), connection);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(rAdapter);



        return v;
    }

}
