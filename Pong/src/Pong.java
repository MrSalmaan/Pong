import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Pong extends JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Pong();
        });
    }

    public Pong() {
        setTitle("Pong");
        setSize(800, 600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(new PongPanel()); // Add the PongPanel to the frame
        setVisible(true);
    }
}

