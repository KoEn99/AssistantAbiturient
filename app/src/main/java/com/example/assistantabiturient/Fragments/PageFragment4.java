package com.example.assistantabiturient.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.assistantabiturient.R;
import com.example.assistantabiturient.Singleton;

public class PageFragment4 extends Fragment {
    public static EditText fio;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.pager_fio,
                container,
                false);
        fio = (EditText)rootView.findViewById(R.id.editFIO);
        return rootView;
    }
}
