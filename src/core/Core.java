package core;

import java.awt.*;
import java.awt.image.BufferStrategy;
import core.component.Window;
import handler.MovementHandler;
import object.ObjectManager;

public class Core extends Canvas implements Runnable {

    private Window mainWindow;

    public static final int WIDTH = 1080, HEIGHT = 840;
    public static final boolean DEBUG = true;

    private boolean running = false;
    private Thread thread;

    private ObjectManager objectManager;

    Core() {
        mainWindow = new Window(WIDTH, HEIGHT, "2D Platformer");
        mainWindow.getWindow().add(this);
        objectManager = new ObjectManager();
        initializeHandlers();
        start();
    }

    private void initializeHandlers(){
        this.addKeyListener(new MovementHandler(getObjectManager()));
    }

    private synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    private synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running) {
                render();
            }
            frames++;
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                if (DEBUG) {
                    //TODO add fps counter to game
                }
                frames = 0;
            }
        }
        stop();
    }

    private void tick() {
        objectManager.tick();
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        if(!(g instanceof Graphics2D)){
            return;
        }

        Graphics2D g2d = (Graphics2D) g;

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WIDTH, HEIGHT-100);

        objectManager.render(g2d);

        g.dispose();
        bs.show();
    }

    public ObjectManager getObjectManager() {
        return objectManager;
    }

    public Window getMainWindow() {
        return mainWindow;
    }
}