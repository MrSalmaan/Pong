import javax.swing.JFrame;

public class Pong extends JFrame {
    // Define final static variables
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final String TITLE = "Pong";

    public Pong() {
        setTitle(TITLE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Pong();
    }
}
