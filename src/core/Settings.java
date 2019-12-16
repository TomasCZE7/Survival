package core;

public class Settings {

    private boolean pause = false;
    private final int width = 1080, height = 740;
    private boolean debug = true;

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public boolean isPause() {
        return pause;
    }

    public boolean isDebug() {
        return debug;
    }

    public void setPause(boolean pause) {
        this.pause = pause;
    }
}
