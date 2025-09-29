package version4;

import javax.swing.*;
import java.awt.*;

public class BatchConversionView extends JPanel{
    public JButton loadButton = new JButton("Load Data");
    public JTextArea fileDataResults = new JTextArea(5, 20);

    public BatchConversionView() {
        setLayout(new BorderLayout());

        JPanel loadButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        loadButtonPanel.add(loadButton);

        add(loadButtonPanel, BorderLayout.NORTH);
        add(new JScrollPane(fileDataResults), BorderLayout.CENTER);
    }

}
