package version3.presentation;

import javax.swing.*;
import java.awt.*;

public class TemperatureView extends JFrame {
    JTextField inputField = new JTextField(10);
    JButton cToFButton = new JButton("C → F");
    JButton fToCButton = new JButton("F → C");
    JLabel resultLabel = new JLabel("Result: ");
    JButton loadButton = new JButton("Load Data");
    JTextArea fileDataResults = new JTextArea(5, 20);

    public TemperatureView() {
        setTitle("Temperature Converter VERSION 3: Three Layers + MVC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLayout(new FlowLayout());

        add(new JLabel("Enter value:"));
        add(inputField);
        add(cToFButton);
        add(fToCButton);
        add(resultLabel);
        add(loadButton);
        add(new JScrollPane(fileDataResults));

        setVisible(true);
    }

    public String getInput() {
        return inputField.getText();
    }

    public void setResult(String result) {
        resultLabel.setText("Result: " + result);
    }
}
