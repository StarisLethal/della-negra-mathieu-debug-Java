package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.TreeMap;

public interface ISymptomsWriter {

    TreeMap<String, Integer> WriteSymptoms() throws IOException;

}


