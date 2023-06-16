package com.hemebiotech.analytics;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter implements ISymptomsReader, ISymptomsWriter {
    String path = "Project02Eclipse\\src\\com\\hemebiotech\\analytics\\ressource\\";
    String symptomsPath;
    String resultPath;
    TreeMap<String, Integer> symptoms = new TreeMap<>();
    TreeMap<String, Integer> results = new TreeMap<>();

    public AnalyticsCounter(String symptomsPath, String resultPath) {
        this.symptomsPath = symptomsPath;
        this.resultPath = resultPath;
    }


    // This method read a file line by line and then put it in a TreeMap
    @Override
    public TreeMap<String, Integer> GetSymptoms() {

        String completeSymptomsPath = path + symptomsPath;

        if (symptomsPath != null) {
            try {

                BufferedReader reader = new BufferedReader(new FileReader(completeSymptomsPath));
                String line = reader.readLine();

                // read and add line in TreeMap

                while (line != null) {
                    System.out.println("Symptom from file : " + line);
                    results.putIfAbsent(line, 0);
                    results.put(line, results.get(line) + 1);

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
        return results;
    }

    // This class write info in an outfile from a treemap
    @Override
    public TreeMap<String, Integer> WriteSymptoms() {

        String completeResultPath = path + resultPath;

        try {

            FileWriter fileWriter = new FileWriter(completeResultPath);
            BufferedWriter writer = new BufferedWriter(fileWriter);

            // Write the TreeMap in an Output File

            for (Map.Entry<String, Integer> entry : results.entrySet()) {

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


        return null;
    }
}






