package core.component;

import javax.swing.*;
import java.awt.*;

public class Window {

    private JFrame window;

    public Window(int width, int height, String title){
        this(new Dimension(width, height), title);
    }

    public Window(Dimension size, String title){
        window = new JFrame(title);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setMaximumSize(size);
        window.setMinimumSize(size);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocation(50, 50);
        window.show();
    }

    public JFrame getWindow() {
        return window;
    }

}
