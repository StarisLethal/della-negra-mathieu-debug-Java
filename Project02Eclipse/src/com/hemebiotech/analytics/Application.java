package com.hemebiotech.analytics;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Application {
    public static void main(String[] args) throws IOException {

    SymptomsReader reader = new SymptomsReader();
    reader();

    }

    public static class SymptomsReader {
        public static TreeMap<String, Integer> symptome;

        public static TreeMap<String, Integer> SymptomsReader() throws IOException {


           TreeMap<String, Integer> symptome = new TreeMap<>();

            BufferedReader reader = new BufferedReader(new FileReader(".\\Project02Eclipse\\ressource\\symptoms.txt"));
            String line = reader.readLine();

            try {
                while (line != null) {
                    System.out.println("Symptom from file : " + line);
                    symptome.putIfAbsent(line, 0);
                    symptome.put(line, symptome.get(line) + 1);

                    line = reader.readLine();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        return(symptome);
        }
    }

    public static class SymptomsWriter {
        public SymptomsWriter() throws IOException {

            TreeMap<String, Integer> symptome =  SymptomsReader.symptome;
            FileWriter fileWriter = new FileWriter(".\\ressource\\result.out");
            BufferedWriter writer = new BufferedWriter(fileWriter);

            try {

                for (Map.Entry<String, Integer> entry : symptome.entrySet()) {

                    writer.write(entry.getKey() + " : " + entry.getValue());
                    writer.newLine();

                }

                writer.close();

            } catch (Exception e) {
                e.printStackTrace();
            }



        }
    }
}

