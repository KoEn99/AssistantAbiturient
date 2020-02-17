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

import com.example.assistantabiturient.Adapter.TusurRegisterAdapter;
import com.example.assistantabiturient.Class.FacultiesTusur;
import com.example.assistantabiturient.R;

import java.util.ArrayList;
import java.util.List;

public class PageFragment extends Fragment {
    public static List<FacultiesTusur> facultiesTusursList = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.page_tusur,
                container,
                false);

        RecyclerView recyclerViewTusur = (RecyclerView)rootView.findViewById(R.id.recyclerViewTusur);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewTusur.setLayoutManager(layoutManager);
        if (facultiesTusursList.size() == 0) setInitialData();
        TusurRegisterAdapter tusurRegisterAdapter = new TusurRegisterAdapter( facultiesTusursList);
        recyclerViewTusur.setAdapter(tusurRegisterAdapter);
        return rootView;
    }
    private void setInitialData(){
        String[] nameFaculties = getResources().getStringArray(R.array.nameFaculties);
        String[] linkFaculties = getResources().getStringArray(R.array.linkFaculties);
            for (int i = 0; i < getResources().getInteger(R.integer.number_of_directions_TUSUR); i++) {
                facultiesTusursList.add(new FacultiesTusur(nameFaculties[i],
                        linkFaculties[i],
                        false));
            }
    }
}
