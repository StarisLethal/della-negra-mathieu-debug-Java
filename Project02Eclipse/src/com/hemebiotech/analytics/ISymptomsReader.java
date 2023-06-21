package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public interface ISymptomsReader {


    List<String> GetSymptoms();

    Map<String, Integer> CountSymptoms();

    Map<String, Integer> SortSymptoms();

}


