package version2violation.presentation;

import version2violation.datasource.TemperatureDataSource;
import version2violation.domain.TemperatureEngine;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            TemperatureEngine engine = new TemperatureEngine();
            TemperatureDataSource dataSource = new TemperatureDataSource("temp_data.txt");
            TemperatureUI ui = new TemperatureUI(engine, dataSource);
            engine.setTemperatureUI(ui);
            engine.setTemperatureUI(ui);
        });
    }
}
