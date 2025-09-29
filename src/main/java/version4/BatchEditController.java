package version4;

import java.util.ArrayList;
import java.util.List;

public class BatchEditController implements Observer{
    private final BatchDataModel model;
    private final BatchEditView view;

    public BatchEditController(BatchDataModel model, BatchEditView view) {
        this.model = model;
        this.view = view;
        this.model.addObserver(this);

        view.saveButton.addActionListener(e -> saveEditedTemperatures());
    }

    private void saveEditedTemperatures() {
        String text = view.getEditedText();
        String[] lines = text.split("\\n");
        List<Double> temps = new ArrayList<>();

        for (String line : lines) {
            try {
                temps.add(Double.parseDouble(line.trim()));
            } catch (NumberFormatException e) {
                // Optionally skip bad entries or show an error
            }
        }

        model.setTemperatures(temps); // Notifies observers
    }

    private void displayTemperatures(List<Double> temps){
        StringBuilder resultBuilder = new StringBuilder();
        for (double celsius : temps) {
            resultBuilder.append(String.format("%.2f\n", celsius));
        }
        view.editArea.setText(resultBuilder.toString());
    }

    @Override
    public void update(){
        displayTemperatures(model.temperatures);
    }
}
