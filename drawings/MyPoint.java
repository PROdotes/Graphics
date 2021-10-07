package drawings;

import java.awt.*;
import java.util.Random;

public class MyPoint {
    private double xVel, yVel, x, y;
    private final int width, height, size;

    public MyPoint(int width, int height) {
        x = 0;
        y = 0;
        this.width = width;
        this.height = height;
        xVel = getSpeed();
        yVel = getSpeed();
        size = 2;
    }

    public MyPoint(double x, double y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
        xVel = 0;
        yVel = 0;
        width = 0;
        height = 0;
    }


    public void move() {
        x += xVel;
        y += yVel;

        if (x >= width) {
            xVel = getSpeed() * -1;
            x = width;
        } else if (x <= 0) {
            xVel = getSpeed();
            x = 0;
        }

        if (y >= height) {
            yVel = getSpeed() * -1;
            y = height;
        } else if (y <= 0) {
            yVel = getSpeed();
            y = 0;
        }
    }

    private double getSpeed() {
        return new Random().nextDouble() * 2 + 0.5;
    }

    public int intX() {
        return (int) x;
    }

    public int intY() {
        return (int) y;
    }

    public void draw(Graphics2D g2) {
        g2.setColor(Color.yellow);
        g2.fillOval((int) x - size, (int) y - size, size * 2, size * 2);
    }
}
