import java.awt.Color;

public class Paddle extends Sprite {
    // Constants for paddle properties
    private static final int PADDLE_WIDTH = 10;
    private static final int PADDLE_HEIGHT = 100;
    private static final Color PADDLE_COLOR = Color.WHITE;
    private static final int DISTANCE_FROM_EDGE = 40;

    // Constructor
    public Paddle(int panelWidth, int panelHeight, Player player) {
        super(PADDLE_COLOR, PADDLE_WIDTH, PADDLE_HEIGHT, player);

        // Set initial position based on player and distance from the edge
        if (player == Player.One) {
            setInitialPosition(DISTANCE_FROM_EDGE, panelHeight / 2 - (PADDLE_HEIGHT / 2));
        } else {
            setInitialPosition(panelWidth - DISTANCE_FROM_EDGE - PADDLE_WIDTH, panelHeight / 2 - (PADDLE_HEIGHT / 2));
        }

        // Call resetToInitialPosition to set the initial position
        resetToInitialPosition();
    }
}
