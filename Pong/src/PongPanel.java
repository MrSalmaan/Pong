import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class PongPanel extends JPanel {

    private static final Color BACKGROUND_COLOR = Color.BLACK;
    private static final int TIMER_DELAY = 5;

    private Ball ball; // Ball object for the game

    public PongPanel() {
        setBackground(BACKGROUND_COLOR);
        ball = new Ball(50, 50, 20, 2, 2); // Initial ball parameters
        Timer timer = new Timer(TIMER_DELAY, new TimerListener());
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintDottedLine(g); // Draw the dotted line
        Graphics2D g2d = (Graphics2D) g;

        // Draw the ball
        ball.draw(g2d);
    }

    private void paintDottedLine(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
        g2d.setStroke(dashed);
        g2d.setPaint(Color.WHITE);
        g2d.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight());
        g2d.dispose();
    }

    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            update();
            repaint();
        }
    }

    private void update() {
        ball.move(getWidth(), getHeight()); // Update ball position
    }

    private static class Ball {
        private double x, y, diameter;
        private double speedX, speedY;

        public Ball(double x, double y, double diameter, double speedX, double speedY) {
            this.x = x;
            this.y = y;
            this.diameter = diameter;
            this.speedX = speedX;
            this.speedY = speedY;
        }

        public void move(int panelWidth, int panelHeight) {
            // Update ball position based on speed
            x += speedX;
            y += speedY;

            // Bounce off the walls
            if (x < 0 || x > panelWidth - diameter) {
                speedX = -speedX;
            }
            if (y < 0 || y > panelHeight - diameter) {
                speedY = -speedY;
            }
        }

        public void draw(Graphics2D g2d) {
            // Draw the ball
            Ellipse2D.Double ball = new Ellipse2D.Double(x, y, diameter, diameter);
            g2d.setColor(Color.WHITE);
            g2d.fill(ball);
        }
    }
}



