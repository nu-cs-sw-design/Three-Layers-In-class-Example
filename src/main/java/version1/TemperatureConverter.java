package version1;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TemperatureConverter extends JFrame {
    private JTextField inputField = new JTextField(10);
    private JButton cToFButton = new JButton("C → F");
    private JButton fToCButton = new JButton("F → C");
    private JLabel resultLabel = new JLabel("Result: ");
    private JButton loadButton = new JButton("Load Data");
    private JTextArea fileDataResults = new JTextArea(5, 20);

    public TemperatureConverter(String fileName) {
        setTitle("Temperature Converter VERSION 1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLayout(new FlowLayout());

        add(new JLabel("Enter value:"));
        add(inputField);
        add(cToFButton);
        add(fToCButton);
        add(resultLabel);
        add(loadButton);
        add(new JScrollPane(fileDataResults));

        cToFButton.addActionListener(e -> convertCToF());
        fToCButton.addActionListener(e -> convertFToC());
        loadButton.addActionListener(e -> loadTempsFromFile(fileName));

        setVisible(true);
    }

    private String getInput() {
        return inputField.getText();
    }

    private void setResult(String result) {
        resultLabel.setText("Result: " + result);
    }

    private void convertCToF() {
        try {
            double celsius = Double.parseDouble(getInput());
            double fahrenheit = celsiusToFahrenheit(celsius);
            setResult(String.format("%.2f °F", fahrenheit));
        } catch (NumberFormatException e) {
            setResult("Invalid input");
        }
    }

    private void convertFToC() {
        try {
            double fahrenheit = Double.parseDouble(getInput());
            double celsius = fahrenheitToCelsius(fahrenheit);
            setResult(String.format("%.2f °C", celsius));
        } catch (NumberFormatException e) {
            setResult("Invalid input");
        }
    }

    private double celsiusToFahrenheit(double celsius) {
        return (celsius * 9.0 / 5.0) + 32;
    }

    private double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5.0 / 9.0;
    }

    private void loadTempsFromFile(String fileName) {
        List<Double> temps = readTemperatures(fileName);
        StringBuilder resultBuilder = new StringBuilder();
        for (double celsius : temps) {
            double fahrenheit = celsiusToFahrenheit(celsius);
            resultBuilder.append(String.format("%.2f °C = %.2f °F\n", celsius, fahrenheit));
        }
        fileDataResults.setText(resultBuilder.toString());
    }
    private List<Double> readTemperatures(String fileName) {
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
