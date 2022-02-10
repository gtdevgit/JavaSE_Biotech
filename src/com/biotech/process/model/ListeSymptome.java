package com.biotech.process.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListeSymptome {
    private Map<String, Integer> map = new HashMap<>();

    public void ajouter(String symptome){
        try {
            map.put(symptome, map.get(symptome) + 1);
        } catch (NullPointerException e){
            map.put(symptome, 1);
        }
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            sb.append(entry.getKey() + " " + entry.getValue() + "\n");
        }
        return sb.toString();
    }
}
