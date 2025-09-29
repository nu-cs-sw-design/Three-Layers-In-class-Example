package version1;

public class Main {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            new TemperatureConverter("temp_data.txt");
        });
    }
}
