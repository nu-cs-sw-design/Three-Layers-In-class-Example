package version4;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {
    public final SingleConversionView singleConversionView;
    public final BatchConversionView batchConversionView;

    public MainView(SingleConversionView singleConversionView, BatchConversionView batchConversionView) {
        setTitle("Temperature Converter VERSION 4: Full-On MVC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 250);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        this.batchConversionView = batchConversionView;
        this.singleConversionView = singleConversionView;

        add(singleConversionView, BorderLayout.NORTH);
        add(batchConversionView, BorderLayout.CENTER);

        setVisible(true);
    }
}
