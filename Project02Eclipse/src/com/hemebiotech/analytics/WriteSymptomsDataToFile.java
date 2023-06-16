package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

// This class write info in an outfile from a treemap in parameter
public class WriteSymptomsDataToFile implements ISymptomsWriter {
    String path = "Project02Eclipse\\src\\com\\hemebiotech\\analytics\\ressource\\";
    String filePath;
    TreeMap<String, Integer> symptoms;

    public WriteSymptomsDataToFile(TreeMap<String, Integer> symptoms, String file) {
        this.symptoms = symptoms;
        this.filePath = file;
    }

    @Override
    public TreeMap<String, Integer> WriteSymptoms() {


        String completePath = path + filePath;

        try {

            FileWriter fileWriter = new FileWriter(completePath);
            BufferedWriter writer = new BufferedWriter(fileWriter);

            // Write the TreeMap in an Output File

            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {

                writer.write(entry.getKey() + " : " + entry.getValue());
                writer.newLine();

            }

            writer.close();

        } catch (IOException e) {
            System.err.println("Problem with the Output filePath");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Problem to write");
            e.printStackTrace();

        }

        return symptoms;
    }
}