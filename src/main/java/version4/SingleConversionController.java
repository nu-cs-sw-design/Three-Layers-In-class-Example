package version4;

public class SingleConversionController {
    private final TemperatureEngine engine;
    private final SingleConversionView panel;

    public SingleConversionController(TemperatureEngine engine, SingleConversionView panel) {
        this.engine = engine;
        this.panel = panel;

        panel.cToFButton.addActionListener(e -> convertCToF());
        panel.fToCButton.addActionListener(e -> convertFToC());
    }

    private void convertCToF() {
        try {
            double celsius = Double.parseDouble(panel.getInput());
            double fahrenheit = engine.celsiusToFahrenheit(celsius);
            panel.setResult(String.format("%.2f °F", fahrenheit));
        } catch (NumberFormatException e) {
            panel.setResult("Invalid input");
        }
    }

    private void convertFToC() {
        try {
            double fahrenheit = Double.parseDouble(panel.getInput());
            double celsius = engine.fahrenheitToCelsius(fahrenheit);
            panel.setResult(String.format("%.2f °C", celsius));
        } catch (NumberFormatException e) {
            panel.setResult("Invalid input");
        }
    }
}
