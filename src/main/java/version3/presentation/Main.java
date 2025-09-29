package version3.presentation;

import version3.datasource.TemperatureDataSource;
import version3.domain.TemperatureModel;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            TemperatureModel model = new TemperatureModel();
            TemperatureView view = new TemperatureView();
            TemperatureDataSource dataSource = new TemperatureDataSource("temp_data.txt");
            new TemperatureController(model, view, dataSource);
        });
    }
}
