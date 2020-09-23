package com.example.fragmentassignment3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayFragment extends Fragment {
    TextView tv;
    ImageView iv;
    Integer[] picArray;
   public DisplayFragment() {
        // Required empty public constructor
    }

  @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_display, container, false);
        tv = view.findViewById(R.id.tv);
        iv = view.findViewById(R.id.imageView);

        picArray= new Integer[]{R.drawable.jellybean, R.drawable.kitkat, R.drawable.lolipop, R.drawable.marshmallow,
                R.drawable.nougat,R.drawable.oreo,R.drawable.pie,R.drawable.q};

        return view;
    }

    public void showVersion(int pos){
        FragmentManager fm =getFragmentManager();
        ListFragment listFragment = (ListFragment) fm.findFragmentById(R.id.fragment1);

       tv.setText(listFragment.versions[pos]);
       iv.setImageResource(picArray[pos]);
    }
}