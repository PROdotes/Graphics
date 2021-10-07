package Drawings;

import java.awt.*;
import java.util.Random;

public class Line {
    private final MyPoint p1;
    private final MyPoint p2;
    private final Color color;
    private final int width;

    public Line(int max_width, int max_height) {
        p1 = new MyPoint(max_width, max_height);
        p2 = new MyPoint(max_width, max_height);

        Random random = new Random();
        width = random.nextInt(5);
        color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }

    public void move() {
        p1.move();
        p2.move();
    }

    public void draw(Graphics2D g2) {
        g2.setPaint(color);
        g2.setStroke(new BasicStroke(width));
        g2.drawLine(p1.intX(), p1.intY(), p2.intX(), p2.intY());
    }
}
