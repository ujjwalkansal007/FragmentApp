package com.example.fragmentassignment3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListFragment extends Fragment {
    ListView listView;
    String[] versions;

    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        listView = view.findViewById(R.id.listView);
        versions = getResources().getStringArray(R.array.versions);

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,versions);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentManager fm=getFragmentManager();
                DisplayFragment fragment = (DisplayFragment) fm.findFragmentById(R.id.fragment2);
                fragment.showVersion(position);
            }
        });
        return view;
    }
}