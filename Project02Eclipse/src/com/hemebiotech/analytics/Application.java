package com.hemebiotech.analytics;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {

        AnalyticsCounter ac = new AnalyticsCounter("symptoms.txt", "result.out");

        ac.GetSymptoms();

        ac.WriteSymptoms();

    }

}
