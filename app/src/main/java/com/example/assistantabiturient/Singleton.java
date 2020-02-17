package com.example.assistantabiturient;

import com.example.assistantabiturient.Class.FacultiesTusur;

import java.util.ArrayList;
import java.util.List;

public class Singleton {
    public List<FacultiesTusur> list = new ArrayList<>();
    public List<FacultiesTusur> list2 = new ArrayList<>();
    public List<FacultiesTusur> list3 = new ArrayList<>();
    public Boolean[][] checkBoxes = new Boolean[3][34];
    public String FIO = "";
        private static class SingletonHolder{
            private static final Singleton instance = new Singleton();

        }
        public static Singleton getInstance(){
           return SingletonHolder.instance;
    }
}
