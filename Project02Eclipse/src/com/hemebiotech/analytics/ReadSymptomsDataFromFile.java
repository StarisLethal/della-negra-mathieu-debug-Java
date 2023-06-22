package com.hemebiotech.analytics;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


// This class read a file line by line and then put it in a TreeMap
public class ReadSymptomsDataFromFile extends TreeMap<String, Integer> implements ISymptomsReader {

    private final String path = "Project02Eclipse\\src\\com\\hemebiotech\\analytics\\ressource\\";
    Map<String, Integer> symptoms = new HashMap<>();
    TreeMap<String, Integer> symptomsSorted;
    private final String filePath;
    List<String> result = new ArrayList<>();

    public ReadSymptomsDataFromFile(String filePath) {
        this.filePath = filePath;
    }


    /**
     * GetSymptoms Read a files and generate a List from it
     */

    public List<String> GetSymptoms() {

        String completePath = path + filePath;

        if (filePath != null) {
            try {

                // Instantiate Reader and declare variable for the next line

                BufferedReader reader = new BufferedReader(new FileReader(completePath));
                String line = reader.readLine();

                // Read each line add it to list and print it in console

                while (line != null) {
                    System.out.println("Symptom from file : " + line);
                    result.add(line);

                    line = reader.readLine();
                }
                reader.close();

                // Treat Exception

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


    /**
     * CountSymptoms Put each occurrence of the previous list in a Map and count it
     */


    public Map<String, Integer> CountSymptoms() {

        for (String line : result) {
            symptoms.putIfAbsent(line, 0);
            symptoms.put(line, symptoms.get(line) + 1);
        }

        return symptoms;
    }


    /**
     * SortSymptoms Transfer the previous Map in a TreeMap for sort it
     */

    public TreeMap<String, Integer> SortSymptoms() {

        symptomsSorted = new TreeMap<>(symptoms);

        return null;
    }


}
