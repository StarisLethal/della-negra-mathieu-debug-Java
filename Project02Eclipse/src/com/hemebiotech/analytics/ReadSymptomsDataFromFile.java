package com.hemebiotech.analytics;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


// This class read a file line by line and then put it in a TreeMap
public class ReadSymptomsDataFromFile extends TreeMap<String, Integer> implements ISymptomsReader {

    List<String> result = new ArrayList<>() {
    };
    Map<String, Integer> symptoms = new HashMap<>();

    TreeMap<String, Integer> symptomsSorted;


    private String path = "Project02Eclipse\\src\\com\\hemebiotech\\analytics\\ressource\\";
    private String filePath;

    public ReadSymptomsDataFromFile(String filePath) {
        this.filePath = filePath;
    }


    /**
     * @GetSympoms Read a files and generate an List from it
     */
    public List<String> GetSymptoms() {

        String completePath = path + filePath;

        if (filePath != null) {
            try {

                BufferedReader reader = new BufferedReader(new FileReader(completePath));
                String line = reader.readLine();


                while (line != null) {
                    System.out.println("Symptom from file : " + line);
                    result.add(line);

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

    /**
     * @CountSymptoms Put each occurrence of the previous list in a Map and count it
     */

    public Map<String, Integer> CountSymptoms() {

        for (String line : result) {
            symptoms.putIfAbsent(line, 0);
            symptoms.put(line, symptoms.get(line) + 1);
        }

        return symptoms;
    }

    /**
     * @SortSymptoms Transfer the previous Map in a TreeMap for sort it
     */

    public TreeMap<String, Integer> SortSymptoms() {

        symptomsSorted = new TreeMap<>(symptoms);

        return null;
    }


}
