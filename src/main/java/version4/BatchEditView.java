package version4;

import javax.swing.*;
import java.awt.*;

public class BatchEditView extends JFrame {
    public JTextArea editArea = new JTextArea(10, 20);
    public JButton saveButton = new JButton("Convert Temps");

    public BatchEditView() {
        setTitle("Batch Edit Temperatures");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);

        setLayout(new BorderLayout());

        add(new JScrollPane(editArea), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(saveButton);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public String getEditedText() {
        return editArea.getText();
    }

    public void setText(String text) {
        editArea.setText(text);
    }
}
