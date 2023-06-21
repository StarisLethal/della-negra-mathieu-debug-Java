package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;


/**
 * @AnalyticsCounter Implements interface and call every methode
 */
public class AnalyticsCounter implements ISymptomsReader, ISymptomsWriter {


    ISymptomsReader reader;
    ISymptomsWriter writer;


    public AnalyticsCounter(ISymptomsReader readP, ISymptomsWriter writeP) {
        this.reader = readP;
        this.writer = writeP;

    }

    // This class read a file line by line and then put it in a TreeMap
    @Override
    public List<String> GetSymptoms() {

        return reader.GetSymptoms();

    }

    @Override
    public Map<String, Integer> CountSymptoms() {

        return reader.CountSymptoms();
    }

    @Override
    public Map<String, Integer> SortSymptoms() {
        return reader.SortSymptoms();
    }


    @Override

    public TreeMap<String, Integer> WriteSymptoms(TreeMap<String, Integer> symptoms) {

        return writer.WriteSymptoms(symptoms);


    }

}


