package version4;

import javax.swing.*;
import java.awt.*;

public class SingleConversionView extends JPanel {
    public JTextField inputField = new JTextField(10);
    public JButton cToFButton = new JButton("C → F");
    public JButton fToCButton = new JButton("F → C");
    public JLabel resultLabel = new JLabel("Result: ");

    public SingleConversionView() {
        setLayout(new FlowLayout());

        add(new JLabel("Enter value:"));
        add(inputField);
        add(cToFButton);
        add(fToCButton);
        add(resultLabel);
    }

    public String getInput() {
        return inputField.getText();
    }

    public void setResult(String result) {
        resultLabel.setText("Result: " + result);
    }
}
