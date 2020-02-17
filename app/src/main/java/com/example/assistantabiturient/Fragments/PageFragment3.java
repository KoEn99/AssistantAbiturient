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

import com.example.assistantabiturient.Adapter.TpuRegisterAdapter;
import com.example.assistantabiturient.Adapter.TusurRegisterAdapter;
import com.example.assistantabiturient.Class.FacultiesTusur;
import com.example.assistantabiturient.R;

import java.util.ArrayList;
import java.util.List;

public class PageFragment3 extends Fragment {
    public static List<FacultiesTusur> facultiesTpu = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.page_tpu,
                container,
                false);
        RecyclerView recTpu = (RecyclerView)rootView.findViewById(R.id.recViewTpu);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recTpu.setLayoutManager(layoutManager);
        if (facultiesTpu.size() == 0) setInitialData();
        TpuRegisterAdapter tpuRegisterAdapter = new TpuRegisterAdapter(facultiesTpu);
        recTpu.setAdapter(tpuRegisterAdapter);
        return rootView;
    }
    private void setInitialData(){
        String[] nameFaculties = getResources().getStringArray(R.array.faculties_tpu);
        String[] linkFaculties = getResources().getStringArray(R.array.linksTpu);
        for (int i = 0; i < getResources().getInteger(R.integer.number_of_directions_TPU); i++) {
            facultiesTpu.add(new FacultiesTusur(nameFaculties[i],
                    linkFaculties[i],
                    false));
        }
    }

}
