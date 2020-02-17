package com.example.assistantabiturient.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.assistantabiturient.Adapter.TguRegisterAdapter;
import com.example.assistantabiturient.Adapter.TpuRegisterAdapter;
import com.example.assistantabiturient.Adapter.TusurRegisterAdapter;
import com.example.assistantabiturient.LoginActivity;
import com.example.assistantabiturient.MainActivity;
import com.example.assistantabiturient.R;
import com.example.assistantabiturient.Singleton;

public class PageFragmentExit extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.page_exitregister,
                container,
                false);
        Button buttonExit = (Button)rootView.findViewById(R.id.buttonExitRegister);
        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Singleton singleton = Singleton.getInstance();
                singleton.list=TusurRegisterAdapter.facultiesTusurList;
                singleton.list2=TguRegisterAdapter.facultiesTusurList;
                singleton.list3= TpuRegisterAdapter.facultiesTusurList;
                singleton.checkBoxes[0] = TusurRegisterAdapter.checkBoxes;
                singleton.checkBoxes[1] = TguRegisterAdapter.checkBoxes;
                singleton.checkBoxes[2] = TpuRegisterAdapter.checkBoxes;
                singleton.FIO = PageFragment4.fio.getText().toString();
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        return rootView;
    }
}
