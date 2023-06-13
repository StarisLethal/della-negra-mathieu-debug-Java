package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class WriteSymptomsDataToFile {

    TreeMap<String, Integer> symptoms;

    public WriteSymptomsDataToFile(TreeMap<String, Integer> symptoms) throws IOException {


        FileWriter fileWriter = new FileWriter(".\\Project02Eclipse\\src\\com\\hemebiotech\\analytics\\ressource\\result.out");
        BufferedWriter writer = new BufferedWriter(fileWriter);

        try {

            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {

                writer.write(entry.getKey() + " : " + entry.getValue());
                writer.newLine();

            }

            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setSymptoms(TreeMap<String, Integer> symptoms) {
        this.symptoms = symptoms;
    }
}
