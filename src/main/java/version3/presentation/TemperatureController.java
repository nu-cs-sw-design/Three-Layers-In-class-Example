package version3.presentation;

import version3.datasource.TemperatureDataSource;
import version3.domain.TemperatureModel;
import java.util.List;

public class TemperatureController {
    private TemperatureModel model;
    private TemperatureView view;
    private TemperatureDataSource dataSource;

    public TemperatureController(TemperatureModel model, TemperatureView view, TemperatureDataSource dataSource) {
        this.model = model;
        this.view = view;
        this.dataSource = dataSource;

        view.cToFButton.addActionListener(e -> convertCToF());
        view.fToCButton.addActionListener(e -> convertFToC());
        view.loadButton.addActionListener(e -> loadTempsFromFile());
    }

    private void convertCToF() {
        try {
            double celsius = Double.parseDouble(view.getInput());
            double fahrenheit = model.celsiusToFahrenheit(celsius);
            view.setResult(String.format("%.2f °F", fahrenheit));
        } catch (NumberFormatException e) {
            view.setResult("Invalid input");
        }
    }

    private void convertFToC() {
        try {
            double fahrenheit = Double.parseDouble(view.getInput());
            double celsius = model.fahrenheitToCelsius(fahrenheit);
            view.setResult(String.format("%.2f °C", celsius));
        } catch (NumberFormatException e) {
            view.setResult("Invalid input");
        }
    }

    private void loadTempsFromFile() {
        List<Double> temps = dataSource.readTemperatures();
        StringBuilder resultBuilder = new StringBuilder();
        for (double celsius : temps) {
            double fahrenheit = model.celsiusToFahrenheit(celsius);
            resultBuilder.append(String.format("%.2f °C = %.2f °F\n", celsius, fahrenheit));
        }
        view.fileDataResults.setText(resultBuilder.toString());
    }
}
