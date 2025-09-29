package version2.presentation;

import version2.datasource.TemperatureDataSource;
import version2.domain.TemperatureEngine;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            TemperatureEngine engine = new TemperatureEngine();
            TemperatureDataSource dataSource = new TemperatureDataSource("temp_data.txt");
            new TemperatureUI(engine, dataSource);
        });
    }
}
