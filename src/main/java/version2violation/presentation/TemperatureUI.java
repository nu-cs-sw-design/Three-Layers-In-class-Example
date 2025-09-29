package version2violation.presentation;

import version2violation.datasource.TemperatureDataSource;
import version2violation.domain.TemperatureEngine;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TemperatureUI extends JFrame  {
    private JTextField inputField = new JTextField(10);
    private JButton cToFButton = new JButton("C → F");
    private JButton fToCButton = new JButton("F → C");
    private JLabel resultLabel = new JLabel("Result: ");
    private JButton loadButton = new JButton("Load Data");
    private JTextArea fileDataResults = new JTextArea(5, 20);


    private TemperatureEngine engine;
    private TemperatureDataSource dataSource;

    public TemperatureUI(TemperatureEngine engine, TemperatureDataSource dataSource) {
        this.engine = engine;
        this.dataSource = dataSource;
        setupUI();
    }

    private void setupUI(){
        setTitle("Temperature Converter VERSION 2");
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
        loadButton.addActionListener(e -> loadTempsFromFile());

        setVisible(true);
    }

    private String getInput() {
        return inputField.getText();
    }

    public void setResult(String result) {
        resultLabel.setText("Result: " + result);
    }

    private void convertCToF() {
        try {
            double celsius = Double.parseDouble(getInput());
            engine.celsiusToFahrenheit(celsius);
        } catch (NumberFormatException e) {
            setResult("Invalid input");
        }
    }

    private void convertFToC() {
        try {
            double fahrenheit = Double.parseDouble(getInput());
            engine.fahrenheitToCelsius(fahrenheit);
        } catch (NumberFormatException e) {
            setResult("Invalid input");
        }
    }

    private void loadTempsFromFile() {
        List<Double> temps = dataSource.readTemperatures();
        StringBuilder resultBuilder = new StringBuilder();
        for (double celsius : temps) {
            double fahrenheit = engine.celsiusToFahrenheit(celsius);
            resultBuilder.append(String.format("%.2f °C = %.2f °F\n", celsius, fahrenheit));
        }
        fileDataResults.setText(resultBuilder.toString());
    }
}
