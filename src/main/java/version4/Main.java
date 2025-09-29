package version4;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // One window
            TemperatureEngine engine = new TemperatureEngine();
            SingleConversionView singleConversionView = new SingleConversionView();
            new SingleConversionController(engine, singleConversionView);

            BatchConversionView batchConversionView = new BatchConversionView();
            TemperatureDataSource dataSource = new TemperatureDataSource("temp_data.txt");
            BatchDataModel model = new BatchDataModel();
            new BatchConversionController(engine, batchConversionView, dataSource, model);
            new MainView(singleConversionView, batchConversionView);

            // another window
            BatchEditView editView = new BatchEditView();
            new BatchEditController(model, editView);

        });
    }
}
