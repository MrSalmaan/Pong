import java.awt.Color;
import java.awt.Rectangle;

public class Sprite {

    private int xPosition;
    private int yPosition;
    private int xVelocity;
    private int yVelocity;
    private int width;
    private int height;
    private Color color;
    private int initialXPosition;
    private int initialYPosition;

    public Sprite(int xPosition, int yPosition, int xVelocity, int yVelocity, int width, int height, Color color) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
        this.width = width;
        this.height = height;
        this.color = color;
        this.initialXPosition = xPosition;
        this.initialYPosition = yPosition;
    }

    public Sprite(Color paddleColor, int paddleWidth, int paddleHeight, Player player) {
		// TODO Auto-generated constructor stub
	}

	public int getXPosition() {
        return xPosition;
    }

    public void setXPosition(int newX, int panelWidth) {
        if (newX < 0) {
            xPosition = 0;
        } else if (newX + width > panelWidth) {
            xPosition = panelWidth - width;
        } else {
            xPosition = newX;
        }
    }

    public int getYPosition() {
        return yPosition;
    }

    public void setYPosition(int newY, int panelHeight) {
        if (newY < 0) {
            yPosition = 0;
        } else if (newY + height > panelHeight) {
            yPosition = panelHeight - height;
        } else {
            yPosition = newY;
        }
    }

    public int getXVelocity() {
        return xVelocity;
    }

    public void setXVelocity(int newXVelocity) {
        xVelocity = newXVelocity;
    }

    public int getYVelocity() {
        return yVelocity;
    }

    public void setYVelocity(int newYVelocity) {
        yVelocity = newYVelocity;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color newColor) {
        color = newColor;
    }

    public void setInitialPosition(int initialX, int initialY) {
        initialXPosition = initialX;
        initialYPosition = initialY;
    }

    public void resetToInitialPosition() {
        xPosition = initialXPosition;
        yPosition = initialYPosition;
    }

    public Rectangle getRectangle() {
        return new Rectangle(getXPosition(), getYPosition(), getWidth(), getHeight());
    }
}


