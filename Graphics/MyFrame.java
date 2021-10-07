package Graphics;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    public MyFrame() {
        MyPanel panel = new MyPanel();
        add(panel);
        pack();

        setResizable(false);
        setBackground(Color.black);
        setTitle("WINDOW");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setVisible(true);
    }

    public static int getFPS() {
        return 200;
    }
}
