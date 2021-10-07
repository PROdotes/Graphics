package inputs;

import graphics.MyPanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyboard implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_R) {
            MyPanel.reset();
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            MyPanel.toggle();
        } else if (e.getKeyCode() == 107) {
            MyPanel.makeLines();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
