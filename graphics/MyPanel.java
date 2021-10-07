package graphics;

import drawings.Line;
import drawings.MyPoint;
import inputs.MyKeyboard;
import inputs.MyMouse;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MyPanel extends JPanel implements Runnable {

    private static final double scale = 100;
    private static final int WIDTH = (int) (19*scale);
    private static final int HEIGHT = (int) (9*scale);
    private static final Dimension SCREEN = new Dimension(WIDTH, HEIGHT);
    private static int mouseX, mouseY;
    private static boolean foregroundToggle = true;

    private static final ArrayList<Line> lines = new ArrayList<>();
    private static final ArrayList<MyPoint> blobs = new ArrayList<>();

    public MyPanel() {
        setFocusable(true);
        setPreferredSize(SCREEN);

        reset();

        addKeyListener(new MyKeyboard());
        addMouseMotionListener(new MyMouse());
        addMouseListener(new MyMouse());

        Thread gameThread = new Thread(this);
        gameThread.start();
    }

    public static void reset() {
        lines.clear();
        blobs.clear();
        makeLines();
    }

    public static void makeLines() {
        for (int counter = 0; counter < 10; counter++) {
            lines.add(new Line(WIDTH, HEIGHT));
        }
    }

    public static void addBlob(int x, int y) {
        blobs.add(new MyPoint(x,y,5));
    }

    public static void toggle() {
        foregroundToggle = !foregroundToggle;
    }

    public static void moveMouse(int x, int y) {
        mouseX = x; mouseY = y;
    }


    @Override
    public void run() {

        long lastTime = System.nanoTime();
        double bil = 1000.0 * 1000 * 1000;
        double ns = bil / MyFrame.getFPS();
        double delta = 0;

        while (true) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1) {
                moveLines();
                repaint();
                delta--;
            }
        }
    }

    private void moveLines() {
        for (Line line : lines) {
            line.move();
        }
    }


    public void paint(Graphics g) {
        Image image = createImage(getWidth(), getHeight());
        Graphics graphics = image.getGraphics();
        draw((Graphics2D) graphics);
        g.drawImage(image, 0, 0, this);
    }

    private void draw(Graphics2D g2) {
        if (foregroundToggle) {
            drawLines(g2);
            drawDots(g2);
        } else {
            drawDots(g2);
            drawLines(g2);
        }
        drawMouse(g2);
        drawText(g2);
    }

    private void drawDots(Graphics2D g2) {
        for (MyPoint point : blobs) {
            point.draw(g2);
        }
    }

    private void drawLines(Graphics2D g2) {
        for (Line line : lines) {
            line.draw(g2);
        }
    }

    private void drawMouse(Graphics2D g2) {
        g2.setColor(Color.gray);
        g2.fillOval(mouseX-5, mouseY-5, 10,10);
    }

    private void drawText(Graphics2D g2) {
        g2.setColor(Color.white);
        g2.drawString("R to reload, click to 'paint'", 5, 15+17);
        g2.drawString("Space to toggle drawing to foreground/background", 5, 15+17+17);
        g2.drawString("+ for 10 more lines ("+lines.size()+")", 5, 15+17+17+17);
    }
}
