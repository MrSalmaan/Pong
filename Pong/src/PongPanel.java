import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;
import javax.swing.Timer;

public class PongPanel extends JPanel implements ActionListener {

    private final static Color BACKGROUND_COLOUR = Color.BLACK;
    private final static int TIMER_DELAY = 5;

    private double ballX = 50;  // X-coordinate of the ball
    private double ballY = 50;  // Y-coordinate of the ball
    private double ballSpeedX = 2;  // Speed of the ball in the X direction
    private double ballSpeedY = 2;  // Speed of the ball in the Y direction

    public PongPanel() {
        setBackground(BACKGROUND_COLOUR);
        Timer timer = new Timer(TIMER_DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Draw the ball
        Ellipse2D.Double ball = new Ellipse2D.Double(ballX, ballY, 20, 20);
        g2d.setColor(Color.WHITE);
        g2d.fill(ball);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        update();
        repaint();
    }

    private void update() {
        // Update ball position based on speed
        ballX += ballSpeedX;
        ballY += ballSpeedY;

        // Reverse direction if ball hits the border
        if (ballX < 0 || ballX > getWidth() - 20) {
            ballSpeedX = -ballSpeedX;
        }
        if (ballY < 0 || ballY > getHeight() - 20) {
            ballSpeedY = -ballSpeedY;
        }
    }
}



