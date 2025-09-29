package version4;

import java.util.List;

public class BatchConversionController implements Observer {

    private TemperatureEngine engine;
    private TemperatureDataSource dataSource;
    private BatchConversionView view;
    private BatchDataModel model;

    public BatchConversionController(TemperatureEngine engine, BatchConversionView view, TemperatureDataSource dataSource, BatchDataModel model){
        this.engine = engine;
        this.view = view;
        this.dataSource = dataSource;
        this.model = model;
        this.model.addObserver(this); // this class wants to know whenever BatchDataModel's state changes

        view.loadButton.addActionListener(e -> loadTempsFromFile());
    }

    private void loadTempsFromFile() {
        List<Double> temps = dataSource.readTemperatures();
        model.setTemperatures(temps);
        displayTemperatures(temps);
    }

    private void displayTemperatures(List<Double> temps){
        StringBuilder resultBuilder = new StringBuilder();
        for (double celsius : temps) {
            double fahrenheit = engine.celsiusToFahrenheit(celsius);
            resultBuilder.append(String.format("%.2f °C = %.2f °F\n", celsius, fahrenheit));
        }
        view.fileDataResults.setText(resultBuilder.toString());
    }

    public void update(){
        displayTemperatures(model.temperatures);
    }
}
