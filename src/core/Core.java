package core;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

import core.component.Window;
import handler.MovementHandler;
import helper.EnvironmentGenerator;
import object.ObjectManager;
import object.entity.EntityManager;
import object.entity.ai.BasicZombie;

public class Core extends Canvas implements Runnable {

    private Window mainWindow;

    public static final Font defaultFont = new Font("default", Font.PLAIN, 15);

    private boolean running = false;
    private Thread thread;

    private Random random;

    private EnvironmentGenerator environmentGenerator;

    private ObjectManager objectManager;
    private EntityManager entityManager;

    private Settings settings;

    private DebugManager debugManager;

    Core(){
        settings = new Settings();
        mainWindow = new Window(settings.getHeight(), settings.getHeight(), "Survival");
        mainWindow.getWindow().add(this);
        objectManager = new ObjectManager();
        debugManager = new DebugManager();
        entityManager = new EntityManager();
        environmentGenerator = new EnvironmentGenerator();
        random = new Random();
        initializeHandlers();
        start();
    }

    private void generateEnvironment() {
        objectManager.initialize();
        environmentGenerator.generateAI(8);
    }

    private void initializeHandlers(){
        this.addKeyListener(new MovementHandler(getObjectManager()));
    }

    private synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Random getRandom() {
        return random;
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;

        //First run
        generateEnvironment();

        //Main cycle
        while (running) {
            if(settings.isPause()){
                continue;
            }
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
                if (settings.isDebug()) {
                    objectManager.getFpsText().setText("FPS: "+frames);
                }
                frames = 0;
            }
        }
        stop();
    }

    private void tick()
    {
        objectManager.tick();
        entityManager.tick();
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
        g.fillRect(0, 0, settings.getWidth(), settings.getHeight());

        objectManager.render(g2d);
        entityManager.render(g2d);

        g.dispose();
        bs.show();
    }

    public Settings getSettings() {
        return settings;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public ObjectManager getObjectManager() {
        return objectManager;
    }

    public Window getMainWindow() {
        return mainWindow;
    }


}