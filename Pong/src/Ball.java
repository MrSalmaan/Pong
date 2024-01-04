import java.awt.Color;

public class Ball extends Sprite {

    private final static Color BALL_COLOR = Color.WHITE;
    private final static int BALL_WIDTH = 25;
    private final static int BALL_HEIGHT = 25;

    public Ball(int panelWidth, int panelHeight) {
        super(0, 0, 0, 0, BALL_WIDTH, BALL_HEIGHT, BALL_COLOR);
        setInitialPosition(panelWidth / 2 - (getWidth() / 2), panelHeight / 2 - (getHeight() / 2));
        resetToInitialPosition();
    }
}
