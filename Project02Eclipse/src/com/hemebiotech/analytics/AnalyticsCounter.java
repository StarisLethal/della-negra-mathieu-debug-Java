package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.TreeMap;

public class AnalyticsCounter {


    public AnalyticsCounter() throws IOException {

        ReadSymptomsDataFromFile read = new ReadSymptomsDataFromFile();

        TreeMap<String, Integer> symptoms = read.symptoms;

        WriteSymptomsDataToFile write = new WriteSymptomsDataToFile(symptoms);

    }
}
