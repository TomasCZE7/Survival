package handler;

import core.GameMain;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class FunctionKeyHandler implements KeyListener {
    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int key = keyEvent.getKeyCode();
        if(key == KeyEvent.VK_ESCAPE){
            GameMain.core.getSettings().setPause(!GameMain.core.getSettings().isPause());
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}