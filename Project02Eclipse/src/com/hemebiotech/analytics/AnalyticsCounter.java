package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;


// AnalyticsCounter Implements and instantiate interface , call every method

public class AnalyticsCounter {


    ISymptomsReader reader;
    ISymptomsWriter writer;

    // Instantiate Interface

    public AnalyticsCounter(ISymptomsReader readP, ISymptomsWriter writeP) {
        this.reader = readP;
        this.writer = writeP;

    }

    public List<String> GetSymptoms() {

        return reader.GetSymptoms();

    }


    public Map<String, Integer> CountSymptoms() {

        return reader.CountSymptoms();
    }


    public Map<String, Integer> SortSymptoms() {

        return reader.SortSymptoms();
    }


    public TreeMap<String, Integer> WriteSymptoms(TreeMap<String, Integer> symptoms) {

        return writer.WriteSymptoms(symptoms);


    }

}


