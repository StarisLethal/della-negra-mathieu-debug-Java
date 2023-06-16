package com.hemebiotech.analytics;

import java.util.TreeMap;

public class AnalyticsCounter implements ISymptomsReader, ISymptomsWriter {

    String symptomsPath;
    String resultPath;


    TreeMap<String, Integer> results = new TreeMap<>();

    public AnalyticsCounter(String symptomsPath, String resultPath) {
        this.symptomsPath = symptomsPath;
        this.resultPath = resultPath;

    }

    // This class read a file line by line and then put it in a TreeMap
    @Override
    public TreeMap<String, Integer> GetSymptoms() {

        ReadSymptomsDataFromFile read = new ReadSymptomsDataFromFile(symptomsPath);

        results = read.GetSymptoms();

        return results;
    }

    // This class write info in an outfile from a treemap
    @Override
    public TreeMap<String, Integer> WriteSymptoms() {


        WriteSymptomsDataToFile write = new WriteSymptomsDataToFile(results, resultPath);
        write.WriteSymptoms();

        return null;
    }
}

