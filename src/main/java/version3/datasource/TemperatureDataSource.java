package version3.datasource;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TemperatureDataSource {
    private String fileName;

    public TemperatureDataSource(String fileName) {
        this.fileName = fileName;
    }

    public List<Double> readTemperatures() {
        List<Double> temps = new ArrayList<>();
        try (InputStream in = getClass().getClassLoader().getResourceAsStream(fileName);
             BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {

            if (in == null) {
                System.out.println("Could not find file in the resources folder: " + fileName);
                return temps;
            }

            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    temps.add(Double.parseDouble(line.trim()));
                } catch (NumberFormatException e) {
                    System.out.println("Skipping invalid line: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Failed to read file: " + e.getMessage());
        }
        return temps;
    }
}