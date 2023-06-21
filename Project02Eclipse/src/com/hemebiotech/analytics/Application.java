package com.hemebiotech.analytics;

import java.io.IOException;

public class Application {


    public static void main(String[] args) throws IOException {

        ReadSymptomsDataFromFile read = new ReadSymptomsDataFromFile("symptoms.txt");


        WriteSymptomsDataToFile write = new WriteSymptomsDataToFile("result.out");


        AnalyticsCounter ac = new AnalyticsCounter(read, write);

        ac.GetSymptoms();

        ac.CountSymptoms();

        ac.SortSymptoms();

        ac.WriteSymptoms(read.symptomsSorted);

    }

}
