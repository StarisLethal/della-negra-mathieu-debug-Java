package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

// This class read a file line by line and then put it in a TreeMap
public class ReadSymptomsDataFromFile implements ISymptomsReader {

    private String path = "Project02Eclipse\\src\\com\\hemebiotech\\analytics\\ressource\\";
    private String filePath;

    public ReadSymptomsDataFromFile(String filePath) {
        this.filePath = filePath;
    }


    public TreeMap<String, Integer> GetSymptoms() {

        String completePath = path + filePath;
        TreeMap<String, Integer> result = new TreeMap<>();

        if (filePath != null) {
            try {

                BufferedReader reader = new BufferedReader(new FileReader(completePath));
                String line = reader.readLine();

                // read and add line in TreeMap

                while (line != null) {
                    System.out.println("Symptom from file : " + line);
                    result.putIfAbsent(line, 0);
                    result.put(line, result.get(line) + 1);

                    line = reader.readLine();
                }
                reader.close();
            } catch (IOException e) {
                System.err.println("Problem with the Input File");
                e.printStackTrace();
            } catch (Exception e) {
                System.err.println("Problem to read the Input File");
                e.printStackTrace();
            }

        }

        return result;
    }
}
