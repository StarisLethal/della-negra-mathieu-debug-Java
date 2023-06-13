package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

public class ReadSymptomsDataFromFile {

    String resourceFiles = "symptoms.txt" ;
    TreeMap<String, Integer> symptoms = new TreeMap<>();

    public ReadSymptomsDataFromFile() throws IOException {

        String path = ".\\Project02Eclipse\\src\\com\\hemebiotech\\analytics\\ressource\\" ;
        String completePath = path + resourceFiles;


        BufferedReader reader = new BufferedReader(new FileReader(completePath));
        String line = reader.readLine();

        try {
            while (line != null) {
                System.out.println("Symptom from file : " + line);
                symptoms.putIfAbsent(line, 0);
                symptoms.put(line, symptoms.get(line) + 1);

                line = reader.readLine();
            }
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public TreeMap<String, Integer> getSymptoms() {
        return symptoms;
    }
}



