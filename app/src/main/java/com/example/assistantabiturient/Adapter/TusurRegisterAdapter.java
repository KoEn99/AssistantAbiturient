package com.example.assistantabiturient.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assistantabiturient.Class.FacultiesTusur;
import com.example.assistantabiturient.Class.App;
import com.example.assistantabiturient.R;

import java.util.List;

public class TusurRegisterAdapter extends RecyclerView.Adapter<TusurRegisterAdapter.ViewHolder>{
    private static LayoutInflater inflater;
    private static Context context = App.getAppContext();

    public static List<FacultiesTusur> facultiesTusurList;
    public static Boolean[] checkBoxes = new Boolean[context.getResources().getInteger(R.integer.number_of_directions_TUSUR)];
    public TusurRegisterAdapter(List<FacultiesTusur> facultiesTusurList) {
        this.facultiesTusurList = facultiesTusurList;
        for (int i = 0; i < checkBoxes.length; i++){
            checkBoxes[i] = false;
        }

       // this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public TusurRegisterAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       // View view = inflater.from(parent.getContext()).inflate(R.layout.tusur_register_recycle, parent, false);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tusur_register_recycle, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final TusurRegisterAdapter.ViewHolder holder, final int position) {
   //     final FacultiesTusur facultiesTusur = facultiesTusurList.get(position);
        holder.checkBox.setText(facultiesTusurList.get(position).getNameFaculties());
        holder.checkBox.setChecked(checkBoxes[position]);
       holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(
                        v.getContext(),
                        "Clicked on Checkbox: " + facultiesTusurList.get(position).getNameFaculties() + " is "
                                + holder.checkBox.isChecked(), Toast.LENGTH_LONG).show();
                    checkBoxes[position] = !checkBoxes[position];
                    facultiesTusurList.get(position).setCheck(checkBoxes[position]);
            }
        });
    }

    @Override
    public int getItemCount() {
        return facultiesTusurList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        CheckBox checkBox;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBox = (CheckBox)itemView.findViewById(R.id.checkbox_tusur_register);
        }
    }
}
