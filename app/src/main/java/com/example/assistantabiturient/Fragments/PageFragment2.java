package com.example.assistantabiturient.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assistantabiturient.Adapter.TguRegisterAdapter;
import com.example.assistantabiturient.Adapter.TusurRegisterAdapter;
import com.example.assistantabiturient.Class.FacultiesTusur;
import com.example.assistantabiturient.R;

import java.util.ArrayList;
import java.util.List;

public class PageFragment2 extends Fragment {
    private static List<FacultiesTusur> facultiesTGU = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.page_tgu,
                container,
                false);
        RecyclerView recTgu = (RecyclerView)rootView.findViewById(R.id.recyclerViewTGU);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recTgu.setLayoutManager(layoutManager);
        if (facultiesTGU.size() == 0) setInitialData();
        TguRegisterAdapter tguRegisterAdapter = new TguRegisterAdapter(facultiesTGU);
        recTgu.setAdapter(tguRegisterAdapter);
        return rootView;
    }
    private void setInitialData(){
        String[] nameFaculties = getResources().getStringArray(R.array.faculties_tgu);
        String[] linkFaculties = getResources().getStringArray(R.array.linksTgu);
        for (int i = 0; i < getResources().getInteger(R.integer.number_of_directions_TGU); i++) {
            facultiesTGU.add(new FacultiesTusur(nameFaculties[i],
                    linkFaculties[i],
                    false));
        }
    }
}
