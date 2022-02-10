package com.biotech.process.model;

import java.util.*;

public class ListeSymptome {
    private Map<String, Integer> map = new TreeMap<>();

    public void ajouter(String symptome){
        int count = map.getOrDefault(symptome, 0);
        map.put(symptome, ++count);
    }

    public String toString(){
        // sort : List<Character> sortedKeys = chars.keySet().stream().sorted().toList();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            sb.append(entry.getKey() + " " + entry.getValue() + "\n");
        }
        return sb.toString();
    }
}
