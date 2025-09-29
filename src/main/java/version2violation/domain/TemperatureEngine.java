package version2violation.domain;

import version2violation.presentation.TemperatureUI;

public class TemperatureEngine {
    private TemperatureUI ui;

    public void setTemperatureUI(TemperatureUI ui) {
        this.ui = ui;
    }

    public double celsiusToFahrenheit(double celsius) {
        double fahrenheit = (celsius * 9.0 / 5.0) + 32;
        ui.setResult(String.format("%.2f °F", fahrenheit));
        return fahrenheit;
    }

    public double fahrenheitToCelsius(double fahrenheit) {
        double celsius = (fahrenheit - 32) * 5.0 / 9.0;
        ui.setResult(String.format("%.2f °C", celsius));
        return celsius;
    }
}
