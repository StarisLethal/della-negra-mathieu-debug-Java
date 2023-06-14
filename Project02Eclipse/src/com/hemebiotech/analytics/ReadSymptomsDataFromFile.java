package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.TreeMap;

public class ReadSymptomsDataFromFile implements ISymptomsReader {

    private String filePath;

    public ReadSymptomsDataFromFile(String filePath) {
        this.filePath = filePath;
    }


    public TreeMap<String, Integer> GetSymptoms() {

        TreeMap<String, Integer> result = new TreeMap<>();

        if (filePath != null) {
            try {

                BufferedReader reader = new BufferedReader(new FileReader(filePath));
                String line = reader.readLine();

                while (line != null) {
                    System.out.println("Symptom from file : " + line);
                    result.putIfAbsent(line, 0);
                    result.put(line, result.get(line) + 1);

                    line = reader.readLine();
                }
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return result;
    }
}
