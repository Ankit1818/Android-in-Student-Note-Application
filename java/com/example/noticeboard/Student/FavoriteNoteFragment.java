package com.example.noticeboard.Student;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.noticeboard.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoriteNoteFragment extends Fragment {
View view;
SessionManagementStud sMStud;
    public FavoriteNoteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_favorite_note, container, false);




        return view;
    }

}
