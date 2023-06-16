package com.hemebiotech.analytics;

import java.util.TreeMap;

public class AnalyticsCounter implements ISymptomsReader, ISymptomsWriter {

    ISymptomsReader reader;
    ISymptomsWriter writer;


    public AnalyticsCounter(ISymptomsReader readP, ISymptomsWriter writeP) {
        this.reader = readP;
        this.writer = writeP;

    }

    // This class read a file line by line and then put it in a TreeMap
    @Override
    public TreeMap<String, Integer> GetSymptoms() {

        return reader.GetSymptoms();

    }

    // This class write info in an outfile from a treemap
    @Override
    public TreeMap<String, Integer> WriteSymptoms() {

        writer.WriteSymptoms();

        return null;
    }
}

