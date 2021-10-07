package inputs;

import Graphics.MyPanel;

import javax.swing.event.MouseInputListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MyMouse implements MouseMotionListener, MouseInputListener {

    @Override
    public void mouseDragged(MouseEvent e) {
        MyPanel.moveMouse(e.getX(), e.getY());
        MyPanel.addBlob(e.getX(), e.getY());
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        MyPanel.moveMouse(e.getX(), e.getY());
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
