package handler;

import object.ObjectManager;
import object.ally.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MovementHandler implements KeyListener {

    private ObjectManager objectManager;

    public MovementHandler(ObjectManager objectManager){
        this.objectManager = objectManager;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        int movementVelocity = 4;
        Player player = objectManager.getPlayer();
        if(key == KeyEvent.VK_W){
            player.setYVelocity(-movementVelocity);
        }
        if(key == KeyEvent.VK_A){
            player.setXVelocity(-movementVelocity);
        }
        if(key == KeyEvent.VK_S){
            player.setYVelocity(movementVelocity);
        }
        if(key == KeyEvent.VK_D){
            player.setXVelocity(movementVelocity);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        Player player = objectManager.getPlayer();
        if(key == KeyEvent.VK_W){
            player.setYVelocity(0);
        }
        if(key == KeyEvent.VK_A){
            player.setXVelocity(0);
        }
        if(key == KeyEvent.VK_S){
            player.setYVelocity(0);
        }
        if(key == KeyEvent.VK_D){
            player.setXVelocity(0);
        }
    }
}
