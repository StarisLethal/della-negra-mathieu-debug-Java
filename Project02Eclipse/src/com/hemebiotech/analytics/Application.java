package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.TreeMap;

public class Application {

    public static void main(String[] args) throws IOException {

        ReadSymptomsDataFromFile read = new ReadSymptomsDataFromFile("symptoms.txt");

        TreeMap<String, Integer> symptoms = new TreeMap<>(read.GetSymptoms());

        WriteSymptomsDataToFile write = new WriteSymptomsDataToFile(symptoms, "result.out");

        write.WriteSymptoms();
    }

}
