package com.hemebiotech.analytics.old;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

class Application {
    public static void main(String[] args) throws IOException {


        TreeMap<String, Integer> symptome = new TreeMap<>();

        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\letha\\IdeaProjects\\della-negra-mathieu-debug-Java\\Project02Eclipse\\src\\com\\hemebiotech\\analytics\\ressource\\symptoms.txt"));
        String line = reader.readLine();
        FileWriter fileWriter = new FileWriter("C:\\Users\\letha\\IdeaProjects\\della-negra-mathieu-debug-Java\\Project02Eclipse\\src\\com\\hemebiotech\\analytics\\ressource\\result.out");
        BufferedWriter writer = new BufferedWriter(fileWriter);

        try {
            while (line != null) {
                System.out.println("Symptom from file : " + line);
                symptome.putIfAbsent(line, 0);
                symptome.put(line, symptome.get(line) + 1);

                line = reader.readLine();
            }
            reader.close();

        }catch (Exception e){
            e.printStackTrace();
        }


        for (Map.Entry<String, Integer> entry : symptome.entrySet()) {

            writer.write(entry.getKey() + " : " + entry.getValue());
            writer.newLine();

        }

        writer.close();

    }

}
